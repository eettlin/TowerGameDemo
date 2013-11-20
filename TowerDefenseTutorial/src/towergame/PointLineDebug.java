package towergame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import jgame.GObject;

public class PointLineDebug extends GObject {

	private static final int BORDER = 3;
	private Point p1;
	private Point p2;

	// draw a line between p1 and p2
	public PointLineDebug(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;

	}

	@Override
	public void paint(Graphics2D g) { // how do we call this?? By adding to the
										// Turret parent??
		super.paint(g);
		g.setColor(Color.getHSBColor(.8f, .8f, .8f));
		/*
		 * final BasicStroke dashed = new BasicStroke(1.0f,
		 * BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, null, 0.0f);
		 */
		// g.setStroke(dashed);;
		g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(),
				(int) p2.getY());
		g.fillOval((int) p2.getX(), (int) p2.getY(), 5, 5);

		g.setColor(Color.RED);
		g.fillOval((int) p1.getX(), (int) p1.getY(), 5, 5);

		// g.fillOval((int)p2.getX(), (int)p2.getY(), (int)p2.getX()+5,
		// (int)p2.getY()+5);

	}

}
