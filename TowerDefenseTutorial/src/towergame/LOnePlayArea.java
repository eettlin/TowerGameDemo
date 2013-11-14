package towergame;







import java.awt.Image;
import java.awt.image.BufferedImage;

import jgame.Context;
import jgame.GContainer;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantMovementController;
import jgame.controller.Interpolation;
import jgame.controller.MovementTween;
import jgame.controller.ScaleTween;
import jgame.listener.DelayListener;

public class LOnePlayArea extends GContainer {


	public LOnePlayArea() {
		
		SkyObject sky = new SkyObject();
		add(sky);
		
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get("areas/bg6.png");
        GSprite gs = new GSprite(bg);
        addAt(gs, 400, 430);
        
        final Falg flag1 = new Falg();
        
        final Sun sun  = new Sun();
        addAt(sun, 700,100);
        final Moon moon = new Moon();
        addAt(moon, 0, 100);
        
        final Cloud cloud1 = new Cloud();
        addAt(cloud1, 600, 50);
        MovementTween  c1mt = new MovementTween(850, Interpolation.LINEAR ,-900, 0);  //  cloud1 movement tween
        cloud1.addController(c1mt);
        
        final Cloud cloud2 = new Cloud();
        addAt(cloud2, 300, 100);
        MovementTween  c2mt = new MovementTween(1250, Interpolation.LINEAR ,-850, 0);  //  cloud1 movement tween
        cloud2.addController(c2mt);
        
        final Cloud cloud3 = new Cloud();
        addAt(cloud3, 500, 200);
        cloud3.setScale(1.5);
        MovementTween  c3mt = new MovementTween(1050, Interpolation.LINEAR ,-1000, 0);  //  cloud1 movement tween
        cloud3.addController(c3mt);
        
        MovementTween  smt = new MovementTween(3000, Interpolation.EASE_OUT ,-600, 0);  //  sun movement tween
        sun.addController(smt);
               
        MovementTween  mmt = new MovementTween(300, Interpolation.EASE_OUT ,600, 0);  //  moom movement tween
        moon.addController(mmt);
                
        ScaleTween st = new ScaleTween(500, .95, .65);
		moon.addController(st);
		
        setSize(810, 610);
	}
}
