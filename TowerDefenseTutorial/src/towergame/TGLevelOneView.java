package towergame;

import java.awt.Color;

import jgame.GContainer;

public class TGLevelOneView extends GContainer {
	
	private LOnePlayArea pal1 = new LOnePlayArea();
	private l1InfoArea ial1 = new l1InfoArea();
	private MenuArea mal1 = new MenuArea();
	
	public TGLevelOneView() {
		setSize(900,700);
		
		pal1.setAnchorTopLeft();
		pal1.setLocation(100, 0);
		add(pal1);
		
		ial1.setAnchorTopLeft();
		ial1.setLocation(0, 600);
		add(ial1);
		
		mal1.setAnchorTopLeft();
		mal1.setLocation(0, 0);
		add(mal1);
		setBackgroundColor(Color.BLACK);
	}
}
