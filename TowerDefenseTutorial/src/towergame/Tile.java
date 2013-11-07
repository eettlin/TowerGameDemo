package towergame;

import java.awt.Image;

import jgame.ButtonState;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;

public class Tile extends GButton {
	
	public Tile(Image image) {
		setSize(80	, 80);
		
		GSprite sNone = ImageCache.getSprite("tiles/tilenone.png");
		GSprite sHover = ImageCache.getSprite("tiles/tilehover.png");
		GSprite sPressed = ImageCache.getSprite("tiles/tilepressed.png");
		
		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);
		
		GSprite tIcon = new GSprite(image);
		tIcon.setScale(0.8);
		addAtCenter(tIcon);
	}
}
