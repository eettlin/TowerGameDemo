package towergame;

import java.awt.Color;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;


public class l1MenuArea extends GContainer {
	
	

        public l1MenuArea() {
                setSize(500, 100);
                this.setBackgroundColor(Color.RED);

                BufferedImage bg = ImageCache.forClass(PhatKids.class).get(
                                "areas/menubg.png");

                // set enemies
                GSprite bi = new GSprite(bg);
                setBackgroundSprite(bi);

                for (int i = 0; i < 5; i++) {
                        setTile(i);
                }

        

}
