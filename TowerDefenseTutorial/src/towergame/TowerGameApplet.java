package towergame;

import java.awt.Color;

import jgame.GRootContainer;
import jgame.GameApplet;
import jgame.ImageCache;
import jgame.SoundManager;

public class TowerGameApplet extends GameApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TowerGameApplet() {
		ImageCache.create(TowerGameApplet.class, "/towergame/tgrsc/tgimages/");
		SoundManager
				.create(TowerGameApplet.class, "/towergame/tgrsc/tgsounds/");

		GRootContainer root = new GRootContainer(Color.BLACK);
		core.setRootContainer(root);

		TGMenuView tgmv = new TGMenuView();
		root.addView(Views.MENU, tgmv);

		TGLevelOneView tgl1v = new TGLevelOneView();
		root.addView(Views.LEVEL_ONE, tgl1v);
	}

	public enum Views {
		MENU, LEVEL_ONE, GAME_OVER;
	}

}
