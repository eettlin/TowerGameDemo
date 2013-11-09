package towergame;

import java.awt.Color;
import java.awt.Image;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

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
	
	public void initializeTurret(){
		System.out.println("Initializing a turret");
		GSprite imgs = ImageCache.getSprite("tiles/d3.png");
		Image img  = ImageCache.getImage("tiles/d1.png");
		GSprite imgs2 = new GSprite(img);
		
		TurretOne trt = new TurretOne(ImageCache.getImage("tiles/d1.png"));
		// Okay ; I have tried it in various ways
		
		this.pal1.addAtCenter(trt);
	}
}
