package towergame;

import jgame.GSprite;
import jgame.ImageCache;

public class l1InfoArea extends GSprite {
public l1InfoArea() {
	
	super(ImageCache.forClass(TowerGame.class).get("/areas/infoarea.png"));
}
}
