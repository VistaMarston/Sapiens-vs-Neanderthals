package a9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The JPanel that controls the game play within the game.
 * 
 * @author dejohnso
 * @Author Vista Marston
 *
 */
public class GameConsole extends JPanel {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	private ArrayList<Actor> actors;
	BufferedImage figherImage;
	BufferedImage producerImage;
	BufferedImage strawberryImage;
	private ArrayList<BufferedImage> sapiensImages;
	private ArrayList<BufferedImage> producerImages;
	private ArrayList<BufferedImage> clubZombieImages;
	private ArrayList<BufferedImage> shamanImages;
	private ArrayList<BufferedImage> rocketImages;
	private JPanel currentGamePanel;
	private JButton playButton;
	private JButton pauseButton;
	private JButton gatherButton;
	private JButton fighterButton;
	private Image endOfGameImage;
	private Image backgroundImage;
	private Image gameBackground;
	private JLabel resourceLabel;
	public int resourceCounter;
	private int frameNumber;
	private int levelTracker;
	private static final int ZombiePerRound = 5;
	private static final int ShamanPerRound = 1;
	private static final int ResourcePerTurn = 200;
	private static final int RandomlyGivenResources = 20;
	private static final double ButtonEdge = 63.0;
	private static final int ShamanAppearingCount = 10;
	private static final int ShamanDisappearingCount = 55;
	private int bufferTimer;
	private int zombieCounter;
	private int shamanCounter;
	private int randomResourceCounter;
	private double startX;
	private double startY;
	private String status;
	private static final int nRows = 5;
	private static final int nCol = 7;
	private static final int gridSize = 120;
	private static final int xGaps = 30;
	private static final int yGaps = 130;
	public static final int xWindowBounds = xGaps + nCol * gridSize;
	private static final int yWindowBounds = yGaps + nRows * gridSize;
	private Clip backgroundClip;

