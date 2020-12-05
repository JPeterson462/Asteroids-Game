package net.digiturtle.space;

import java.util.Random;

import com.badlogic.gdx.graphics.OrthographicCamera;

public class Screen {

	public static final int 
		SPLASH_SCREEN = 0,
			MENU_SCREEN = 1,
				LEVEL_SCREEN = 2,
					LEVEL_PLAY_SCREEN = 3,
						LEVEL_GAME_OVER_SCREEN = 4,
				FREE_PLAY_SETUP_SCREEN = 5,
					FREE_PLAY_SCREEN = 6,
						FREE_PLAY_GAME_OVER_SCREEN = 7,
				SHOP_SCREEN = 8
		;
	
	public static Screen[] SCREENS;
	public static int current = SPLASH_SCREEN;
	private static Space noAsteroid, asteroid;
	private static OrthographicCamera camera;
	private static float t;
	private static Random random;
	
	public static void create (OrthographicCamera camera) {
		random = new Random();
		Screen.camera = camera;
		noAsteroid = new Space((a) -> {});
		noAsteroid.generate((int) camera.viewportWidth, (int) camera.viewportHeight * 5, random, 0);
		asteroid = new Space((a) -> {});
		asteroid.generate((int) camera.viewportWidth, (int) camera.viewportHeight * 5, random, 0.3f);
		SCREENS = new Screen[] {
				null,
					null,
						null,
							null,
								null,
						null,
							null,
								null,
						null
			};
	}
	
	public static void render (SpaceRenderer spaceRenderer, float dt) {
		t += dt * 50;
		if (t > camera.viewportWidth * 4) {
			t = 0;
		}
		camera.position.set(camera.viewportWidth/2, t + camera.viewportHeight/2, 0);
		camera.update();
		spaceRenderer.draw(asteroid, camera);
	}
	
}
