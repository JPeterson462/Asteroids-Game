package net.digiturtle.space;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class SplashScreen extends Screen {
	
	private Stage stage;
	private float t = 0;
	
	public SplashScreen () {
		showSpace = false;
		stage = new Stage();
		Image image = new Image(Textures.DIGITURTLE);
		int scale = (int) (camera.viewportWidth / Textures.DIGITURTLE.getWidth());
		int width = (int) camera.viewportWidth, height = (int) camera.viewportHeight;
		int imageWidth = Textures.DIGITURTLE.getWidth() * scale, imageHeight = Textures.DIGITURTLE.getHeight() * scale;
		image.setBounds((width - imageWidth) / 2, (height - imageHeight) / 2, imageWidth, imageHeight);
		stage.addActor(image);
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		t += dt;
		if (t > 1.2f) {
			to(MENU_SCREEN);
		}
	}

}
