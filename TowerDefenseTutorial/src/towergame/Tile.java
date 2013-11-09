package towergame;

import java.awt.Image;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class Tile extends GButton {

	
	public Tile( Image image) {
		
		
		setSize(80, 80);

		GSprite sNone = ImageCache.getSprite("tiles/tilenone.png");
		GSprite sHover = ImageCache.getSprite("tiles/tilehover.png");
		GSprite sPressed = ImageCache.getSprite("tiles/tilepressed.png");

		setStateSprite(ButtonState.NONE, sNone);
		setStateSprite(ButtonState.HOVERED, sHover);
		setStateSprite(ButtonState.PRESSED, sPressed);

		GSprite tIcon = new GSprite(image);
		tIcon.setScale(0.8);
		addAtCenter(tIcon);

		addListener(new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				getFirstAncestorOf(TGLevelOneView.class).initializeTurret();
			}
		});
	}
}
