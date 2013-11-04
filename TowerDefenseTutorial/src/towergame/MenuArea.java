package towergame;



import java.awt.Color;
import java.awt.Image;
import java.awt.List;
import java.awt.image.BufferedImage;

import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;

public class MenuArea extends GContainer {

	

	public MenuArea() {
		setSize(500, 100);
		this.setBackgroundColor(Color.BLACK);

		BufferedImage bg = ImageCache.forClass(TowerGame.class).get(
				"buttons/Tile.png");

		// set enemies
		GSprite bi = new GSprite(bg);
		setBackgroundSprite(bi);

		for (int i = 0; i < 5; i++) {
			setTile(i);
		}
	}

	
	 List <Image> tileImages = ImageCache.forClass(TowerGame.class).getSequential( "tiles/t", 1, 5,".png"); 
	 
	private void setTile(int i) {
		Tile tile = new Tile();
		tile.setAnchorTopLeft();
		tile.setScale(.95);
		tile.setY(i * 95 + 10);
		add(tile);
	}

}
