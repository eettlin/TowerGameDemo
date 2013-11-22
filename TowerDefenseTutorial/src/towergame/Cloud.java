package towergame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.GSprite;
import jgame.ImageCache;

public class Cloud extends GSprite {

	/*
	 * You can use `public final' to have security iff the variable you're
	 * protecting is immutable.
	 * 
	 * Immutable types include all primitives, as well as classes that don't
	 * have any mutators.
	 * 
	 * But, for example, you shouldn't have
	 * 
	 * public final Bank b = new Bank();
	 * 
	 * because then, even though another class can't do someVar.b = anotherBank,
	 * the class can still run b.changeBankValue(999); which would cause the
	 * banking system to collapse.
	 * 
	 * but here int is a primitive so we aight
	 */
	public final int cloudY;

	public Cloud() {
		cloudY = (int) (Math.random() * 200) + 50;
		setImage(createCloudImage(cloudY));
	}

	public static Image createCloudImage(int cloudY) {
		BufferedImage cloud = ImageCache.getImage("areas/cloud.png");
		BufferedImage im = new BufferedImage(800, 300,
				BufferedImage.TYPE_INT_ARGB);

		int cloudX = (int) (Math.random() * 600) + 100;
		double cloudScale = 1.75 - (cloudY * (2 / 300d));

		Graphics2D g = (Graphics2D) im.getGraphics();
		antialias(g);
		goodImageTransforms(g);
		g.drawImage(cloud, cloudX, cloudY,
				(int) (cloud.getWidth() * cloudScale),
				(int) (cloud.getHeight() * cloudScale), null);
		g.dispose();

		return im;
	}
}
