package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretOne extends Turret {
	public TurretOne(){
		super(ImageCache.getSequentialImages("turretlist/Dragon01Render/", 1, 45, ".png", 3));
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 5;
	}

	@Override
	public int getTurretValue() {
		return 100;
	}


}
