package towergame;

import java.awt.Image;

import jgame.ButtonState;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;

public class Tile extends GButton {
	
	public Tile(Image image) {
		setSize(92, 96);
		GSprite sNone = ImageCache.getSprite("tiles/tile.png");
		setStateSprite(ButtonState.NONE, sNone);
		GSprite sIcon = new GSprite(image);
		sIcon.setScale(0.8);
		addAtCenter(sIcon);
	}
}
