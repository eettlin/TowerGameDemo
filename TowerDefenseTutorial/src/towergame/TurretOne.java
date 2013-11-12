package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretOne extends Turret {
	public TurretOne(Image image) {
		super(image);
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
