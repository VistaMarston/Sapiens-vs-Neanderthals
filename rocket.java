package a9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import sun.awt.www.content.audio.x_aiff;

/**
 * The rocket class extends plant. This class has the special ability to kill
 * any zombies that it touches. This is the last result in the game.
 * 
 * @author Vista Marston
 *
 */
public class rocket extends Plant {

	private static int speed = 0;
	private double finalSpeed;
	private static final int ATTACK_DAMAGE = 1000;
	private static final int COOL_DOWN = 0;
	private static final int HEALTH = 100;
	private static final int COST = 0;
	private static final BufferedImage ROCKET_IMAGE;
	private static Point2D.Double imagePositionPoint2d;
	private static final int nCol = 7;
	private static final int gridSize = 120;
	private static final int xGaps = 30;
	private static final int yGaps = 130;
	public static final int xWindowBounds = xGaps + nCol * gridSize;
	static {
		BufferedImage rocketImage1 = null;
		try {
			rocketImage1 = ImageIO.read(new File("src/a9/Animal-Icons/rocket1.png"));
			rocketImage1 = scaleBufferedImages(rocketImage1, 80, 80);
		} catch (IOException e) {
			System.out.println("File Not Found");
			System.exit(-1);
		}
		ROCKET_IMAGE = rocketImage1;

		imagePositionPoint2d = new Point2D.Double(ROCKET_IMAGE.getWidth(), ROCKET_IMAGE.getHeight());
	}

	public rocket(Point2D.Double startingPosition) {
		super(startingPosition, imagePositionPoint2d, ROCKET_IMAGE, HEALTH, COOL_DOWN, speed, ATTACK_DAMAGE, COST);
		this.finalSpeed = 10.0;
	}

	/**
	 * Retrieves the final speed for the rocket.
	 * 
	 * @return double value representing the the final speed of the rocket.
	 */
	public double getFinalSpeed() {
		return finalSpeed;
	}

	private static BufferedImage scaleBufferedImages(BufferedImage _images, int _width, int _height) {
		Image image = _images.getScaledInstance(_width, _height, Image.SCALE_SMOOTH);
		BufferedImage resizedImage = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2d = resizedImage.createGraphics();
		graphics2d.drawImage(image, 0, 0, null);
		graphics2d.dispose();

		return resizedImage;
	}

	/**
	 * Prevents the drawing of the health Bar on the rocket
	 */
	@Override
	public void drawHealthBar(Graphics g) {
	}

	/**
	 * Checks to see if the rocket is still on the screen.
	 */
	@Override
	public boolean isAlive() {
		return this.getPosition().getX() < xWindowBounds;
	}

	public static void main(String[] args) {

	}

	/**
	 * Changes the speed of the rocket when the zombie collides with the rocket.
	 */
	@Override
	public void attack(Actor other) {
		if (this != other && this.isCollidingOther(other)) {
			if (this.isReadyForAction()) {
				other.changeHealth(-attackDamage);
				this.resetCoolDown();
				changeSpeed(finalSpeed);
			}
		}
	}

}
