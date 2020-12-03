package net.digiturtle.space;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Textures {
	
	public static TextureRegion BASIC_PHASERS, ENERGY_PHASERS, RED_MATTER_PHASERS;
	public static TextureRegion BASIC_SPACESHIP;
	public static TextureRegion BASIC_THRUSTERS, MEGA_THRUSTERS, WARP_THRUSTERS;
	public static TextureRegion BASIC_SHIELDS, RUGGED_SHIELDS, MARTIAN_SHIELDS;
	public static Texture ASTEROIDS;
	public static TextureRegion ASTEROID1, ASTEROID2, ASTEROID3, ASTEROID4;
	
	public static void create () {
		BASIC_PHASERS = new TextureRegion(new Texture("BasicPhasers.png"));
		ENERGY_PHASERS = new TextureRegion(new Texture("EnergyPhasers.png"));
		RED_MATTER_PHASERS = new TextureRegion(new Texture("RedMatterPhasers.png"));
		BASIC_SPACESHIP = new TextureRegion(new Texture("BasicSpaceship.png"));
		BASIC_THRUSTERS = new TextureRegion(new Texture("BasicThrusters.png"));
		MEGA_THRUSTERS = new TextureRegion(new Texture("MegaThrusters.png"));
		WARP_THRUSTERS = new TextureRegion(new Texture("WarpThrusters.png"));
		BASIC_SHIELDS = new TextureRegion(new Texture("BasicShields.png"));
		RUGGED_SHIELDS = new TextureRegion(new Texture("RuggedShields.png"));
		MARTIAN_SHIELDS = new TextureRegion(new Texture("MartianShields.png"));
		ASTEROIDS = new Texture("Asteroids.png");
		ASTEROID1 = new TextureRegion(ASTEROIDS, 128+96+64, 0, 32,32);
		ASTEROID2 = new TextureRegion(ASTEROIDS, 128+96, 0, 64,46);
		ASTEROID3 = new TextureRegion(ASTEROIDS, 128, 0, 96,96);
		ASTEROID4 = new TextureRegion(ASTEROIDS, 0, 0, 128,128);
	}
	
	public static void dispose () {
		BASIC_PHASERS.getTexture().dispose();
		ENERGY_PHASERS.getTexture().dispose();
		RED_MATTER_PHASERS.getTexture().dispose();
		BASIC_SPACESHIP.getTexture().dispose();
		BASIC_THRUSTERS.getTexture().dispose();
		MEGA_THRUSTERS.getTexture().dispose();
		WARP_THRUSTERS.getTexture().dispose();
		BASIC_SHIELDS.getTexture().dispose();
		RUGGED_SHIELDS.getTexture().dispose();
		MARTIAN_SHIELDS.getTexture().dispose();
		ASTEROIDS.dispose();
	}

}
