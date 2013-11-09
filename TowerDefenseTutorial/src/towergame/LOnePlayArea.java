package towergame;

import java.awt.Image;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class LOnePlayArea extends GContainer {


	public LOnePlayArea() {
		
		setBackgroundSprite(ImageCache.getSprite("areas/bg1.png"));
		setAnchorTopLeft();
		
		TurretOne t2 = new TurretOne(ImageCache.getImage("turrets/dt1.png"));
		this.addAtCenter(t2);
	}
}
