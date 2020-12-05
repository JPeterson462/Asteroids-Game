package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ShopScreen extends Screen {

	private Stage stage;
	
	public ShopScreen () {
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
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		
	}
	
}
