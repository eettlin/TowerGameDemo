package towergame;

import jgame.GContainer;
import jgame.ImageCache;

public class l1PlayArea extends GContainer {

	public l1PlayArea() {
		setSize(800, 600);
		setBackgroundSprite(ImageCache.getSprite("areas/bg2.png"));
		setAnchorTopLeft();
	}
}
