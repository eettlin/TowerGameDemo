package towergame;

import jgame.GSprite;
import jgame.ImageCache;

public class TurretPerch extends GSprite {

	public TurretPerch() {
		super(ImageCache.getImage("turrets/perch.png"));
		setAnchorWeightY(0); // origin at top of perch
	}

}
