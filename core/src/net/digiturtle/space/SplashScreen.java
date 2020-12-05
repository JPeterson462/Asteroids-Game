package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class SplashScreen extends Screen {
	
	private Stage stage;
	
	public SplashScreen () {
		stage = new Stage();
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		// TODO add time for logo to display
		to(MENU_SCREEN);
	}

}
