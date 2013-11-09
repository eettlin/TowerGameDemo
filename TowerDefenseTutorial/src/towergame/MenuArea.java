package towergame;



import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.List;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class MenuArea extends GContainer {

	

	public MenuArea() {
		setSize(100, 500);
		this.setBackgroundColor(Color.BLACK);

		BufferedImage bg = ImageCache.getImage("areas/menuarea.png");

		// set enemies
		GSprite bi = new GSprite(bg);
		setBackgroundSprite(bi);

		for (int i = 0; i < 5; i++) {
			setTile(i);
		}
	}

	
	List <Image> tileImages = ImageCache.getSequentialImages( "tiles/d", 1, 5,".png"); 
	 
	private void setTile(int i) 
	{
		Tile t = new Tile(tileImages.get(i));
		t.setAnchorTopLeft();
		addAtCenter(t);
		t.setScale(0.9);
		t.setX(4);
		t.setLocation(5,i * 115 + 25);
	}

}
