package towergame;

import java.awt.Image;

import jgame.GSprite;
import jgame.controller.ConstantRotationController;
import jgame.listener.BoundaryRemovalListener;

public class Bullet extends GSprite {
	
	public Bullet(Image image) {
		super(image);
		addController(new ConstantRotationController(12));
		addListener(new BoundaryRemovalListener());
	}
}
