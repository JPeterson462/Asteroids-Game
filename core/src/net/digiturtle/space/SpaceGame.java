package net.digiturtle.space;

import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class SpaceGame extends ApplicationAdapter {
	SpriteBatch batch;
	ShipRenderer shipRenderer;
	SpaceRenderer spaceRenderer;
	Ship ship;
	OrthographicCamera camera;
	Space space;
	ShipController shipController;
	
	@Override
	public void create () {
		ship = new Ship();ship.phasers = Ship.Phasers.Energy;
		Textures.create();
		batch = new SpriteBatch();
		shipRenderer = new ShipRenderer();
		camera = new OrthographicCamera();
		float widthScale = (828f/2) / (float)Gdx.graphics.getWidth();
		int viewportHeight = (int) (widthScale * (float)Gdx.graphics.getHeight());
		camera.setToOrtho(false, 828/2, viewportHeight);
		space = new Space();
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
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		float dt = Gdx.graphics.getDeltaTime();
		ship.update(dt);
		camera.position.set(ship.position.x, ship.position.y + camera.viewportHeight/4, 0);
		camera.update();
		spaceRenderer.draw(space, camera);
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		shipRenderer.draw(batch, ship, ship.position.x, ship.position.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		spaceRenderer.dispose();
		batch.dispose();
		Textures.dispose();
	}
}