	public GameConsole() {
		super();

		resourceCounter = ResourcePerTurn;
		frameNumber = 0;
		zombieCounter = 0;
		bufferTimer = 0;
		levelTracker = 1;
		shamanCounter = 1;
		randomResourceCounter = 40;
		setPreferredSize(new Dimension(xWindowBounds, yWindowBounds));
		actors = new ArrayList<>();
		producerImages = new ArrayList<>();
		sapiensImages = new ArrayList<>();
		clubZombieImages = new ArrayList<>();
		shamanImages = new ArrayList<>();
		rocketImages = new ArrayList<>();
		status = "play";

		uploadImages();
		scaleAllImages();
		placeRockets();

		backgroundImage = gameBackground;

		timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateGameFrame();

			}
		});
		timer.start();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		currentGamePanel = createGamePanel();
		this.add(currentGamePanel);

	}

	/**
	 * Scales All of the images within the game.
	 */
	private void scaleAllImages() {
		gameBackground = scaleImages(gameBackground, xWindowBounds, yWindowBounds);
		endOfGameImage = scaleImages(endOfGameImage, xWindowBounds, yWindowBounds);
	}

	/**
	 * Creates a JPanel for the Buttons that are within the game.
	 * 
	 * @return JPanel of all the buttons that are within the game.
	 */
	private JPanel createGamePanel() {
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(350, 60));
		gamePanel.setOpaque(false);
		GridLayout layout = new GridLayout(1, 4);
		layout.setHgap(10);
		gamePanel.setLayout(layout);

		JPanel gameControlJPanel = new JPanel();
		GridLayout gameLayout = new GridLayout(2, 1);
		gameControlJPanel.setLayout(gameLayout);
		gameControlJPanel.setOpaque(false);

		// Get Correct Images
		ArrayList<ImageIcon> iconsList = new ArrayList<>();
		ArrayList<BufferedImage> producerImage = scaleBufferedImages(producerImages, 40, 40);
		ImageIcon imageIcon = new ImageIcon(producerImage.get(0));
		iconsList.add(imageIcon);
		ArrayList<BufferedImage> sapienImage = scaleBufferedImages(sapiensImages, 40, 40);
		ImageIcon imageIcon1 = new ImageIcon(sapienImage.get(0));
		iconsList.add(imageIcon1);
		ImageIcon imageIcon2 = new ImageIcon(strawberryImage);
		iconsList.add(imageIcon2);

		setUpMusic();

		// Resource Label
		resourceLabel = new JLabel(resourceCounter + " Total", iconsList.get(2), SwingConstants.CENTER);
		gamePanel.add(resourceLabel);

		// Sapiens Buttons
		gatherButton = new JButton("Cost: 70", iconsList.get(0));
		gatherButton.setPreferredSize(new Dimension(50, 60));
		gatherButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		gatherButton.setHorizontalTextPosition(SwingConstants.CENTER);
		gatherButton.setFont(new Font("Cost: 70", Font.BOLD, 12));
		gatherButton.setBackground(Color.yellow.brighter());
		gatherButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				addMorePlants(e);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				startX = currentGamePanel.getComponent(1).getX();
				startY = currentGamePanel.getComponent(1).getY();

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		gamePanel.add(gatherButton);
		fighterButton = new JButton("Cost: 70", iconsList.get(1));
		fighterButton.setPreferredSize(new Dimension(50, 60));
		fighterButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		fighterButton.setHorizontalTextPosition(SwingConstants.CENTER);
		fighterButton.setFont(new Font("Cost: 70", Font.BOLD, 12));
		fighterButton.setBackground(Color.yellow.brighter());
		fighterButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				addMorePlants(e);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				startX = currentGamePanel.getComponent(2).getX();
				startY = currentGamePanel.getComponent(2).getX();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		gamePanel.add(fighterButton);

		playButton = new JButton("Play");
		playButton.setBackground(Color.GREEN.brighter());
		playButton.setPreferredSize(new Dimension(30, 25));
		gameControlJPanel.add(playButton);
		playButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed(e);

			}
		});

		pauseButton = new JButton("Pause");
		pauseButton.setBackground(Color.RED.brighter());
		pauseButton.setPreferredSize(new Dimension(30, 25));
		gameControlJPanel.add(pauseButton);
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPressed(e);

			}
		});
		gamePanel.add(gameControlJPanel);
		return gamePanel;
	}

	/**
	 * Adds the plant subclasses to the board based on the location of the mouse
	 * 
	 * @param e MouseEvent of a button being clicked
	 */
	private void addMorePlants(MouseEvent e) {
		Point imagePoint = e.getPoint();

		double xPosition = imagePoint.getX();
		double yPosition = imagePoint.getY();

		int col = (int) (Math.abs((xPosition + startX)) - xGaps) / gridSize;
		int row = (int) (Math.abs((yPosition + startY)) - yGaps) / gridSize;

		// Check the location to insure that no other plants are in the location
		if (row > -1 && row < 6 && col > -1 && col < 7 && resourceCounter >= 70) {
			if (e.getSource() == fighterButton) {
				if (!isSpaceFull(row - 1, col)) {
					if(yPosition > ButtonEdge) {
					Point2D.Double startingPosition = new Point2D.Double(col * gridSize + xGaps,
							(row) * gridSize + yGaps - gridSize);
					Fighter fighter = new Fighter(startingPosition);
					for (int index = 0; index < sapiensImages.size(); index++) {
						fighter.add(sapiensImages.get(index));
					}
					actors.add(fighter);
					resourceCounter -= fighter.getCost();
					resourceLabel.updateUI();
				}}
			} else if (e.getSource() == gatherButton) {
				if (!isSpaceFull(row, col)) {
					Point2D.Double startingPosition = new Point2D.Double(col * gridSize + xGaps,
							row * gridSize + yGaps);
					Producer producer = new Producer(startingPosition);
					for (int index = 0; index < producerImages.size(); index++) {
						producer.add(producerImages.get(index));
					}
					actors.add(producer);
					resourceCounter -= producer.getCost();
				}
			}
		}
	}

	/**
	 * Sets up the music within the game.
	 */
	public void setUpMusic() {
		try {
			AudioInputStream backgroungMusicFile = AudioSystem
					.getAudioInputStream(new File("src/a9/POL-king-of-coins-short.wav"));
			backgroundClip = AudioSystem.getClip();
			backgroundClip.open(backgroungMusicFile);
			backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception e) {
			System.out.println("file not found");
			System.exit(-2);
		}
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

	/**
	 * Loads Every image in the game.
	 */
	public void uploadImages() {
		loadImages images = new loadImages();
		producerImages = images.getProducerImages();
		sapiensImages = images.getSapiensImages();
		strawberryImage = images.getStrawberryImage();
		gameBackground = images.getBackgroundImage();
		endOfGameImage = images.getEndOfGameImage();
		clubZombieImages = images.getZombieImages();
		shamanImages = images.getSharmanImages();
		rocketImages = images.getRocketImages();

	}

	/**
	 * Produces an image that is scaled based on a desirable width and height
	 * 
	 * @param _image  An image that is needing to be scaled
	 * @param _width  An integer that represents the desirable width
	 * @param _height An integer that represents the desirable height
	 * @return
	 */
	private Image scaleImages(Image _image, int _width, int _height) {

		Image image = _image.getScaledInstance(_width, _height, Image.SCALE_SMOOTH);
		BufferedImage resizedImage = new BufferedImage(_width, _height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D graphics2d = resizedImage.createGraphics();
		graphics2d.drawImage(image, 0, 0, null);
		graphics2d.dispose();
		return resizedImage;
	}

	/**
	 * Retrieves the grid size of the grid within the game.
	 * 
	 * @return the gridSize of the grid within the game.
	 */
	public int getGridSize() {
		return gridSize;
	}

	/**
	 * Creates actions based on what buttons are pressed within the game.
	 * 
	 * @param e An ActionEvent that happens when a button is pressed.
	 */
	private void buttonPressed(ActionEvent e) {
		if (e.getSource() == playButton) {
			timer.start();
			if (actors.size() == 0) {
				placeRockets();
			}
			if (status.equals("paused")) {
				backgroundClip.start();
				status = "play";
			}
		} else {
			timer.stop();
			if (status.equals("play")) {
				backgroundClip.stop();
				status = "paused";
			}
		}

	}

	/**
	 * Places rockets on the board on the first column spaces in the game.
	 */
	private void placeRockets() {
		for (int index = 0; index < nRows; index++) {
			int xPosition = xGaps;
			int yPosition = index * gridSize + yGaps;
			rocket rocket = new rocket(new Point2D.Double(xPosition, yPosition));
			for (int value = 0; value < rocketImages.size(); value++) {
				rocket.add(rocketImages.get(value));
			}
			actors.add(rocket);
		}
	}

	/***
	 * Implement the paint method to draw the plants
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, null);
		for (Actor actor : actors) {
			// Actors that are not moving
			if (actor.getSpeed() == 0) {
				if (actor instanceof rocket) {
					actor.draw(g, (frameNumber % 8));
					actor.drawHealthBar(g);
				} else if (actor instanceof ShamenZombie) {
					// Shamen is appearing on the screen
					if (((ShamenZombie) actor).getAppearingCounter() < ShamanAppearingCount) {
						actor.draw(g, (frameNumber % 10));
						// Shamen attacking
					} else if (((ShamenZombie) actor).getAppearingCounter() < ShamanDisappearingCount) {
						actor.draw(g, (frameNumber % 11) + 11);
					} else {
						// Shamen is leaving
						actor.draw(g, (frameNumber % 10) + 22);
					}
				} else if (actor instanceof ClubZombie) {
					// If Club zombie was created by Shamen
					if (((ClubZombie) actor).getShamanCounter() > 0) {
						actor.draw(g, (frameNumber % 12) + 14);
					} else {
						actor.draw(g, (frameNumber % 8) + 5);
						actor.drawHealthBar(g);
					}
				} else {
					actor.draw(g, frameNumber);
					actor.drawHealthBar(g);
				}
			} else {
				// Actors are moving
				if (actor instanceof rocket) {
					actor.draw(g, ((frameNumber % 4) + 9));
					actor.drawHealthBar(g);
				} else {
					actor.draw(g, frameNumber % 4);
					actor.drawHealthBar(g);
				}
			}
		}

	}

	/**
	 * Updates all of the Actors within the game
	 */
	public void updateActors() {
		for (Actor actor : actors) {
			actor.update();
		}
		bufferTimer++;
		randomResourceCounter--;
		if (randomResourceCounter <= 0) {
			resourceCounter += RandomlyGivenResources;
			randomResourceCounter = 40;
		}
	}

	/**
	 * Allows actors to attack each other
	 */
	public void actorAttack() {
		int shamanCounter = 0;
		for (Actor actor : actors) {
			for (Actor other : actors) {
				if (actor instanceof ShamenZombie && actor.isReadyForAction()) {
					shamanCounter++;
					actor.resetCoolDown();
				} else {
					actor.attack(other);
				}
			}
		}
		if (shamanCounter > 0) {
			// If Shaman is ready for action produce more zombies
			Random randGenerator = new Random();
			int row = randGenerator.nextInt(nRows);
			int col = randGenerator.nextInt(nCol - 1);
			if (col < 2) {
				col = 2;
			}
			ClubZombie zombie = new ClubZombie(new Point2D.Double(xGaps + col * gridSize, yGaps + row * gridSize));
			for (int index = 0; index < clubZombieImages.size(); index++) {
				zombie.add(clubZombieImages.get(index));
			}
			zombie.changeSpeed(0);
			zombie.changeAttackDamage(levelTracker);
			zombie.setShamanCounter();
			actors.add(zombie);
		}
	}

	/**
	 * Removes all of the actors that has health that is less than zero.
	 */
	public void deletingDead() {
		ArrayList<Actor> nextTurnActors = new ArrayList<>();
		for (Actor actor : actors) {
			if (actor.isAlive()) {
				if (actor instanceof ShamenZombie && ((ShamenZombie) actor).getAppearingCounter() < 100) {
					nextTurnActors.add(actor);
				} else if (!(actor instanceof ShamenZombie)) {
					nextTurnActors.add(actor);
				}
			} else
				actor.removeAction(actors); // any special effect or whatever on removal
		}
		actors = nextTurnActors;
	}

	/**
	 * Checks to see if any actors are colliding within the game.
	 */
	public void checkForCollisions() {
		for (Actor actor : actors) {
			for (Actor other : actors) {
				actor.setCollisionStatus(other);
			}
		}
	}

	/**
	 * Moves actors within the game.
	 */
	public void moveActors() {
		for (Actor actor : actors) {
			actor.move(); // for Zombie, only moves if not colliding.
		}
	}

	/**
	 * Checks the occupancy of a space within the game board.
	 * 
	 * @param row an Integer value that represents the desirable row number.
	 * @param col an Integer value that represents the desirable column number.
	 * @return A boolean expression of whether the space is full or not. True
	 *         representing that the space is already full.
	 */
	private Boolean isSpaceFull(int row, int col) {
		int xPosition = xGaps + col * gridSize;
		int yPosition = yGaps + row * gridSize;
		Point2D.Double desirablePosition = new Point2D.Double(xPosition, yPosition);
		for (Actor actor : actors) {
			if (actor.getPosition().equals(desirablePosition) && actor instanceof Plant) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds zombie actors onto the game board.
	 */
	private void addMoreZombies() {
		if (zombieCounter < ZombiePerRound * levelTracker && bufferTimer > 40) {
			Random randGenerator = new Random();
			int row = randGenerator.nextInt(nRows);
			int threshold = randGenerator.nextInt(101);
			if (threshold > 97) {
				ClubZombie zombie = new ClubZombie(
						new Point2D.Double(xGaps + (nCol - 1) * gridSize, yGaps + row * gridSize));
				for (int index = 0; index < clubZombieImages.size(); index++) {
					zombie.add(clubZombieImages.get(index));
				}
				actors.add(zombie);
				zombieCounter++;
				if (levelTracker > 1 && threshold > 99 && shamanCounter < ShamanPerRound * levelTracker) {
					ShamenZombie shamen = new ShamenZombie(
							new Point2D.Double(xGaps + (nCol - 1) * gridSize, yGaps + row * gridSize));
					for (int index = 0; index < shamanImages.size(); index++) {
						shamen.add(shamanImages.get(index));
					}
					actors.add(shamen);
					shamanCounter++;
				}
			}
		} else {
			if (!checkForRemainingZombies() && bufferTimer > 40) {
				zombieCounter = 0;
				shamanCounter = 0;
				levelTracker++;
				resourceCounter = ResourcePerTurn;
				resourceLabel.updateUI();
				this.updateUI();
				bufferTimer = 0;
				if (levelTracker > 7) {
					JOptionPane.showMessageDialog(this, "YOU WON!!!");
					actors.clear();
				} else {
					actors.clear();
					placeRockets();
					JOptionPane.showMessageDialog(this, "Level " + levelTracker);
				}
			}
		}

	}

	/**
	 * Checks to see is the game still has Alive Zombies on the board.
	 * 
	 * @return A boolean true is there is still zombies on the board, false
	 *         otherwise.
	 */
	private boolean checkForRemainingZombies() {
		for (Actor actor : actors) {
			if (actor instanceof Zombie) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks to see if it is the end of game by checking locations of the zombie.
	 */
	private void checkForEndOfGame() {
		for (Actor actor : actors) {
			if (actor instanceof Zombie) {
				double xPosition = actor.getPosition().getX();
				if (xPosition < 0) {
					gameOver();
					backgroundClip.stop();
					bufferTimer = 0;
					break;
				}
			}
		}

	}

	/**
	 * Stops the game when it is the end of the game.
	 */
	private void gameOver() {
		timer.stop();
		backgroundClip.stop();
		actors.clear();
		resourceCounter = 150;
		levelTracker = 1;
		bufferTimer = 0;
		JOptionPane.showMessageDialog(this, "Game Over");

	}

	/**
	 * Checks to see if resources are able to be gained within the game.
	 */
	private void newResources() {
		for (Actor actor : actors) {
			if (actor instanceof Producer) {
				resourceCounter += ((Producer) actor).supplyResources();
				resourceLabel.setText(resourceCounter + "Total");
				resourceLabel.updateUI();
				((Producer) actor).changeProducerTimer();
			}
		}
	}

	/**
	 * 
	 * This is triggered by the timer. It is the game loop of this test.
	 * 
	 * @param e
	 */
	public void updateGameFrame() {

		updateActors();
		actorAttack();
		deletingDead();
		checkForCollisions();
		checkForEndOfGame();
		moveActors();
		addMoreZombies();
		newResources();
		frameNumber++;
		checkMusic();
		repaint();

	}

	/**
	 * Checks to make sure that the music is still playing in the game.
	 */
	private void checkMusic() {
		if (!backgroundClip.isRunning()) {
			setUpMusic();
			backgroundClip.start();
			status = "play";
		}

	}

	/**
	 * Make the game and run it
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
