package towergame;

import java.awt.Color;
import java.awt.Font;

import jgame.Context;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;

public class l1InfoArea extends GSprite {
	
	private GMessage bankValue = new GMessage();
	
	public l1InfoArea(final Bank bv) {  // sets the reference to final value
		super(ImageCache.forClass(TowerGame.class).get("/areas/infoarea.png"));
		
//		setBankValue(bv.getBankValue());
		bankValue.setLocation(100, 30);
		this.add(bankValue);
		
		bankValue.setColor(Color.YELLOW);
		bankValue.setFontSize(50);
		bankValue.setFontStyle(Font.BOLD|Font.ITALIC);
		
		FrameListener bvfl = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				setBankValue(bv.getBankValue());
			}
		};
		addListener(bvfl);
	}
	
	
	public void setBankValue(int bv)
	{
		
		bankValue.setText("Bank Value = " + Integer.toString(bv)); 
	}
}
