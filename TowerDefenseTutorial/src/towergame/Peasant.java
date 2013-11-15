package towergame;

import java.awt.Image;
import java.awt.Polygon;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.PolygonController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.FrameListener;

public class Peasant extends GSprite {
	public Peasant() {
		super(ImageCache.getSequentialImages("enemies/peasant/peasant", 1, 19,
				".png", 3));

		FrameListener fl = new FrameListener() {

			@Override
			public void invoke(GObject target, Context context) {
				movePeasant();

			}
		};
		addListener(fl);
	}

	public void movePeasant() {
		//waypoints to follow map bg6.png in the areas folder
		int[] x = new int[] { 204, 842, 817, 792, 767, 742, 716, 691, 665, 639,
				614, 588, 562, 537, 512, 486, 461, 436, 410, 385, 360, 335,
				313, 299, 308, 285, 260, 235, 210, 185, 161, 138, 117, 97, 80,
				35, 10 };
		int[] y = new int[] { 3, 276, 275, 272, 271, 272, 273, 272, 272, 272,
				273, 273, 273, 272, 271, 271, 270, 272, 272, 274, 276, 279,
				291, 312, 336, 347, 350, 352, 350, 345, 337, 327, 313, 296,
				276, 274, 273 };
		//new polygon according to waypoints generated
		Polygon p = new Polygon(x, y, 37);
		
		PolygonController pc = new PolygonController(p);
		
		pc.goToStart(this);
		pc.setRotateToFollow(false);

		double slowness = getSlowness();
		pc.setMaxSpeed(slowness * 3);
		this.addController(pc);

		BoundaryRemovalListener brl = new BoundaryRemovalListener();
		this.addListener(brl);
		
	}
	
	public double getSlowness() {
		return 5;
	}

}
