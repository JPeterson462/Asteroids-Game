package net.digiturtle.space;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SpaceGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShipRenderer shipRenderer;
	SpaceRenderer spaceRenderer;
	Ship ship;
	OrthographicCamera camera;
	Space space;
	ShipController shipController;
	ProgressBar healthBar;
	Stage stage;
	
	@Override
	public void create () {
		ship = new Ship();ship.phasers = Ship.Phasers.Basic;ship.thrusters = Ship.Thrusters.Mega;
		camera = new OrthographicCamera();
		float widthScale = (828f/2) / (float)Gdx.graphics.getWidth();
		int viewportHeight = (int) (widthScale * (float)Gdx.graphics.getHeight());
		camera.setToOrtho(false, 828/2, viewportHeight);
		Textures.create();
		batch = new SpriteBatch();
		shipRenderer = new ShipRenderer();
		space = new Space(asteroid -> {
			ship.health -= 10 * asteroid.level * ship.shields.damageFactor;
		});
		space.generate((int) camera.viewportWidth, (int) camera.viewportHeight * 20, new Random(), .1f);
		spaceRenderer = new SpaceRenderer();
		spaceRenderer.create();
		ship.position = new Vector2(space.width / 2, 300);
		ship.speed = ship.thrusters.speed;
		shipController = new KeyboardShipController();
		if (shipController instanceof InputProcessor) {
			Gdx.input.setInputProcessor((InputProcessor) shipController);
		}
		shipController.connect(ship, space);
		stage = new Stage();
		healthBar = new ProgressBar(0.0f, ship.maxHealth, 1, false, Textures.SKIN);
		healthBar.setValue(ship.health);
		healthBar.setAnimateDuration(0.25f);
		healthBar.setBounds(15, camera.viewportHeight - 15 - 20, camera.viewportWidth - 30, 20);
		healthBar.getStyle().background = new TextureRegionDrawable(new TextureRegion(Textures.getColoredDrawable((int) healthBar.getWidth(), (int) healthBar.getHeight(), new Color(0, 0, 0, 0))));
		healthBar.getStyle().knob = new TextureRegionDrawable(new TextureRegion(Textures.getColoredDrawable(0, (int) healthBar.getHeight(), Color.RED)));
		healthBar.getStyle().knobBefore = new TextureRegionDrawable(new TextureRegion(Textures.getColoredDrawable((int) healthBar.getWidth(), (int) healthBar.getHeight(), Color.RED)));
		stage.addActor(healthBar);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();
		ship.update(dt);
		shipRenderer.act(dt);
		camera.position.set(ship.position.x, ship.position.y + camera.viewportHeight/4, 0);
		camera.update();
		spaceRenderer.draw(space, camera);
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		shipRenderer.draw(batch, ship, ship.position.x, ship.position.y);
		batch.end();
		stage.act(dt);
		stage.draw();
		space.processCollisionsAndUpdate(ship, 300, 240, dt);
		healthBar.setValue(ship.health);
	}
	
	@Override
	public void dispose () {
		spaceRenderer.dispose();
		batch.dispose();
		Textures.dispose();
	}
}
