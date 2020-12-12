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
 * The producer class extends plant. This class has the special ability to
 * provide resources through out the game. Does minimal damage when fighting.
 * 
 * @author Vista Marston
 *
 */
public class Producer extends Plant {

	private int producerTimer;
	private int totalProductiontime;
	private int resourceTotal;
	private static final double SPEED = 0;
	private static final int ATTACK_DAMAGE = 5;
	private static final int HEALTH = 100;
	private static final int COOL_DOWN = 10;
	private static final int COST = 70;
	private static final BufferedImage PRODUCER_IMAGE;
	private static Point2D.Double imagePositionDouble;

	static {
		BufferedImage gatheringImage = null;
		try {
			gatheringImage = ImageIO.read(new File("src/a9/Animal-Icons/gather1.png"));
			gatheringImage = scaleBufferedImages(gatheringImage, 80, 80);
		} catch (IOException e) {
			System.out.println("File not Found");
			System.exit(-1);
		}
		PRODUCER_IMAGE = gatheringImage;
		imagePositionDouble = new Point2D.Double(PRODUCER_IMAGE.getWidth(), PRODUCER_IMAGE.getHeight());
	}

	public Producer(Double startingPosition) {
		super(startingPosition, imagePositionDouble, PRODUCER_IMAGE, HEALTH, COOL_DOWN, SPEED, ATTACK_DAMAGE, COST);
		totalProductiontime = 70;
		producerTimer = totalProductiontime;
		resourceTotal = 30;
	}

	/**
	 * Produces a boolean value to indicate whether resources can be gathered.
	 * 
	 * @return a yes if sources can be given and No if resources can be gathered.
	 */
	public Boolean getResources() {
		return producerTimer <= 0;
	}

	/**
	 * Changes the timer for the ability to gather resources.
	 * 
	 */
	public void changeProducerTimer() {
		if (producerTimer > 0) {
			producerTimer--;
		} else {
			producerTimer = totalProductiontime;
		}
	}

	/**
	 * gathers resources within the game.
	 * 
	 * @return an integer value that represent the amount of resources that will be
	 *         given during the game.
	 */
	public int supplyResources() {
		if (getResources()) {
			return resourceTotal;
		} else {
			return 0;
		}
	}

	/**
	 * Gets the cost of each producer
	 * 
	 * @return an integer representing the cost to place the producer sprite
	 */
	public int getCost() {
		return COST;
	}

	/**
	 * Scales the desirable image to represent the producer plant
	 * 
	 * @param _images an buffered image that represents the producer plant
	 * @param _width  an integer that represents the desirable width of the image
	 * @param _height an integer that represents the desirable height of teh image.
	 * @return a buffered image that has been scaled.
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
