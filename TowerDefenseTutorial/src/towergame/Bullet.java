
package towergame;

import java.awt.Image;
import java.util.List;

import jgame.Context;
import jgame.GObject;
import jgame.GSprite;
import jgame.controller.ConstantRotationController;
import jgame.listener.BoundaryRemovalListener;
import jgame.listener.HitTestListener;

public class Bullet extends GSprite {

	public Bullet(Image image) {
		super(image);
		addController(new ConstantRotationController(12));
		addListener(new BoundaryRemovalListener());

		HitTestListener htl = new HitTestListener(Peasant.class) {
			@Override
			public void invoke(GObject target, Context context) {
				// 1. decrement health of ((peasant)) ??
				// 2. if peasant hp <= 0 remove peasant
				// 3. in any case remove the bullet
				// 4. add value to bank
				List<Peasant> pl = context.hitTestClass(Peasant.class);
				for (Peasant peasant : pl) {
					peasant.changeHealthPoints(-10); // step 1
					if (peasant.getHealthPoints() <= 0) {
						peasant.removeSelf(); // step 2
						TGLevelOneView tglov = getFirstAncestorOf(TGLevelOneView.class);
						tglov.changeMoneyBankValue(+50);
					}
				}
				target.removeSelf(); // step 3
			}
		};
		addListener(htl);
	}
}
