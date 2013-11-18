package towergame;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.listener.FrameListener;
import jgame.listener.TimerListener;

public abstract class Turret extends GSprite {
	
	double ate2 = 0;
	public Turret(List<Image> listImages) {
		super(listImages);

		setScale(1.0);
		this.setPlaying(false);
		this.addListener(new TimerListener(3) {
			@Override
			public void invoke(GObject target, Context context) {

				List<Peasant> pl = context.getInstancesOfClass(Peasant.class);
				double clossest  = 10000;
				Peasant currentPeasant = null;
				if(pl.isEmpty())
				{
					return;
				}
				
				for(Peasant p :pl)
				{
					if (target.distanceTo(p) < clossest) 
					{
						System.out.println("--> " + target.distanceTo(p));
						clossest = target.distanceTo(p);
						currentPeasant = p;
					}
				}
				
				Point pt = new Point((int)currentPeasant.getX(),(int)currentPeasant.getY());
				
				if (pt != null) {
					//System.out.println("pt" + pt);
					
					double angleToEnemy = target.angleTo(pt);
					angleToEnemy %= 360;
					
					if (angleToEnemy < 0) {
						angleToEnemy += 360;
					}
					ate2 = angleToEnemy;
					int frameIndex = (int) (angleToEnemy / 8);
					setFrameNumber(frameIndex);
					fireBullet(angleToEnemy);
				}
			}
		});
	}// constructor

	public abstract Bullet createBullet();
	public abstract double getBulletSpeed();
	public abstract int getTurretValue();

	public void fireBullet(double ate) {
		final Bullet b = createBullet();
		b.setRotation(ate2);
		final ConstantMovementController c = ConstantMovementController
				.createPolar(getBulletSpeed(), ate2);  // ate = angle to enemy
		b.addController(c);
		snapAnchor(b);
		b.moveAtAngle(getScaleX() * (getWidth() / 2) + 3, ate2);
		b.setScale(.2);
		this.addSibling(b);
	}

} // Class

