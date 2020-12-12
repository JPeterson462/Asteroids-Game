package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class GameOverScreen extends Screen {
	
	private Ship ship;
	private Stage stage;
	
	public GameOverScreen (Ship ship) {
		stage = new Stage(new StretchViewport(camera.viewportWidth, camera.viewportHeight));
		this.ship = ship;
	}
	
	public void setup (boolean freePlayMode, int reward, boolean successful, float time, float asteroidDensity, long seed, int level) {
		stage.clear();
		
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		
		Label status = new Label("", Textures.SKIN);
		status.setPosition(width / 4,  height * 3 / 4);
		if (!freePlayMode) {
			status.setText(successful ? ("Success! You have unlocked level " + (level+1) + "\nReward: " + reward + " Coins") : "Failed.");
		} else {
			int t = (int)time;
			int minutes = (t - (t % 60)) / 60;
			int seconds = t % 60;
			status.setText("Time Lasted: " + (minutes > 0 ? (minutes + " minutes, ") : "") + (seconds + " seconds"));
		}
		stage.addActor(status);
		
		TextButton replay = new TextButton("Replay", Textures.SKIN);
		replay.setBounds(width / 4, height / 2, width / 2, 80);
		replay.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(LEVEL_PLAY_SCREEN);
				((PlayScreen) now()).setup(freePlayMode, asteroidDensity, seed, reward, level);
			}
		});
		stage.addActor(replay);
		
		TextButton back = new TextButton("Continue", Textures.SKIN);
		back.setBounds(width / 4, height / 2  - 120, width / 2, 80);
		back.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(freePlayMode ? FREE_PLAY_SETUP_SCREEN : LEVEL_SCREEN);
			}
		});
		stage.addActor(back);
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		
	}

}
