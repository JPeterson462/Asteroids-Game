package net.digiturtle.space;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Textures {
	
	public static TextureRegion BASIC_PHASERS, ENERGY_PHASERS, RED_MATTER_PHASERS;
	public static TextureRegion BASIC_SPACESHIP;
	public static TextureRegion BASIC_THRUSTERS, MEGA_THRUSTERS, WARP_THRUSTERS;
	public static TextureRegion BASIC_SHIELDS, RUGGED_SHIELDS, MARTIAN_SHIELDS;
	public static Texture ASTEROIDS;
	public static TextureRegion ASTEROID1, ASTEROID2, ASTEROID3, ASTEROID4;
	public static TextureRegion SHIP_DAMAGE1, SHIP_DAMAGE2, SHIP_DAMAGE3, SHIP_DAMAGE4;
	
	public static Skin SKIN;
	
	public static void create () {
		SHIP_DAMAGE1 = new TextureRegion(new Texture("ShipDamage1.png"));
		SHIP_DAMAGE2 = new TextureRegion(new Texture("ShipDamage2.png"));
		SHIP_DAMAGE3 = new TextureRegion(new Texture("ShipDamage3.png"));
		SHIP_DAMAGE4 = new TextureRegion(new Texture("ShipDamage4.png"));
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
		SKIN = new Skin(Gdx.files.internal("uiskin.json"));
	}
	
	public static void dispose () {
		SHIP_DAMAGE1.getTexture().dispose();
		SHIP_DAMAGE2.getTexture().dispose();
		SHIP_DAMAGE3.getTexture().dispose();
		SHIP_DAMAGE4.getTexture().dispose();
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
	
	public static Texture getColoredDrawable(int width, int height, Color color) {
		Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
		pixmap.setColor(color);
		pixmap.fill();
		return new Texture(pixmap);
	}

}
