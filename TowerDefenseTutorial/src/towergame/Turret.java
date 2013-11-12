package towergame;

import java.awt.Image;
import java.awt.Point;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantMovementController;
import jgame.listener.FrameListener;

public abstract class Turret extends GSprite {
	public Turret(List<Image> listImages) {
		super(listImages);

		setScale(.25);
		this.setPlaying(false);
		this.addListener(new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {

				Point pt = context.getMouseRelative();
				if (pt != null) {
					double faceX = pt.getX();
					double faceY = pt.getY();

					double angleToEnemy = target.angleTo(faceX, faceY);
					angleToEnemy -= 45;
					angleToEnemy %= 360;
					if (angleToEnemy < 0) {
						angleToEnemy += 360;
					}
					int frameIndex = (int) (angleToEnemy / 45);
					setFrameNumber(frameIndex);
					fireBullet();
				}
			}
		});
	}// constructor

	public abstract Bullet createBullet();

	public abstract double getBulletSpeed();

	public void fireBullet() {
		final Bullet b = createBullet();
		b.setRotation(this.getRotation());
		final ConstantMovementController c = ConstantMovementController
				.createPolar(getBulletSpeed(), getRotation());
		b.addController(c);
		snapAnchor(b);
		b.moveAtAngle(getWidth() / 2 + 20, getRotation());
		this.addSibling(b);
	}

} // Class

