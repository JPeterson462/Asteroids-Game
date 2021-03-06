package net.digiturtle.space;

import java.util.Random;

public class ShipController {
	
	private Ship ship;
	private Space space;
	private Random random = new Random();
	
	public final void connect (Ship ship, Space space) {
		this.ship = ship;
		this.space = space;
	}
	
	public final void shoot () {
		System.out.println("Shoot!");
		if (ship.t < 1 && ship.t > 0) return; // Can't shoot yet
		ship.shoot();
		for (int i = space.asteroids.size() - 1; i >= 0; i--) {
			Asteroid asteroid = space.asteroids.get(i);
			float dx = asteroid.position.y - ship.position.y;
			if (dx < space.shipHeight * ship.phasers.shootFactor * 1.5f) {
				boolean take2 = random.nextFloat() < ship.phasers.chance2Levels;
				int level = Math.max(0, asteroid.level - (take2 ? 2 : 1));
				if (level == 0) {
					space.asteroids.remove(i);
					if (ship.audioOn) {
						Sounds.ASTEROID_DESTROYED.play();
					}
				} else {
					asteroid.level = level;
				}
			}
		}
	}

}
