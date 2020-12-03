package net.digiturtle.space;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ShipRenderer {
	
	private TextureRegion[] getSprites (Ship ship) {
		TextureRegion[] sprites = new TextureRegion[4];
		sprites[0] = Textures.BASIC_SPACESHIP;
		switch (ship.thrusters) {
		case Basic:
			sprites[1] = Textures.BASIC_THRUSTERS;
			break;
		case Mega:
			sprites[1] = Textures.MEGA_THRUSTERS;
			break;
		case Warp:
			sprites[1] = Textures.WARP_THRUSTERS;
			break;
		}
		switch (ship.phasers) {
		case Basic:
			sprites[2] = Textures.BASIC_PHASERS;
			break;
		case Energy:
			sprites[2] = Textures.ENERGY_PHASERS;
			break;
		case RedMatter:
			sprites[2] = Textures.RED_MATTER_PHASERS;
			break;
		}
		switch (ship.shields) {
		case Basic:
			sprites[3] = Textures.BASIC_SHIELDS;
			break;
		case Martian:
			sprites[3] = Textures.MARTIAN_SHIELDS;
			break;
		case Rugged:
			sprites[3] = Textures.RUGGED_SHIELDS;
			break;
		}
		return sprites;
	}
	
	public void draw (Batch batch, Ship ship, float x, float y) {
		TextureRegion[] sprites = getSprites(ship);
		batch.draw(sprites[0], 
				x - sprites[0].getRegionWidth()/2,
				y - sprites[0].getRegionHeight()/2);
		batch.draw(sprites[1], 
				x - sprites[1].getRegionWidth()/2,
				y - sprites[1].getRegionHeight()/2);
		batch.draw(sprites[2], 
				x - sprites[2].getRegionWidth()/2,
				y - sprites[2].getRegionHeight()/2);
		batch.draw(sprites[3], 
				x - sprites[3].getRegionWidth()/2,
				y - sprites[3].getRegionHeight()/2);
	}

}
