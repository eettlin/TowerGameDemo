package towergame;

import java.awt.Color;

import jgame.GContainer;

public class TGLevelOneView extends GContainer {
	
	private l1PlayArea pal1 = new l1PlayArea();
	private l1InfoArea ial1 = new l1InfoArea();
	private MenuArea mal1 = new MenuArea();
	
	public TGLevelOneView() {
		setSize(900,700);
		
		addAtCenter(pal1);
		
		ial1.setAnchorTopLeft();
		ial1.setLocation(0, 600);
		add(ial1);
		
		mal1.setAnchorTopLeft();
		mal1.setLocation(0, 0);
		add(mal1);
		setBackgroundColor(Color.BLUE);
	}
}
