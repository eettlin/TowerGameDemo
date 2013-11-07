package towergame;

import java.awt.Color;
import java.awt.Graphics2D;

import jgame.GObject;

public class PlayAreaSky extends GObject {

	public PlayAreaSky() {
		this.setSize(800, 600);
	}

	@Override
	public void paint(Graphics2D g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getIntWidth(), getIntHeight());

		g.setColor(Color.getHSBColor(1f, 1f, 1f));
		g.fillRect(0, 0, 800,600);
	}

	

}

