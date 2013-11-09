package towergame;

import java.awt.Image;

import jgame.ImageCache;

public class TurretOne extends Turret {
	
	
	public TurretOne(Image i) {
		// this image parameter is unused
		// but that's all right; that's not the problem
		super(ImageCache.getImage("turrets/dt1.png"));
	}

}
