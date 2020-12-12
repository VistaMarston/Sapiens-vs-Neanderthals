package a9;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Plant extends Actor {
	
	private int cost;
	
	public Plant(Point2D.Double startingPosition, Point2D.Double initHitbox, BufferedImage img, int health, int coolDown, double speed, int attackDamage, int cost) {
		super(startingPosition, initHitbox, img, health, coolDown, speed, attackDamage);
		this.cost = cost;
	}

	/**
	 * An attack means the two hotboxes are overlapping and the
	 * Actor is ready to attack again (based on its cooldown).
	 * 
	 * Plants only attack Zombies.
	 * 
	 * @param other
	 */
	@Override
	public void attack(Actor other) {
		if (other instanceof Zombie)
			super.attack(other);
	}
	
}
