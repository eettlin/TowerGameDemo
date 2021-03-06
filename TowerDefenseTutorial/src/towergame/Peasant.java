package towergame;

import java.awt.Polygon;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;

public class Peasant extends GSprite {

	private double maxHealthPoints = 100;
	private double currentHealth;
	HealthBar hb = new HealthBar();

	public Peasant(double maxHealthPoints) {
		super(ImageCache.getSequentialImages("enemies/peasant/peasant", 1, 19,
				".png", 3));

		this.maxHealthPoints = maxHealthPoints;
		this.currentHealth = this.maxHealthPoints;

		hb.setWidth(getWidth());
		addAtCenter(hb);
		hb.setY(this.getHeight() - hb.getHeight() / 2);
		hb.setHealthPercentage(1);

		// waypoints to follow map bg6.png in the areas folder
		int[] x = new int[] { 742, 716, 691, 665, 639, 614, 588, 562, 537, 512,
				486, 461, 436, 410, 385, 360, 335, 313, 299, 308, 285, 260,
				235, 210, 185, 161, 138, 117, 97 };
		int[] y = new int[] { 272, 273, 272, 272, 272, 273, 273, 273, 272, 271,
				271, 270, 272, 272, 274, 276, 279, 291, 312, 336, 347, 350,
				352, 350, 345, 337, 327, 313, 296 };
		for (int i = 0; i < y.length; i++) {
			y[i] += 250;
		}
		// new polygon according to waypoints generated
		Polygon p = new Polygon(x, y, 29);

		PolygonController pc = new PolygonController(p);

		FrameListener flCheckBounds = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				if (target.distanceTo(97, 296 + 250) < 3) {
					getFirstAncestorOf(TGLevelOneView.class)
							.changeLifeBankValue(-10);
					target.removeSelf();
				}
			}
		};
		addListener(flCheckBounds);

		pc.goToStart(this);
		pc.setRotateToFollow(false);

		double slowness = getSlowness();
		pc.setMaxSpeed(slowness * 3);
		this.addController(pc);

		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		this.addListener(brl);

	}

	public void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
		hb.setHealthPercentage(this.currentHealth / maxHealthPoints);
	}

	public void setHealthPoints(int healthPoints) {
		this.maxHealthPoints = healthPoints;
	}

	public void changeHealthPoints(int i) {
		currentHealth += i;
		hb.setHealthPercentage(this.currentHealth / maxHealthPoints);
		// System.out.println(currentHealth);
	}

	public double getHealthPoints() {
		return currentHealth;
	}

	public double getSlowness() {
		return 5;
	}

}
