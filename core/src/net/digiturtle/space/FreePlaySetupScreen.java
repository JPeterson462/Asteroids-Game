package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class FreePlaySetupScreen extends Screen {

	private Stage stage;
	private Slider slider;
	private Label label;
	
	public FreePlaySetupScreen () {
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		stage = new Stage(new StretchViewport(camera.viewportWidth, camera.viewportHeight));
		
		TextButton back = new TextButton("Back", Textures.SKIN);
		back.setBounds(10, height - 10 - 50, width / 3, 50);
		back.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(MENU_SCREEN);
			}
		});
		stage.addActor(back);
		
		label = new Label("Asteroid Density: 10%", Textures.SKIN);
		label.setPosition(30, height / 2 + 60);
		stage.addActor(label);
		
		slider = new Slider(.1f, .4f, .05f, false, Textures.SKIN);
		slider.setBounds(30, height / 2, width - 2*30, 40);
		stage.addActor(slider);
		

		TextButton start = new TextButton("Start", Textures.SKIN);
		start.setBounds(width / 3, 30, width / 3, 50);
		start.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(FREE_PLAY_SCREEN);
				((PlayScreen) now()).setup(true, slider.getValue(), SpaceGame.SEED, 0, -1);
			}
		});
		stage.addActor(start);
		
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		label.setText("Asteroid Density: " + ((int) (slider.getValue() * 100)) + "%");
	}
	
}
