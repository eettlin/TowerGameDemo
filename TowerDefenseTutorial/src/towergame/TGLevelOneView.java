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
	
	public void initializeTurret(int tn){
		//TurretOne t = new TurretOne(ImageCache.getImage("turrets/dt1.png"));
		Turret t  = chooseTurret(tn);
		this.pal1.addAtCenter(t);
	}
	
	public Turret chooseTurret(int turretNumber)
	{
		switch(turretNumber){
		case 0:
			return new TurretOne(ImageCache.getImage("turrets/dt1.png"));
		case 1:
			return new TurretTwo(ImageCache.getImage("turrets/dt2.png"));
		case 2:
			return new TurretThree(ImageCache.getImage("turrets/dt3.png"));
		case 3:
			return new TurretFour(ImageCache.getImage("turrets/dt4.png"));
		case 4:
			return new TurretFive(ImageCache.getImage("turrets/dt5.png"));
		
		default:
			return null;
		}
		
		
	}
	
    
	
}
