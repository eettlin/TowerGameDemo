package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretFour extends Turret {
	public TurretFour() {
		super(ImageCache.getSequentialImages("turretlist/p1", 1, 8, ".png", 3));
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 1;
	}
}
