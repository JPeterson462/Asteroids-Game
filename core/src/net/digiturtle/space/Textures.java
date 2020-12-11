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
	public static Texture FUEL;
	public static TextureRegion[] GASOLINE, JET_FUEL, PLASMA;
	public static Texture PHASERS;
	public static TextureRegion[] BASIC_P, ENERGY_P, RED_MATTER_P;
	public static Texture ICONS;
	public static TextureRegion[] ICON_SET;
	public static Texture LOGO, DIGITURTLE;
	public static Texture AUDIO_ICON;
	public static TextureRegion[] AUDIO_ICONS;
	
	public static Skin SKIN;
	
	public static void create () {
		AUDIO_ICON = new Texture("AudioOnOff.png");
		AUDIO_ICONS = new TextureRegion[] {
			new TextureRegion(AUDIO_ICON, 16, 0, 16, 16),//off
			new TextureRegion(AUDIO_ICON, 0, 0, 16, 16),//on
		};
		LOGO = new Texture("AsteroidBlitz.png");
		DIGITURTLE = new Texture("DigiTurtleLowResWithTitle_BG.png");
		ICONS = new Texture("ShipParts.png");
		ICON_SET = new TextureRegion[] {
			new TextureRegion(ICONS, 0, 0, 80, 80),
			new TextureRegion(ICONS, 80, 0, 80, 80),
			new TextureRegion(ICONS, 160, 0, 80, 80),
			new TextureRegion(ICONS, 0, 80, 80, 80),
			new TextureRegion(ICONS, 80, 80, 80, 80),
			new TextureRegion(ICONS, 160, 80, 80, 80),
			new TextureRegion(ICONS, 0, 160, 80, 80),
			new TextureRegion(ICONS, 80, 160, 80, 80),
			new TextureRegion(ICONS, 160, 160, 80, 80),
		};
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
		FUEL = new Texture("SpaceFuel.png");
		GASOLINE = new TextureRegion[5];
		JET_FUEL = new TextureRegion[5];
		PLASMA = new TextureRegion[5];
		for (int i = 0; i < 5; i++) {
			GASOLINE[i] = new TextureRegion(FUEL, i * 240, 0, 240, 100);
			JET_FUEL[i] = new TextureRegion(FUEL, i * 240, 100, 240, 100);
			PLASMA[i] = new TextureRegion(FUEL, i * 240, 200, 240, 100);
		}
		PHASERS = new Texture("SpacePhasers.png");
		BASIC_P = new TextureRegion[5];
		ENERGY_P = new TextureRegion[5];
		RED_MATTER_P = new TextureRegion[5];
		for (int i = 0; i < 5; i++) {
			BASIC_P[i] = new TextureRegion(PHASERS, i * 240, 0, 240, 150);
			ENERGY_P[i] = new TextureRegion(PHASERS, i * 240, 150, 240, 150);
			RED_MATTER_P[i] = new TextureRegion(PHASERS, i * 240, 300, 240, 150);
		}
	}
	
	public static void dispose () {
		LOGO.dispose();
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
		FUEL.dispose();
		PHASERS.dispose();
		ICONS.dispose();
		AUDIO_ICON.dispose();
		DIGITURTLE.dispose();
	}
	
	public static Texture getColoredDrawable(int width, int height, Color color) {
		Pixmap pixmap = new Pixmap(width, height, Format.RGBA8888);
		pixmap.setColor(color);
		pixmap.fill();
		return new Texture(pixmap);
	}

}
