package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuScreen extends Screen {
	
	private Stage stage;
	
	public MenuScreen () {
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		stage = new Stage();
		
		Image image = new Image();
		image.setDrawable(new TextureRegionDrawable(Textures.LOGO));
		int logoWidth = Textures.LOGO.getWidth(), logoHeight = Textures.LOGO.getHeight();
		image.setBounds((width - logoWidth) / 2, height - logoHeight - (width - logoWidth) / 2, logoWidth, logoHeight);
		stage.addActor(image);
		
		TextButton playLevel = new TextButton("Select Level", Textures.SKIN);
		playLevel.setBounds(width / 6, height / 2, width * 2 / 3, 80);
		playLevel.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(LEVEL_SCREEN);
			}
		});
		stage.addActor(playLevel);
		
		TextButton freePlay = new TextButton("Free Play", Textures.SKIN);
		freePlay.setBounds(width / 6, height / 2 - 110, width * 2 / 3, 80);
		freePlay.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(FREE_PLAY_SETUP_SCREEN);
			}
		});
		stage.addActor(freePlay);
		
		TextButton shop = new TextButton("Upgrade Ship", Textures.SKIN);
		shop.setBounds(width / 6, height / 2 - 2 * 110, width * 2 / 3, 80);
		shop.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(SHOP_SCREEN);
			}
		});
		stage.addActor(shop);
		
		Button settings = new Button(Textures.SKIN);
		settings.setBounds(width - 50 - 10, 10, 50, 50);
		settings.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				to(SETTINGS_SCREEN);
			}
		});
		stage.addActor(settings);
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		
	}

}
