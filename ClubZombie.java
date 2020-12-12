package a9;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * The ClubZombie class extends zombie. This class indicates the special
 * capabilities of the Club Zombie in the game. This adds a base image to the
 * character, health, strength, speed, and cool down counter. This is the only
 * character that attacks within the game.
 * 
 * @Author Vista Marston
 *
 */
public class ClubZombie extends Zombie {

	private boolean isColliding;
	private static final int HEALTH = 100;
	private static final int COOL_DOWN = 30;
	private static double SPEED = -2;
	private static int ATTACK_DAMAGE = 10;
	private int shamanMagicCounter;
	private static final BufferedImage CLUB_ZOMBIE_IMAGE;
	private static Point2D.Double imagesPositionDouble;
	static {
		BufferedImage zombieImage1 = null;
		try {
			zombieImage1 = ImageIO.read(new File("src/a9/Animal-Icons/zombie1.png"));
			zombieImage1 = scaleBufferedImages(zombieImage1, 80, 80);
		} catch (IOException e) {
			System.out.println("File not Found");
			System.exit(-1);
		}
		CLUB_ZOMBIE_IMAGE = zombieImage1;
		imagesPositionDouble = new Point2D.Double(CLUB_ZOMBIE_IMAGE.getWidth(), CLUB_ZOMBIE_IMAGE.getHeight());
	}

	public ClubZombie(Point2D.Double startingPosition) {
		super(startingPosition, imagesPositionDouble, CLUB_ZOMBIE_IMAGE, HEALTH, COOL_DOWN, SPEED, ATTACK_DAMAGE);
		isColliding = false;
		shamanMagicCounter = 0;
	}

	/**
	 * Move if not colliding. Only moves in x.
	 */
	@Override
	public void move() {
		if (shamanMagicCounter <= 0 && !isColliding) {
			shiftPosition(new Point2D.Double(getSpeed(), 0));
			changeSpeed(SPEED);
		}
	}

	/**
	 * Changes the attack damage that the club zombie can do based on the level of
	 * game.
	 * 
	 * @param levelTracker an integer that represents the current level
	 */
	public void changeAttackDamage(int levelTracker) {
		ATTACK_DAMAGE += levelTracker;
	}

	/**
	 * Set the shaman counter.
	 */
	public void setShamanCounter() {
		shamanMagicCounter = 30;
	}

	/**
	 * Retrieves the shaman Counter.
	 * 
	 * @return an integer that represents the shaman counter (which represents the
	 *         appearing time for the club zombie.)
	 */
	public int getShamanCounter() {
		return shamanMagicCounter;
	}

	/**
	 * Scales the image to a desirable height and width for the base image of Club
	 * Zombie
	 * 
	 * @param _images an image that is representing the club zombie
	 * @param _width  an integer representing the desirable width of the image
	 * @param _height an integer representing the desirable height of the image
	 * @return
	 */
	private static BufferedImage scaleBufferedImages(BufferedImage _images, int _width, int _height) {
		Image image = _images.getScaledInstance(_width, _height, Image.SCALE_SMOOTH);
		BufferedImage resizedImage = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2d = resizedImage.createGraphics();
		graphics2d.drawImage(image, 0, 0, null);
		graphics2d.dispose();

		return resizedImage;
	}

	/**
	 * Set the collision status
	 * 
	 * @param collisionStatus
	 */
	public void setColliding(boolean collisionStatus) {
		isColliding = collisionStatus;
	}

	/**
	 * Get the collision status.
	 * 
	 * @return
	 */
	public boolean getColliding() {
		return isColliding;
	}

	/**
	 * Set collision status on this if it overlaps with other.
	 * 
	 * @param other
	 */
	public void setCollisionStatus(Actor other) {
		if (other instanceof Plant && this.isCollidingOther(other))
			setColliding(true);
	}

	/**
	 * Update the internal state of the Actor. This means reset the collision status
	 * to false and decrement the cool down counter.
	 */
	public void update() {
		isColliding = false;
		decrementCooldown();
		if (shamanMagicCounter > 0) {
			shamanMagicCounter--;
		}
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
