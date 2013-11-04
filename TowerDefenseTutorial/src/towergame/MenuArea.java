package towergame;



import java.awt.Color;
import java.awt.Image;
import java.util.List;

import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class MenuArea extends GContainer {

	

	public MenuArea() {
		setSize(100, 500);
		this.setBackgroundColor(Color.BLACK);

		BufferedImage bg = ImageCache.forClass(TowerGame.class).get(
				"areas/menuarea.png");

		// set enemies
		GSprite bi = new GSprite(bg);
		setBackgroundSprite(bi);

		for (int i = 0; i < 5; i++) {
			setTile(i);
		}
	}

	
	 List <Image> tileImages = ImageCache.getSequentialImages( "tiles/d", 1, 5,".png"); 
	 
	private void setTile(int yLoc) 
	{
		Tile t = new Tile(tileImages.get(yLoc));
		t.setAnchorTopLeft();
		t.setX(5);
		addAtCenter(t);
		t.setX(4);
		t.setLocation(5,yLoc * 115 + 25);
	}

}
