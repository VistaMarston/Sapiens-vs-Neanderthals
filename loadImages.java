package a9;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Loads all of the images required for the game to run.
 * 
 * @Author Vista Marston
 *
 */
public class loadImages {
	BufferedImage gatheringImage1;
	BufferedImage gatheringImage2;
	BufferedImage gatheringImage3;
	BufferedImage gatheringImage4;
	BufferedImage gatheringImage5;
	BufferedImage gatheringImage6;
	BufferedImage gatheringImage7;
	BufferedImage gatheringImage8;
	BufferedImage gatheringImage9;
	BufferedImage rocketImage1;
	BufferedImage rocketImage2;
	BufferedImage rocketImage3;
	BufferedImage rocketImage4;
	BufferedImage rocketImage5;
	BufferedImage rocketImage6;
	BufferedImage rocketImage7;
	BufferedImage rocketImage8;
	BufferedImage rocketImage9;
	BufferedImage rocketImage10;
	BufferedImage rocketImage11;
	BufferedImage rocketImage12;
	BufferedImage sapiensImage1;
	BufferedImage sapiensImage2;
	BufferedImage sapiensImage3;
	BufferedImage sapiensImage4;
	BufferedImage sapiensImage5;
	BufferedImage sapiensImage6;
	BufferedImage sapiensImage7;
	BufferedImage sapiensImage8;
	BufferedImage sapiensImage9;
	BufferedImage sapiensImage10;
	BufferedImage sapiensImage11;
	BufferedImage sapiensImage12;
	BufferedImage sapiensImage13;
	BufferedImage sapiensImage14;
	BufferedImage zombieImage1;
	BufferedImage zombieImage2;
	BufferedImage zombieImage3;
	BufferedImage zombieImage4;
	BufferedImage zombieImage5;
	BufferedImage zombieImage6;
	BufferedImage zombieImage7;
	BufferedImage zombieImage8;
	BufferedImage zombieImage9;
	BufferedImage zombieImage10;
	BufferedImage zombieImage11;
	BufferedImage zombieImage12;
	BufferedImage zombieImage13;
	BufferedImage zombieImage14;
	BufferedImage zombieImage15;
	BufferedImage zombieImage16;
	BufferedImage zombieImage17;
	BufferedImage zombieImage18;
	BufferedImage zombieImage19;
	BufferedImage zombieImage20;
	BufferedImage zombieImage21;
	BufferedImage zombieImage22;
	BufferedImage zombieImage23;
	BufferedImage zombieImage24;
	BufferedImage sharmanImage1;
	BufferedImage sharmanImage2;
	BufferedImage sharmanImage3;
	BufferedImage sharmanImage4;
	BufferedImage sharmanImage5;
	BufferedImage sharmanImage6;
	BufferedImage sharmanImage7;
	BufferedImage sharmanImage8;
	BufferedImage sharmanImage9;
	BufferedImage sharmanImage10;
	BufferedImage sharmanImage11;
	BufferedImage sharmanImage12;
	BufferedImage sharmanImage13;
	BufferedImage sharmanImage14;
	BufferedImage sharmanImage15;
	BufferedImage sharmanImage16;
	BufferedImage sharmanImage17;
	BufferedImage sharmanImage18;
	BufferedImage sharmanImage19;
	BufferedImage sharmanImage20;
	BufferedImage sharmanImage21;
	BufferedImage sharmanImage22;
	BufferedImage sharmanImage23;
	BufferedImage sharmanImage24;
	BufferedImage sharmanImage25;
	BufferedImage sharmanImage26;
	BufferedImage sharmanImage27;
	BufferedImage sharmanImage28;
	BufferedImage sharmanImage29;
	BufferedImage sharmanImage30;
	BufferedImage sharmanImage31;
	BufferedImage strawberryImage;
	private Image backgroundImage;
	private Image endOfGameImage;
	private ArrayList<BufferedImage> zombieImages;
	private ArrayList<BufferedImage> sapiensImages;
	private ArrayList<BufferedImage> producerImages;
	private ArrayList<BufferedImage> rocketImages;
	private ArrayList<BufferedImage> sharmanImages;
	private static final int width = 80;
	private static final int height = 80;

