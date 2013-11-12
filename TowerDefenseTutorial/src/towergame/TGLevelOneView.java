package towergame;

import java.awt.Color;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.ImageCache;
import jgame.controller.MouseLocationController;
import jgame.listener.LocalClickListener;

public class TGLevelOneView extends GContainer {
	
	private LOnePlayArea pal1 = new LOnePlayArea();
	private l1InfoArea ial1 = new l1InfoArea();
	private MenuArea mal1 = new MenuArea();
	
	private boolean settingTurret = false;
    
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
		if(settingTurret)
		{
			return;
		}
		settingTurret = true;
		
		Turret t  = chooseTurret(tn);
		this.pal1.addAtCenter(t);
		
		final MouseLocationController mlc = new MouseLocationController();
		t.addController(mlc);
		
		final LocalClickListener dropListener  = new LocalClickListener(){
			@Override
			public void invoke(GObject target, Context context) {
				target.removeController(mlc);
				target.removeListener(this);
				
				settingTurret = false;

			}
			
		};
		t.addListener(dropListener);
	}
	
	public Turret chooseTurret(int turretNumber)
	{
		switch(turretNumber){
		case 0:
			return new TurretOne();
		case 1:
			return new TurretTwo();
		case 2:
			return new TurretThree();
		case 3:
			return new TurretFour();
		case 4:
			return new TurretFive();
		
		default:
			return null;
		}
		
		
	}
	
    
	
}
