package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOverScreen extends Screen {
	
	private Stage stage;
	
	public GameOverScreen () {
		stage = new Stage();
		
	}
	
	public void setup (boolean freePlayMode, int reward, boolean successful, float time) {
		
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		
	}

}
