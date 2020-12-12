package a9;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * The ShamenZombie class extends Zombie. This class has the special ability to
 * spawn Club Zombies on the board game at random intervals.
 * 
 * @author Vista Marston
 *
 */
public class ShamenZombie extends Zombie {

	private static final int HEALTH = 100;
	private static final int COOL_DOWN = 70;
	private static final double SPEED = 0;
	private static final int ATTACK_DAMAGE = 0;
	private int appearingCounter;
	private boolean isColliding;
	private static final BufferedImage SHAMAN_IMAGE;
	private static Point2D.Double imagesPositionDouble;

	static {
		BufferedImage sharmanImage1 = null;
		try {
			sharmanImage1 = ImageIO.read(new File("src/a9/Animal-Icons/sharman1.png"));
			sharmanImage1 = scaleBufferedImages(sharmanImage1, 80, 80);
		} catch (IOException e) {
			System.out.println("File Not Found");
			System.exit(-1);
		}
		SHAMAN_IMAGE = sharmanImage1;
		imagesPositionDouble = new Point2D.Double(SHAMAN_IMAGE.getWidth(), SHAMAN_IMAGE.getHeight());
	}

	public ShamenZombie(Double startingPosition) {
		super(startingPosition, imagesPositionDouble, SHAMAN_IMAGE, HEALTH, COOL_DOWN, SPEED, ATTACK_DAMAGE);
		appearingCounter = 0;
		isColliding = false;
	}

	/**
	 * Sets the collision status of the Shaman Actor
	 * 
	 * @param collisionStatus A boolean representing if the actor is touching any
	 *                        other character on the board.
	 */
	public void setColliding(boolean collisionStatus) {
		isColliding = collisionStatus;
	}

	/**
	 * Sets the collision status of the Shaman Actor if the Shawman is down
	 * appearing on the screen.
	 */
	@Override
	public void setCollisionStatus(Actor other) {
		if (getAppearingCounter() > 4) {
			setColliding(true);
		}
	}

	/**
	 * Retrieves the collision status of the Shawman character.
	 * 
	 * @return a boolean that represents whether the actor is colliding with other
	 *         actors.
	 */
	public boolean getCollisionStatus() {
		return isColliding;
	}

	/**
	 * Retrieves the appearing counter of the Shamen appearing on the screen.
	 * 
	 * @return an integer that represents the time that the Shamen as been appearing
	 */
	public int getAppearingCounter() {
		return appearingCounter;
	}

	/**
	 * Updates the appearing counter.
	 */
	public void updateAppearingCounter() {
		appearingCounter++;
	}

	/**
	 * Update the cool down timer and the appearing counter.
	 */
	@Override
	public void update() {
		updateAppearingCounter();
		decrementCooldown();
	}

	/**
	 * Indicates whether the actor is ready for action.
	 * 
	 * @return A boolean true if the actor is ready to attack, otherwise false.
	 */
	@Override
	public boolean isReadyForAction() {
		if (appearingCounter > 4 && getCoolDownCounter() <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * Scales the image of the Shamen image
	 * 
	 * @param _images an images that represents the shamen
	 * @param _width  an integer that represents the desirable width of the image
	 * @param _height an integer that represents the desirable height of the image.
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
