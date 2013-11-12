package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretFour extends Turret {
	public TurretFour(Image i) {
		super(i);
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
