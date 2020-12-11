package net.digiturtle.space;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Space {
	
	public ArrayList<Vector3> stars;
	public ArrayList<Asteroid> asteroids;
	public int width, height, shipHeight;
	public Consumer<Asteroid> collider;
	
	public Space (Consumer<Asteroid> collider) {
		this.collider = collider;
	}
	
	private int mapAsteroidLevel (float t) {
		if (t > .95f) return 4;
		if (t > .8f) return 3;
		if (t > .60f) return 2;
		return 1;
	}
	
	public void processCollisionsAndUpdate (Ship ship, int shipHeight, int shipWidth, float dt) {
		this.shipHeight = shipHeight;
		for (int i = asteroids.size() - 1; i >= 0; i--) {
			Asteroid asteroid = asteroids.get(i);
			asteroid.update(dt);
			float dx = Math.abs(asteroid.position.x - ship.position.x);
			if (dx > 5 * shipWidth) {
				asteroids.remove(i);
				continue;
			}
			if (dx * 2 > shipWidth) {
				continue;
			}
			float shipY = (float)shipHeight/2 * dx/((float)shipWidth/2);
			float dy = Math.abs(asteroid.position.y - ship.position.y);
			if (dy < shipY) {
				if (!asteroid.collided) {
					if (ship.audioOn) {
						Sounds.SHIP_DAMAGE.play();
					}
					collider.accept(asteroid);
				}
				asteroid.collided = true;
				asteroid.velocity.set(Math.signum(asteroid.position.x - ship.position.x) * 500, 0);
			}
		}
	}
	
	public void generate (int width, int height, Random random, float asteroidDensity) {
		this.width = width;
		this.height = height;
		// Generate star field
		stars = new ArrayList<>();
		int starCellSize = width / 4;
		int starCellColumns = width / starCellSize, starCellRows = height / starCellSize + 1;
		System.out.println(starCellColumns + "x" + starCellRows);
		for (int c = 0; c < starCellColumns; c++) {
			for (int r = 0; r < starCellRows; r++) {
				stars.add(new Vector3(c * starCellSize + random.nextFloat() * starCellSize, 
						r * starCellSize + random.nextFloat() * starCellSize,
						random.nextInt(3) == 0 ? 2 : 1));
			}
		}
		asteroids = new ArrayList<>();
		if (asteroidDensity > 0) {
			// Generate asteroids
			int spacing = (int) (96 / asteroidDensity);
			System.out.println("Spacing: " + spacing);
			for (int y = spacing + 2 * width; y < height; y += spacing) {
				int level = mapAsteroidLevel(random.nextFloat());
				boolean added = false;
				if (random.nextBoolean() || random.nextBoolean()) {
					asteroids.add(new Asteroid(new Vector2(width * (.25f + random.nextFloat() * .15f), y), 
							level));
					added = true;
				}
				if (!added | random.nextBoolean()) {
					asteroids.add(new Asteroid(new Vector2(width * (.75f - random.nextFloat() * .15f), y),
							added ? mapAsteroidLevel(random.nextFloat()) : (random.nextFloat() > .7f ? 4 : 3)));
				}
			}
		}
	}

}