	public loadImages() {

		zombieImages = new ArrayList<>();
		sapiensImages = new ArrayList<>();
		producerImages = new ArrayList<>();
		rocketImages = new ArrayList<>();
		sharmanImages = new ArrayList<>();

		try {
			// Gathering images
			gatheringImage1 = ImageIO.read(new File("src/a9/Animal-Icons/gather1.png"));
			gatheringImage2 = ImageIO.read(new File("src/a9/Animal-Icons/gather2.png"));
			gatheringImage3 = ImageIO.read(new File("src/a9/Animal-Icons/gather3.png"));
			gatheringImage4 = ImageIO.read(new File("src/a9/Animal-Icons/gather4.png"));
			gatheringImage5 = ImageIO.read(new File("src/a9/Animal-Icons/gather5.png"));
			gatheringImage6 = ImageIO.read(new File("src/a9/Animal-Icons/gather6.png"));
			gatheringImage7 = ImageIO.read(new File("src/a9/Animal-Icons/gather7.png"));
			gatheringImage8 = ImageIO.read(new File("src/a9/Animal-Icons/gather8.png"));
			gatheringImage9 = ImageIO.read(new File("src/a9/Animal-Icons/gather9.png"));

			// Rocket Images
			rocketImage1 = ImageIO.read(new File("src/a9/Animal-Icons/rocket1.png"));
			rocketImage2 = ImageIO.read(new File("src/a9/Animal-Icons/rocket2.png"));
			rocketImage3 = ImageIO.read(new File("src/a9/Animal-Icons/rocket3.png"));
			rocketImage4 = ImageIO.read(new File("src/a9/Animal-Icons/rocket4.png"));
			rocketImage5 = ImageIO.read(new File("src/a9/Animal-Icons/rocket5.png"));
			rocketImage6 = ImageIO.read(new File("src/a9/Animal-Icons/rocket6.png"));
			rocketImage7 = ImageIO.read(new File("src/a9/Animal-Icons/rocket7.png"));
			rocketImage8 = ImageIO.read(new File("src/a9/Animal-Icons/rocket8.png"));
			rocketImage9 = ImageIO.read(new File("src/a9/Animal-Icons/rocket9.png"));
			rocketImage10 = ImageIO.read(new File("src/a9/Animal-Icons/rocket10.png"));
			rocketImage11 = ImageIO.read(new File("src/a9/Animal-Icons/rocket11.png"));
			rocketImage12 = ImageIO.read(new File("src/a9/Animal-Icons/rocket12.png"));

			// Sapiens Images
			sapiensImage1 = ImageIO.read(new File("src/a9/Animal-Icons/sapien1.png"));
			sapiensImage2 = ImageIO.read(new File("src/a9/Animal-Icons/sapien2.png"));
			sapiensImage3 = ImageIO.read(new File("src/a9/Animal-Icons/sapien3.png"));
			sapiensImage4 = ImageIO.read(new File("src/a9/Animal-Icons/sapien4.png"));
			sapiensImage5 = ImageIO.read(new File("src/a9/Animal-Icons/sapien5.png"));
			sapiensImage6 = ImageIO.read(new File("src/a9/Animal-Icons/sapien6.png"));
			sapiensImage7 = ImageIO.read(new File("src/a9/Animal-Icons/sapien7.png"));
			sapiensImage8 = ImageIO.read(new File("src/a9/Animal-Icons/sapien8.png"));
			sapiensImage9 = ImageIO.read(new File("src/a9/Animal-Icons/sapien9.png"));
			sapiensImage10 = ImageIO.read(new File("src/a9/Animal-Icons/sapien10.png"));
			sapiensImage11 = ImageIO.read(new File("src/a9/Animal-Icons/sapien11.png"));
			sapiensImage12 = ImageIO.read(new File("src/a9/Animal-Icons/sapien12.png"));
			sapiensImage13 = ImageIO.read(new File("src/a9/Animal-Icons/sapien13.png"));
			sapiensImage14 = ImageIO.read(new File("src/a9/Animal-Icons/sapien14.png"));

			// Neanderthals Images
			zombieImage1 = ImageIO.read(new File("src/a9/Animal-Icons/zombie1.png"));
			zombieImage2 = ImageIO.read(new File("src/a9/Animal-Icons/zombie2.png"));
			zombieImage3 = ImageIO.read(new File("src/a9/Animal-Icons/zombie3.png"));
			zombieImage4 = ImageIO.read(new File("src/a9/Animal-Icons/zombie4.png"));
			zombieImage5 = ImageIO.read(new File("src/a9/Animal-Icons/zombie5.png"));
			zombieImage6 = ImageIO.read(new File("src/a9/Animal-Icons/zombie6.png"));
			zombieImage7 = ImageIO.read(new File("src/a9/Animal-Icons/zombie7.png"));
			zombieImage8 = ImageIO.read(new File("src/a9/Animal-Icons/zombie8.png"));
			zombieImage9 = ImageIO.read(new File("src/a9/Animal-Icons/zombie9.png"));
			zombieImage10 = ImageIO.read(new File("src/a9/Animal-Icons/zombie10.png"));
			zombieImage11 = ImageIO.read(new File("src/a9/Animal-Icons/zombie11.png"));
			zombieImage12 = ImageIO.read(new File("src/a9/Animal-Icons/zombie12.png"));
			zombieImage13 = ImageIO.read(new File("src/a9/Animal-Icons/zombie13.png"));
			zombieImage14 = ImageIO.read(new File("src/a9/Animal-Icons/zombie14.png"));
			zombieImage15 = ImageIO.read(new File("src/a9/Animal-Icons/zombie15.png"));
			zombieImage16 = ImageIO.read(new File("src/a9/Animal-Icons/zombie16.png"));
			zombieImage17 = ImageIO.read(new File("src/a9/Animal-Icons/zombie17.png"));
			zombieImage18 = ImageIO.read(new File("src/a9/Animal-Icons/zombie18.png"));
			zombieImage19 = ImageIO.read(new File("src/a9/Animal-Icons/zombie19.png"));
			zombieImage20 = ImageIO.read(new File("src/a9/Animal-Icons/zombie20.png"));
			zombieImage21 = ImageIO.read(new File("src/a9/Animal-Icons/zombie21.png"));
			zombieImage22 = ImageIO.read(new File("src/a9/Animal-Icons/zombie22.png"));
			zombieImage23 = ImageIO.read(new File("src/a9/Animal-Icons/zombie23.png"));
			zombieImage24 = ImageIO.read(new File("src/a9/Animal-Icons/zombie24.png"));
			

			// Sharman Images
			sharmanImage1 = ImageIO.read(new File("src/a9/Animal-Icons/sharman1.png"));
			sharmanImage2 = ImageIO.read(new File("src/a9/Animal-Icons/sharman2.png"));
			sharmanImage3 = ImageIO.read(new File("src/a9/Animal-Icons/sharman3.png"));
			sharmanImage4 = ImageIO.read(new File("src/a9/Animal-Icons/sharman4.png"));
			sharmanImage5 = ImageIO.read(new File("src/a9/Animal-Icons/sharman5.png"));
			sharmanImage6 = ImageIO.read(new File("src/a9/Animal-Icons/sharman6.png"));
			sharmanImage7 = ImageIO.read(new File("src/a9/Animal-Icons/sharman7.png"));
			sharmanImage8 = ImageIO.read(new File("src/a9/Animal-Icons/sharman8.png"));
			sharmanImage9 = ImageIO.read(new File("src/a9/Animal-Icons/sharman9.png"));
			sharmanImage10 = ImageIO.read(new File("src/a9/Animal-Icons/sharman10.png"));
			sharmanImage11 = ImageIO.read(new File("src/a9/Animal-Icons/sharman11.png"));
			sharmanImage12 = ImageIO.read(new File("src/a9/Animal-Icons/sharman12.png"));
			sharmanImage13 = ImageIO.read(new File("src/a9/Animal-Icons/sharman13.png"));
			sharmanImage14 = ImageIO.read(new File("src/a9/Animal-Icons/sharman14.png"));
			sharmanImage15 = ImageIO.read(new File("src/a9/Animal-Icons/sharman15.png"));
			sharmanImage16 = ImageIO.read(new File("src/a9/Animal-Icons/sharman16.png"));
			sharmanImage17 = ImageIO.read(new File("src/a9/Animal-Icons/sharman17.png"));
			sharmanImage18 = ImageIO.read(new File("src/a9/Animal-Icons/sharman18.png"));
			sharmanImage19 = ImageIO.read(new File("src/a9/Animal-Icons/sharman19.png"));
			sharmanImage20 = ImageIO.read(new File("src/a9/Animal-Icons/sharman20.png"));
			sharmanImage21 = ImageIO.read(new File("src/a9/Animal-Icons/sharman21.png"));
			sharmanImage22 = ImageIO.read(new File("src/a9/Animal-Icons/sharman22.png"));
			sharmanImage23 = ImageIO.read(new File("src/a9/Animal-Icons/sharman23.png"));
			sharmanImage24 = ImageIO.read(new File("src/a9/Animal-Icons/sharman24.png"));
			sharmanImage25 = ImageIO.read(new File("src/a9/Animal-Icons/sharman25.png"));
			sharmanImage26 = ImageIO.read(new File("src/a9/Animal-Icons/sharman26.png"));
			sharmanImage27 = ImageIO.read(new File("src/a9/Animal-Icons/sharman27.png"));
			sharmanImage28 = ImageIO.read(new File("src/a9/Animal-Icons/sharman28.png"));
			sharmanImage29 = ImageIO.read(new File("src/a9/Animal-Icons/sharman29.png"));
			sharmanImage30 = ImageIO.read(new File("src/a9/Animal-Icons/sharman30.png"));
			sharmanImage31 = ImageIO.read(new File("src/a9/Animal-Icons/sharman31.png"));
			
			
			strawberryImage = ImageIO.read(new File("src/a9/Animal-Icons/strawberry.png"));

			backgroundImage = ImageIO.read(new File("src/a9/Animal-Icons/betterBackground.png"));
			endOfGameImage = ImageIO.read(new File("src/a9/Animal-Icons/betterBackground.png"));
		} catch (IOException e) {
			System.out.println("A file was not found");
			System.exit(0);
		}

		// Adding images to a list
		producerImages.add(gatheringImage1);
		producerImages.add(gatheringImage2);
		producerImages.add(gatheringImage3);
		producerImages.add(gatheringImage4);
		producerImages.add(gatheringImage5);
		producerImages.add(gatheringImage6);
		producerImages.add(gatheringImage7);
		producerImages.add(gatheringImage8);
		producerImages.add(gatheringImage9);

		// Adding images to a list
		rocketImages.add(rocketImage1);
		rocketImages.add(rocketImage2);
		rocketImages.add(rocketImage3);
		rocketImages.add(rocketImage4);
		rocketImages.add(rocketImage5);
		rocketImages.add(rocketImage6);
		rocketImages.add(rocketImage7);
		rocketImages.add(rocketImage8);
		rocketImages.add(rocketImage9);
		rocketImages.add(rocketImage10);
		rocketImages.add(rocketImage11);
		rocketImages.add(rocketImage12);

		sapiensImages.add(sapiensImage1);
		sapiensImages.add(sapiensImage2);
		sapiensImages.add(sapiensImage3);
		sapiensImages.add(sapiensImage4);
		sapiensImages.add(sapiensImage5);
		sapiensImages.add(sapiensImage6);
		sapiensImages.add(sapiensImage7);
		sapiensImages.add(sapiensImage8);
		sapiensImages.add(sapiensImage9);
		sapiensImages.add(sapiensImage10);
		sapiensImages.add(sapiensImage11);
		sapiensImages.add(sapiensImage12);
		sapiensImages.add(sapiensImage13);
		sapiensImages.add(sapiensImage14);

		zombieImages.add(zombieImage1);
		zombieImages.add(zombieImage2);
		zombieImages.add(zombieImage3);
		zombieImages.add(zombieImage4);
		zombieImages.add(zombieImage5);
		zombieImages.add(zombieImage6);
		zombieImages.add(zombieImage7);
		zombieImages.add(zombieImage8);
		zombieImages.add(zombieImage9);
		zombieImages.add(zombieImage10);
		zombieImages.add(zombieImage11);
		zombieImages.add(zombieImage12);
		zombieImages.add(zombieImage12);
		zombieImages.add(zombieImage13);
		zombieImages.add(zombieImage14);
		zombieImages.add(zombieImage15);
		zombieImages.add(zombieImage16);
		zombieImages.add(zombieImage17);
		zombieImages.add(zombieImage18);
		zombieImages.add(zombieImage19);
		zombieImages.add(zombieImage20);
		zombieImages.add(zombieImage21);
		zombieImages.add(zombieImage22);
		zombieImages.add(zombieImage23);
		zombieImages.add(zombieImage24);
		
		sharmanImages.add(sharmanImage1);
		sharmanImages.add(sharmanImage2);
		sharmanImages.add(sharmanImage3);
		sharmanImages.add(sharmanImage4);
		sharmanImages.add(sharmanImage5);
		sharmanImages.add(sharmanImage6);
		sharmanImages.add(sharmanImage7);
		sharmanImages.add(sharmanImage8);
		sharmanImages.add(sharmanImage9);
		sharmanImages.add(sharmanImage10);
		sharmanImages.add(sharmanImage11);
		sharmanImages.add(sharmanImage12);
		sharmanImages.add(sharmanImage13);
		sharmanImages.add(sharmanImage14);
		sharmanImages.add(sharmanImage15);
		sharmanImages.add(sharmanImage16);
		sharmanImages.add(sharmanImage17);
		sharmanImages.add(sharmanImage18);
		sharmanImages.add(sharmanImage19);
		sharmanImages.add(sharmanImage20);
		sharmanImages.add(sharmanImage21);
		sharmanImages.add(sharmanImage22);
		sharmanImages.add(sharmanImage23);
		sharmanImages.add(sharmanImage24);
		sharmanImages.add(sharmanImage25);
		sharmanImages.add(sharmanImage26);
		sharmanImages.add(sharmanImage27);
		sharmanImages.add(sharmanImage28);
		sharmanImages.add(sharmanImage29);
		sharmanImages.add(sharmanImage30);
		sharmanImages.add(sharmanImage31);
		
		producerImages = scaleBufferedImages(producerImages, width, height);
		zombieImages = scaleBufferedImages(zombieImages, width, height);
		rocketImages = scaleBufferedImages(rocketImages, width, height);
		sapiensImages = scaleBufferedImages(sapiensImages, width, height);
		sharmanImages = scaleBufferedImages(sharmanImages, width, height);
	}

