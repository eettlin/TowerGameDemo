package towergame;

import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.Interpolation;
import jgame.controller.MovementTween;
import jgame.controller.ScaleTween;

public class LOnePlayArea extends GContainer {

	public LOnePlayArea() {

		SkyObject sky = new SkyObject();
		add(sky);

		final Sun sun = new Sun();//Add sun and moon before background is placed
		addAt(sun, 700, 100);
		final Moon moon = new Moon();
		addAt(moon, 150, 700);
		
		BufferedImage bg = ImageCache.forClass(TowerGame.class).get(
				"areas/bg6.png");
		GSprite gs = new GSprite(bg);
		addAt(gs, 400, 425);

		final Falg flag1 = new Falg();//mid right
		flag1.setScale(.33);
		addAt(flag1, 98, 400);
		
		final Falg flag2 = new Falg();//far left
		flag2.setScale(.23);
		addAt(flag2, 42, 387);
		
		final Falg flag3 = new Falg();
		flag3.setScale(.23);
		addAt(flag3, 78, 390);
		
		final Falg flag4 = new Falg();//far right
		flag4.setScale(.44);
		addAt(flag4, 112, 374);

		final Cloud cloud1 = new Cloud();  
		addAt(cloud1, 600, 50);
		MovementTween c1mt = new MovementTween(850, Interpolation.LINEAR, -900,	0); // cloud1 movement tween
		cloud1.addController(c1mt);

		final Cloud cloud2 = new Cloud();
		addAt(cloud2, 300, 100);
		MovementTween c2mt = new MovementTween(1250, Interpolation.LINEAR,
				-850, 0); // cloud1 movement tween
		cloud2.addController(c2mt);

		final Cloud cloud3 = new Cloud();
		addAt(cloud3, 500, 200);
		cloud3.setScale(1.5);
		MovementTween c3mt = new MovementTween(1050, Interpolation.LINEAR,
				-1000, 0); // cloud1 movement tween
		cloud3.addController(c3mt);

		MovementTween smt = new MovementTween(900, Interpolation.EASE_OUT,
				-300, 800); // sun movement tween
		sun.addController(smt);

		MovementTween mmt = new MovementTween(600, Interpolation.EASE_OUT, 400,
				-600); // moon movement tween
		moon.addController(mmt);

		ScaleTween st = new ScaleTween(500, 1.2, 1);
		moon.addController(st);
		
		Peasant p1 = new Peasant();
		add(p1);

		setSize(810, 610);
	}
}
