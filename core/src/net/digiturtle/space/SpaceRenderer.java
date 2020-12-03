package net.digiturtle.space;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

public class SpaceRenderer {
	
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batch;
	
	public void create () {
		shapeRenderer = new ShapeRenderer();
		batch = new SpriteBatch();
	}
	
	public void draw (Space space, OrthographicCamera camera) {
		TextureRegion[] allAsteroids = new TextureRegion[] {
			Textures.ASTEROID1,Textures.ASTEROID2,Textures.ASTEROID3,Textures.ASTEROID4
		};
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setProjectionMatrix(camera.combined);
		for (Vector3 star : space.stars) {
			shapeRenderer.circle(star.x, star.y, star.z);
		}
		shapeRenderer.end();
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		for (Asteroid asteroid : space.asteroids) {
			TextureRegion sprite = allAsteroids[asteroid.level - 1];
			batch.draw(sprite, asteroid.position.x - sprite.getRegionWidth()/2, asteroid.position.y - sprite.getRegionHeight()/2);
		}
		batch.end();
	}
	
	public void dispose () {
		shapeRenderer.dispose();
		batch.dispose();
	}

}
