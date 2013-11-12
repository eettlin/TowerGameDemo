package towergame;

import java.awt.Image;

import jgame.GSprite;
import jgame.listener.BoundaryRemovalListener;

public class Bullet extends GSprite {
	
	public Bullet(Image image) {
		super(image);
		addListener(new BoundaryRemovalListener());
	}
}
