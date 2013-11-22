package towergame;

import java.awt.Color;
import java.awt.Graphics2D;

import jgame.Context;
import jgame.GObject;
import jgame.listener.FrameListener;
import jgame.listener.TimerListener;

public class SkyObject extends GObject {

	private static final float DAY_SKY = 0.8f;
	private static final float NIGHT_SKY = 0.5f;
	float skyValue = (float) 0.80;

	public SkyObject() {
		this.setSize(90, 15);
		TimerListener dl = new TimerListener(72) {
			boolean b = false;

			@Override
			public void invoke(GObject target, Context context) {
				b = !b;
				switchTimeOfDay(b);
			}
		};
		addListener(dl);
	}

	public void switchTimeOfDay(final boolean isNight) {
		final float skyChange = isNight ? -0.01f : 0.01f;
		final float start = isNight ? DAY_SKY : NIGHT_SKY;
		final float end = isNight ? NIGHT_SKY : DAY_SKY;

		skyValue = start;

		FrameListener fl = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				skyValue += skyChange;
				if (isNight ? (skyValue <= end) : (skyValue >= end)) {
					target.removeListener(this);
				}
			}
		};
		addListener(fl);
	}

	@Override
	public void paint(final Graphics2D g) {
		super.paint(g);

		g.fillRect(0, 0, getIntWidth(), getIntHeight());

		/*
		 * FrameListener fl = new FrameListener() {
		 * 
		 * @Override public void invoke(GObject target, Context context) {
		 * skyHue += 0.000005; } }; addListener(fl);
		 */
		g.setColor(Color.getHSBColor(skyValue, skyValue, .67f));
		g.fillRect(45, 5, 900, 700);

		// /System.out.println(skyHue);
	}
}
