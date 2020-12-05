package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LevelSelectScreen extends Screen {
	
	private Stage stage;
	
	public LevelSelectScreen () {
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		stage = new Stage();
		
		TextButton back = new TextButton("Back", Textures.SKIN);
		back.setBounds(10, height - 10 - 50, width / 3, 50);
		back.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(MENU_SCREEN);
			}
		});
		stage.addActor(back);
		
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				int space = 20;
				int size = (width - 6*space) / 5;
				int level = (5 - r - 1) * 5 + c + 1;
				TextButton select = new TextButton(Integer.toString(level), Textures.SKIN);
				select.setBounds(c * (size + space) + space, r * (size + space) + space + (height - 5 * (size + space)) / 2, size, size);
				select.addListener(new ClickListener () {
					public void clicked (InputEvent evt, float x, float y) {
						to(LEVEL_PLAY_SCREEN);
						((PlayScreen) now()).setup(false, .1f + (level * (.3f / 25)), SpaceGame.SEED);
					}
				});
				stage.addActor(select);
			}
		}
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		
	}

}
