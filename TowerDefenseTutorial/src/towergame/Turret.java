package towergame;

import java.awt.Image;

import jgame.GSprite;

public abstract class Turret extends GSprite {
	Image i; // also don't need this

	public Turret(Image image) {
		// What you're trying to do here is set the image of this turret to the
		// passed image, right?

		// There's no need to chain another GSprite in here.

		// i = image;
		// GSprite tImage = new GSprite(i);
		// addAtCenter(tImage);
		super(image);

		// So this constructor is really just one line.

		// Summary:
		//
		// THE PROBLEM:
		// You were adding a GSprite to another GSprite. This is fine, except
		// that you hadn't sized the parent GSprite, so the default size was (0,
		// 0), causing the child GSprite to clip off.
		//
		// THE SOLUTION:
		// GSprites are made for displaying images. You don't need a child to do
		// that. You can just call the super constructor, or, equivalently, call
		// setImage(image).
		//
		// ALTERNATIVELY:
		// You *could have* used the previous method if you had sized this
		// component correctly (setSize(tImage.getWidth(), tImage.getHeight())
		// and set the anchor correctly or used addAtCenter after sizing. But
		// there's no point to that: you would just have a container with a
		// single object. That's the same as just having an object with no
		// container.
	}

}
