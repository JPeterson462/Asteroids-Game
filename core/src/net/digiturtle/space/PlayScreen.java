package net.digiturtle.space;

import java.util.Random;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class PlayScreen extends Screen {
	
	private Space space;
	private Ship ship;

	private boolean freePlay;
	private float time, asteroidDensity;
	private int reward, level;
	private long seed;
	
	private SpaceRenderer spaceRenderer;
	private ShipRenderer shipRenderer;
	private ShipController shipController;
	private SpriteBatch batch;
	private ProgressBar healthBar;
	
	private Stage stage;
	
	public PlayScreen (Ship ship) {
		passInput = true;
		this.ship = ship;
		stage = new Stage();
		
		int width = (int)camera.viewportWidth, height = (int)camera.viewportHeight;
		TextButton quit = new TextButton("Quit", Textures.SKIN);
		quit.setBounds(width * 3 / 4, height - 70, width / 4 - 10, 30);
		quit.addListener(new ClickListener() {
			public void clicked (InputEvent evt, float x, float y) {
				to(freePlay ? FREE_PLAY_SETUP_SCREEN : LEVEL_SCREEN);
			}
		});
		stage.addActor(quit);

		space = new Space(asteroid -> {
			ship.health -= 10 * asteroid.level * ship.shields.damageFactor;
		});
		
		healthBar = new ProgressBar(0.0f, ship.maxHealth, 1, false, Textures.SKIN);
		healthBar.setValue(ship.health);
		healthBar.setAnimateDuration(0.25f);
		healthBar.setBounds(15, camera.viewportHeight - 15 - 20, camera.viewportWidth - 30, 20);
		healthBar.getStyle().background = new TextureRegionDrawable(new TextureRegion(Textures.getColoredDrawable((int) healthBar.getWidth(), (int) healthBar.getHeight(), new Color(0, 0, 0, 0))));
		healthBar.getStyle().knob = new TextureRegionDrawable(new TextureRegion(Textures.getColoredDrawable(0, (int) healthBar.getHeight(), Color.RED)));
		healthBar.getStyle().knobBefore = new TextureRegionDrawable(new TextureRegion(Textures.getColoredDrawable((int) healthBar.getWidth(), (int) healthBar.getHeight(), Color.RED)));
		stage.addActor(healthBar);
		
		batch = new SpriteBatch();
		shipRenderer = new ShipRenderer();
		spaceRenderer = new SpaceRenderer();
		spaceRenderer.create();
		shipController = new KeyboardShipController();
		shipController.connect(ship, space);
	}

	public InputProcessor getInputHandler () {
		return (InputProcessor) shipController;
	}
	
	public void setup (boolean freePlay, float asteroidDensity, long seed, int reward, int level) {
		this.freePlay = freePlay;
		space.generate((int) camera.viewportWidth, (int) camera.viewportHeight * 20, new Random(seed), asteroidDensity);
		ship.position = new Vector2(space.width / 2, 300);
		ship.speed = ship.thrusters.speed;
		this.reward = reward;
		this.level = level;
		this.asteroidDensity = asteroidDensity;
		this.seed = seed;
		ship.health = ship.maxHealth;
	}

	@Override
	public Stage getStage() {
		return stage;
	}

	@Override
	public void draw(float dt) {
		time += dt;
		ship.update(dt);
		shipRenderer.act(dt);
		camera.position.set(ship.position.x, ship.position.y + camera.viewportHeight/4, 0);
		camera.update();
		spaceRenderer.draw(space, camera);
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		shipRenderer.draw(batch, ship, ship.position.x, ship.position.y);
		batch.end();
		space.processCollisionsAndUpdate(ship, 300, 240, dt);
		healthBar.setValue(ship.health);
		
		if (ship.health <= 0) {
			// Lose
			to(freePlay ? FREE_PLAY_GAME_OVER_SCREEN : LEVEL_GAME_OVER_SCREEN);
			((GameOverScreen) now()).setup(freePlay, 0, freePlay, time, asteroidDensity, seed, level);
		}
		else if (!freePlay && ship.position.y > space.height) {
			// Win
			to(freePlay ? FREE_PLAY_GAME_OVER_SCREEN : LEVEL_GAME_OVER_SCREEN);
			((GameOverScreen) now()).setup(freePlay, reward, true, time, asteroidDensity, seed, level);
			ship.coins += reward;
			ship.levelUnlocked = Math.max(ship.levelUnlocked, level + 1);
		}
	}

}
