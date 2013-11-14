package towergame;

import java.awt.Image;
import java.util.List;

import jgame.GSprite;
import jgame.ImageCache;

public class Falg extends GSprite {
	public Falg() {
		super(ImageCache.getSequentialImages("areas/flag/flag", 1, 54, ".png", 3));
	}
}
