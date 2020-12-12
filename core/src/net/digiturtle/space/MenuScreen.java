package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MenuScreen extends Screen {
	
	private Stage stage;
	private Ship ship;
	
	public MenuScreen (Ship ship) {
		this.ship = ship;
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		stage = new Stage(new StretchViewport(camera.viewportWidth, camera.viewportHeight));
		
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
		
		ImageButton settings = new ImageButton(new TextureRegionDrawable(Textures.AUDIO_ICONS[ship.audioOn ? 1 : 0]));
		settings.setBounds(width - 50 - 20, 10, 50, 50);
		settings.getImage().setScale(2);
		settings.addListener(new ClickListener () {
			public void clicked (InputEvent evt, float x, float y) {
				ship.audioOn ^= true;
				settings.getStyle().imageUp = new TextureRegionDrawable(Textures.AUDIO_ICONS[ship.audioOn ? 1 : 0]);
				if (ship.audioOn) {
					Sounds.ALIEN_DREAM.play();
				} else {
					Sounds.ALIEN_DREAM.stop();
				}
				
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
