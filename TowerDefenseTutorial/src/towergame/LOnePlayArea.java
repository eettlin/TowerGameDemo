package towergame;

import jgame.GContainer;
import jgame.ImageCache;

public class LOnePlayArea extends GContainer {

	PlayAreaSky sky;

	public LOnePlayArea() {
		
		/*sky = new PlayAreaSky();
		setSize(800, 600);
		addAtCenter(sky);*/
		
		setBackgroundSprite(ImageCache.getSprite("areas/bg2.png"));
		setAnchorTopLeft();
		
		
	}
}
