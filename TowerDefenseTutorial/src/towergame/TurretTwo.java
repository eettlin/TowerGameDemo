package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretTwo extends Turret {
	public TurretTwo() {
		super(ImageCache.getSequentialImages("turretlist/Dragon02Render/", 1, 45, ".png", 3));
	}

	@Override
	public Bullet createBullet() {
		return new Bullet(ImageCache.getImage("bullets/b1.png"));
	}

	@Override
	public double getBulletSpeed() {
		return 25;
	}
	
	@Override
	public int getTurretValue() {
		return 200;
	}
}
