package net.digiturtle.space;

import com.badlogic.gdx.math.Vector2;

public class Ship {
	
	public enum Thrusters {
		Basic(250), Mega(500), Warp(800);
		
		public final int speed;
		
		Thrusters (int speed) {
			this.speed = speed;
		}
	}
	
/*	public enum Fuel {
		Gasoline, JetFuel, Plasma
	} */
	
	public enum Shields {
		Basic(1.0f), Rugged(0.7f), Martian (0.35f);
		
		public final float damageFactor;
		
		Shields (float damageFactor) {
			this.damageFactor = damageFactor;
		}
	}
	
	public enum Phasers {
		Basic, Energy, RedMatter
	}
	
	public Thrusters thrusters = Thrusters.Basic;
	
//	public Fuel fuel = Fuel.Gasoline;
	
	public Shields shields = Shields.Basic;
	
	public Phasers phasers = Phasers.Basic;
	
	public final int maxHealth = 100;
	public int health = maxHealth;
	
	public Vector2 position;
	private Vector2 velocity = new Vector2();
	public float speed;
	
	public void update (float dt) {
		velocity.set(0, speed);
		position.mulAdd(velocity, dt);
	}

}
