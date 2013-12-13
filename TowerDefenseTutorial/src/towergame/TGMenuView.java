package towergame;

import towergame.TowerGameApplet.Views;

import jgame.ButtonState;
import jgame.Context;
import jgame.GButton;
import jgame.GContainer;
import jgame.GSprite;
import jgame.ImageCache;
import jgame.listener.ButtonListener;

public class TGMenuView extends GContainer {

	public TGMenuView() {
		MenuBackground mbg = new MenuBackground();
		setBackgroundSprite(mbg);
		setSize(900, 700);

		GSprite none_img = ImageCache.getSprite("buttons/playnone.png");
		GSprite hover_img = ImageCache.getSprite("buttons/playhover.png");
		GSprite pressed_img = ImageCache.getSprite("buttons/playpressed.png");

		// Play Button
		GButton play_btn = new GButton();
		play_btn.setStateSprite(ButtonState.NONE, none_img);
		play_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		play_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		addAt(play_btn, 100, 100);

		// Instructions Button
		GButton Insturctions_btn = new GButton();
		Insturctions_btn.setStateSprite(ButtonState.NONE, none_img);
		Insturctions_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		Insturctions_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		addAt(Insturctions_btn, 100, 300);

		// Quit Button
		GButton quit_btn = new GButton();
		quit_btn.setStateSprite(ButtonState.NONE, none_img);
		quit_btn.setStateSprite(ButtonState.HOVERED, hover_img);
		quit_btn.setStateSprite(ButtonState.PRESSED, pressed_img);
		addAt(quit_btn, 100, 500);

		// Add a button listener to the play button
		ButtonListener play_bl = new ButtonListener() {
			@Override
			public void mouseClicked(Context context) {
				context.setCurrentGameView(Views.LEVEL_ONE);
			}
		};
		play_btn.addListener(play_bl);

	}
}
