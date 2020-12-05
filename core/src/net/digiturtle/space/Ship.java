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
		Basic(1, .1f), Energy(1.3f, .25f), RedMatter(1.7f, .4f);
		
		public final float shootFactor, chance2Levels;
		
		Phasers (float shootFactor, float chance2Levels) {
			this.shootFactor = shootFactor;
			this.chance2Levels = chance2Levels;
		}
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
	
	public float t, ddt;
	
	public void shoot () {
		ddt = 1f/.1f;
	}
	
	public void update (float dt) {
		velocity.set(0, speed);
		position.mulAdd(velocity, dt);
		t += ddt * dt;
		if (t >= 1) {
			t = 0;
			ddt = 0;
		}
	}
	
	// User data
	public int coins;
	public int levelUnlocked = 1;

}