	/**
	 * Retrieves all of the loaded images that belong to the Producer class.
	 * 
	 * @return An ArrayList of BufferedImages of all of the producer class images.
	 */
	public ArrayList<BufferedImage> getProducerImages() {
		return producerImages;
	}
	
	public Image getEndOfGameImage() {
		return endOfGameImage;
	}

	/**
	 * Retrieves all of the loaded images that belong to the sapiens class.
	 * 
	 * @return An ArrayList of BufferedImages of all of the sapiens class
	 */
	public ArrayList<BufferedImage> getSapiensImages() {
		return sapiensImages;
	}

	/**
	 * Retrieves all of the loaded images that belong to the zombies class.
	 * 
	 * @return An ArrayList of BufferedImages of all of the zombie class.
	 */
	public ArrayList<BufferedImage> getZombieImages() {
		return zombieImages;
	}

	/**
	 * Retrieves the image for the background of the game.
	 * 
	 * @return A buffered Images that is used for the background of the game.
	 */
	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Retrieves the image used for the resources within the game.
	 * 
	 * @return
	 */
	public BufferedImage getStrawberryImage() {
		return strawberryImage;
	}

	/**
	 * Retrieves all of the images that are used for the rocket class.
	 * 
	 * @return an ArrayList of Buffered Images of all of the images in the rocket
	 *         Image class
	 */
	public ArrayList<BufferedImage> getRocketImages() {
		return rocketImages;
	}
	
	public ArrayList<BufferedImage> getSharmanImages() {
		return sharmanImages;
	}
	
	/**
	 * Produces a Buffered Image that is scaled based on a desirable width and
	 * height.
	 * 
	 * @param _image  A buffered image that is needed to be scaled.
	 * @param _width  An integer of the desirable width of the image
	 * @param _height An integer of the desirable height of the image.
	 * @return
	 */
	private ArrayList<BufferedImage> scaleBufferedImages(ArrayList<BufferedImage> _images, int _width, int _height) {
		ArrayList<BufferedImage> scaledPhotoList = new ArrayList<>();
		for (int index = 0; index < _images.size(); index++) {
			Image image = _images.get(index).getScaledInstance(_width, _height, Image.SCALE_SMOOTH);
			BufferedImage resizedImage = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics2d = resizedImage.createGraphics();
			graphics2d.drawImage(image, 0, 0, null);
			graphics2d.dispose();
			scaledPhotoList.add(resizedImage);
		}

		return scaledPhotoList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
