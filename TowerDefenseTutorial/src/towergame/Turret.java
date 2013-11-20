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

	private double ate2 = 0;
	private PointLineDebug pld;
	private Point pt1;
	private Point pt2;

	private int counter = 5;

	public Turret(List<Image> listImages) {
		super(listImages);
		setScale(1.0);
		this.setPlaying(false);
		this.addListener(new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {

				List<Peasant> pl = context.getInstancesOfClass(Peasant.class);
				double closest = Integer.MAX_VALUE;
				Peasant currentPeasant = null;
				if (pl.isEmpty()) {
					return;
				}
				for (Peasant p : pl) {
					double dist = target.distanceTo(p);
					if (dist < closest) {
						closest = dist;
						currentPeasant = p;
					}
				}

				if (currentPeasant != null) {
					double angleToEnemy = target.angleTo(currentPeasant);
					if ((angleToEnemy %= 360) < 0) {
						angleToEnemy += 360;
					}
					ate2 = angleToEnemy;
					pld = new PointLineDebug(new Point((int) currentPeasant
							.getX(), (int) currentPeasant.getY()), new Point(
							(int) target.getX(), (int) target.getY()));
					addSibling(pld);
					int frameIndex = (int) (angleToEnemy / 8);
					setFrameNumber(frameIndex);
					if (--counter == 0) {
						counter = 5;
						fireBullet(ate2);
					}
				}
			}
		});
	}// constructor

	public abstract Bullet createBullet();

	public abstract double getBulletSpeed();

	public abstract int getTurretValue();

	public void fireBullet(double ate) {
		final Bullet b = createBullet();
		b.setRotation(ate);

		final ConstantMovementController c = ConstantMovementController
				.createPolar(getBulletSpeed(), ate); // ate = angle to enemy
		b.addController(c);
		snapAnchor(b);
		b.moveAtAngle(getScaleX() * (getWidth() / 2) + 3, ate);
		b.setScale(.8);
		this.addSibling(b);
	}

} // Class

