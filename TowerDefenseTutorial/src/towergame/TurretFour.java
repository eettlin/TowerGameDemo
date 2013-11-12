package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretFour extends Turret {
	public TurretFour() {
		super(ImageCache.getSequentialImages("turretlist/Dragon04Render/", 1, 45, ".png", 3));
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 30;
	}
}
