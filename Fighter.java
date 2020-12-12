package a9;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * The Fighter class extends plant. This class indicates the special
 * capabilities of the Fighter in the game. This adds a base image to the
 * character, health, strength, speed, and cool down counter. The Fighter is the
 * stronger plant type that can be placed on the board.
 * 
 * @Author Vista Marston
 *
 */
public class Fighter extends Plant {

	private static final int ATTACK_DAMAGE = 10;
	private static final int HEALTH = 100;
	private static final int COOL_DOWN = 20;
	private static final int SPEED = 0;
	private static final int COST = 70;
	private static final BufferedImage FIGHTER_IMAGE;
	private static Point2D.Double imagesPositionDouble;
	static {
		BufferedImage sapiensImage = null;
		try {
			sapiensImage = ImageIO.read(new File("src/a9/Animal-Icons/sapien1.png"));
			sapiensImage = scaleBufferedImages(sapiensImage, 80, 80);
		} catch (IOException e) {
			System.out.println("File Not Found");
			System.exit(-1);
		}
		FIGHTER_IMAGE = sapiensImage;
		imagesPositionDouble = new Point2D.Double(FIGHTER_IMAGE.getWidth(), FIGHTER_IMAGE.getHeight());
	}

	public Fighter(Double startingPosition) {
		super(startingPosition, imagesPositionDouble, FIGHTER_IMAGE, HEALTH, COOL_DOWN, SPEED, ATTACK_DAMAGE, COST);
	}

	/**
	 * Retrieves the cost to buy the fighter plant
	 */
	public int getCost() {
		return COST;
	}

	/**
	 * Scales the desirable image to represent the fighter plant class.
	 * 
	 * @param _images an image that is to represent the fighter plant
	 * @param _width  an integer that represents the desirable width of the image.
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
