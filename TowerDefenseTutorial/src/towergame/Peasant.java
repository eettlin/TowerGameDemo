package towergame;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;

public class Peasant extends GSprite {
	public Peasant() {
		super(ImageCache.getSequentialImages("enemies/peasant/peasant", 1, 19, ".png", 3));
		
		FrameListener fl = new FrameListener() {
			
			@Override
			public void invoke(GObject target, Context context) {
				movePeasant();
				
			}
		};
		addListener(fl);
	}
	
	public void movePeasant(){
		this.setX(getX()-1);
		if(this.getX() < 0)
		{
			this.setX(800);
		}
	}

}
