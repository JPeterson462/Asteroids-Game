package net.digiturtle.space;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class Screen {

	public static final int 
		SPLASH_SCREEN = 0,
			MENU_SCREEN = 1,
				LEVEL_SCREEN = 2,
					LEVEL_PLAY_SCREEN = 3,
						LEVEL_GAME_OVER_SCREEN = 4,
				FREE_PLAY_SETUP_SCREEN = 5,
					FREE_PLAY_SCREEN = 6,
						FREE_PLAY_GAME_OVER_SCREEN = 7,
				SHOP_SCREEN = 8,
				SETTINGS_SCREEN = 9
		;
	
	public static Screen[] SCREENS;
	public static int current = SPLASH_SCREEN;
	private static Space noAsteroid, asteroid;
	public static OrthographicCamera camera;
	private static float t;
	private static Random random;
	
	public static void create (OrthographicCamera camera, Ship ship) {
		random = new Random();
		Screen.camera = camera;
		noAsteroid = new Space((a) -> {});
		noAsteroid.generate((int) camera.viewportWidth, (int) camera.viewportHeight * 5, random, 0);
		asteroid = new Space((a) -> {});
		asteroid.generate((int) camera.viewportWidth, (int) camera.viewportHeight * 5, random, 0.3f);
		SCREENS = new Screen[] {
				new SplashScreen(),//TODO
					new MenuScreen(),//TODO add settings icon
						new LevelSelectScreen(ship),
							new PlayScreen(ship),
								new GameOverScreen(),//TODO
						new FreePlaySetupScreen(),
							new PlayScreen(ship),
								new GameOverScreen(),//TODO
						new ShopScreen(ship),//TODO
						new SettingsScreen()//TODO
			};
	}
	
	public abstract Stage getStage ();
	
	public abstract void draw (float dt);
	
	public InputProcessor getInputHandler () {
		return null;
	}
	
	public boolean showAsteroids = false, passInput = false;
	
	public static void to (int index) {
		current = index;
		if (now().passInput) {
			Gdx.input.setInputProcessor(new InputMultiplexer(SCREENS[current].getStage(), now().getInputHandler()));
		} else {
			Gdx.input.setInputProcessor(SCREENS[current].getStage());
		}
	}
	
	public static Screen now () {
		return SCREENS[current];
	}
	
	public static void render (SpaceRenderer spaceRenderer, float dt) {
		t += dt * 50;
		if (t > camera.viewportWidth * 4) {
			t = 0;
		}
		camera.position.set(camera.viewportWidth/2, t + camera.viewportHeight/2, 0);
		camera.update();
		Screen screen = SCREENS[current];
		if (!(screen instanceof PlayScreen)) spaceRenderer.draw(screen.showAsteroids ? asteroid : noAsteroid, camera);
		screen.draw(dt);
		screen.getStage().act(dt);
		screen.getStage().draw();
	}
	
}
