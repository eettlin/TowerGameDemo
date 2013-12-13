package towergame;

import java.awt.Color;
import java.awt.Font;

import jgame.Context;
import jgame.GMessage;
import jgame.GObject;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.FrameListener;

public class l1InfoArea extends GSprite {

	private GMessage moneyBankValue = new GMessage();
	private GMessage lifeBankValue = new GMessage();

	public l1InfoArea(final Bank bv, final Bank lb) { // sets the reference to
														// final value
		super(ImageCache.getSprite("/areas/infoarea.png"));
		setSize(900, 100);

		// setBankValue(bv.getBankValue());
		moneyBankValue.setLocation(100, 30);
		this.add(moneyBankValue);

		moneyBankValue.setColor(Color.YELLOW);
		moneyBankValue.setFontSize(30);
		moneyBankValue.setFontStyle(Font.BOLD | Font.ITALIC);

		lifeBankValue.setLocation(500, 30);
		this.add(lifeBankValue);

		lifeBankValue.setColor(Color.YELLOW);
		lifeBankValue.setFontSize(30);
		lifeBankValue.setFontStyle(Font.BOLD | Font.ITALIC);

		FrameListener updateListener = new FrameListener() {
			@Override
			public void invoke(GObject target, Context context) {
				setMoneyBankValue(bv.getBankValue());
				setLifeBankValue(lb.getBankValue());
			}
		};
		addListener(updateListener);
	}

	public void setLifeBankValue(int lbv) {
		lifeBankValue.setText("Life = " + Integer.toString(lbv));
	}

	public void setMoneyBankValue(int bv) {

		moneyBankValue.setText("Bank Value = " + Integer.toString(bv));
	}
}
