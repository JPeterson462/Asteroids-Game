package net.digiturtle.space;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Space {
	
	public ArrayList<Vector3> stars;
	public ArrayList<Asteroid> asteroids;
	public int width, height;
	
	private int mapAsteroidLevel (float t) {
		if (t > .95f) return 4;
		if (t > .8f) return 3;
		if (t > .60f) return 2;
		return 1;
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
		// Generate asteroids
		asteroids = new ArrayList<>();
		int spacing = (int) (96 / asteroidDensity);
		for (int y = width/2 + spacing; y < height; y += spacing) {
			int level = mapAsteroidLevel(random.nextFloat());
			boolean added = false;
			if (random.nextBoolean() || random.nextBoolean()) {
				asteroids.add(new Asteroid(new Vector2(width * (.25f + random.nextFloat() * .15f), y), 
						level));
				added = true;
			}
			if (random.nextBoolean()) {
				asteroids.add(new Asteroid(new Vector2(width * (.75f - random.nextFloat() * .15f), y),
						added ? mapAsteroidLevel(random.nextFloat()) : (random.nextFloat() > .7f ? 4 : 3)));
			}
		}
	}

}
