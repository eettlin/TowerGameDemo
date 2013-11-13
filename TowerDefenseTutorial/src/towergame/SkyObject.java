package towergame;

import java.awt.Color;
import java.awt.Graphics2D;

import jgame.Context;
import jgame.GObject;
import jgame.listener.FrameListener;

public class SkyObject extends GObject {

	float skyHue = (float) 0.001;
	
	public SkyObject() {
		this.setSize(90, 15);
	}

	@Override
	public void paint(final Graphics2D g) {
		super.paint(g);

		g.fillRect(0, 0, getIntWidth(), getIntHeight());

		FrameListener fl = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				skyHue += 0.000005;
			}
		};
		addListener(fl);
		g.setColor(Color.getHSBColor( .58f, .47f, .67f));
		g.fillRect(45, 5,900,700);
		
		
//		/System.out.println(skyHue);
	}
}

