package net.digiturtle.space;

import com.badlogic.gdx.math.Vector2;

public class Asteroid {
	
	public Vector2 position, velocity;
	public int level;
	
	public Asteroid (Vector2 position, int level) {
		this.position = position;
		velocity = new Vector2();
		this.level = level;
	}

}
