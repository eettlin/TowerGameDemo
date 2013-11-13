package towergame;


import java.awt.image.BufferedImage;

import jgame.GSprite;
import jgame.ImageCache;
import jgame.controller.ConstantRotationController;

public class Sun extends GSprite {
	public Sun() {
		super();
setSize(200, 200);
		
		BufferedImage suni = ImageCache.getImage("areas/corona.png");
        GSprite suns = new GSprite(suni);
        suns.setScale(1);
        addAtCenter(suns);
		
		BufferedImage face = ImageCache.getImage("areas/sunface.png");
        GSprite faces = new GSprite(face);
        faces.setScale(1.1);
        addAt(faces, getWidth()/2, getHeight()/2-6);
        
        ConstantRotationController corona_crc = new ConstantRotationController(-1);
        addController(corona_crc);
        
        ConstantRotationController face_crc = new ConstantRotationController(+1);
        faces.addController(face_crc);
	}
}
