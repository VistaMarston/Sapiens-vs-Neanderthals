package a9;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Zombie class extends Actor. Adds health, attack, cool down timer, and speed
 * to each character.
 * 
 * @author dejohnso
 *
 */
public abstract class Zombie extends Actor {

	public Zombie(Point2D.Double startingPosition, Point2D.Double initHitbox, BufferedImage img, int health,
			int coolDown, double speed, int attackDamage) {
		super(startingPosition, initHitbox, img, health, coolDown, speed, attackDamage);
		// TODO Auto-generated constructor stub
	}

	/**
	 * An attack means the two hotboxes are overlapping and the Actor is ready to
	 * attack again (based on its cooldown).
	 * 
	 * @param other
	 */
	@Override
	public void attack(Actor other) {
		if (other instanceof Plant) {
			super.attack(other);
		}
	}

}
