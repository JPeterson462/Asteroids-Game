package net.digiturtle.space;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector2;

public class Ship {
	
	public enum Thrusters {
		Basic(250, 0), Mega(500, 3500), Warp(800, 6500);
		
		public final int speed, cost;
		
		Thrusters (int speed, int cost) {
			this.speed = speed;
			this.cost = cost;
		}
	}
	
/*	public enum Fuel {
		Gasoline, JetFuel, Plasma
	} */
	
	public enum Shields {
		Basic(1.0f, 0), Rugged(0.7f, 4500), Martian (0.35f, 8500);
		
		public final float damageFactor;
		public final int cost;
		
		Shields (float damageFactor, int cost) {
			this.damageFactor = damageFactor;
			this.cost = cost;
		}
	}
	
	public enum Phasers {
		Basic(1, .1f, 0), Energy(1.3f, .25f, 2500), Red_Matter(1.7f, .4f, 7000);
		
		public final float shootFactor, chance2Levels;
		public final int cost;
		
		Phasers (float shootFactor, float chance2Levels, int cost) {
			this.shootFactor = shootFactor;
			this.chance2Levels = chance2Levels;
			this.cost = cost;
		}
	}
	
	public Thrusters thrusters = Thrusters.Basic;
	
//	public Fuel fuel = Fuel.Gasoline;
	
	public Shields shields = Shields.Basic;
	
	public Phasers phasers = Phasers.Basic;
	
	private HashMap<Object, Boolean> unlockedItems = new HashMap<>();
	
	public final int maxHealth = 100;
	public int health = maxHealth;
	
	public Vector2 position;
	private Vector2 velocity = new Vector2();
	public float speed;
	
	public float t, ddt;
	
	public boolean isUnlocked (Object item) {
		return unlockedItems.getOrDefault(item, false);
	}
	
	public void unlock (Object item) {
		unlockedItems.put(item,  true);
	}
	
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
