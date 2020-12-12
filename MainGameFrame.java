package a9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainGameFrame extends JFrame implements ActionListener {

	/**
	 * Creates the title screen before the game starts
	 * 
	 * @Author Vista Marston
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel titlePanel;
	private JButton startGameButton;

	public MainGameFrame() {
		super("Sapiens vs Neandethals");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		titlePanel = new JPanel();
		startGameButton = new JButton("Start Game");

		makeTitlePanel();

		this.setContentPane(titlePanel);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Makes the title page of the game.
	 */
	private void makeTitlePanel() {
		BufferedImage titleImage = loadImage();
		ImageIcon titImageIcon = new ImageIcon(titleImage);
		JLabel title = new JLabel(titImageIcon);
		title.setPreferredSize(new Dimension(600, 450));
		titlePanel.add(title);
		startGameButton = new JButton("Start Game");
		startGameButton.setBackground(Color.GREEN.brighter());
		titlePanel.add(startGameButton);
		startGameButton.addActionListener(this);

	}

	/**
	 * Loads the image for the title page.
	 * @return a BufferedImage for the title page.
	 */
	private BufferedImage loadImage() {
		BufferedImage titleImage = null;
		try {
			titleImage = ImageIO.read(new File("src/a9/Animal-Icons/TitleImage.png"));
		} catch (IOException e) {
			System.out.println("File not found");
			System.exit(-1);
		}
		return titleImage;
	}

	/**
	 * Switches the title screen to the game screen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startGameButton) {
			GameConsole gamePanelConsole = new GameConsole();
			this.setContentPane(gamePanelConsole);
			this.pack();
		}

	}

	public static void main(String[] args) {
		MainGameFrame appFrame = new MainGameFrame();
		appFrame.setVisible(true);

	}

}
