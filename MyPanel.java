import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 720;
	private static final int HEIGHT = 480;
	// the number of row
	private static final int ROW = 15;
	// the number of column
	private static final int COL = 15;
	// the size of very grid
	private static final int CS = 32;

	private static int[][][] maps = { 
			{ 
		//
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 },
				{ 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 }, 
				{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
				{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 }, 
				{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 2, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
				{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 }, 
				{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
				{ 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 }, 
				{ 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },

			{ 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
				{ 1, 22, 20, 21, 1, 1, 1, 1, 1, 1, 1, 21, 20, 22, 1 },
				{ 1, 22, 20, 0, 1, 0, 3, 14, 0, 0, 1, 0, 20, 22, 1 },
				{ 1, 22, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 22, 1 },
				{ 1, 0, 0, 0, 11, 14, 1, 13, 1, 0, 1, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 }, 
				{ 1, 1, 11, 1, 1, 1, 1, 0, 1, 1, 1, 1, 11, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
				{ 1, 1, 1, 1, 0, 1, 1, 10, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 }, 
				{ 1, 0, 0, 9, 0, 1, 0, 0, 0, 1, 0, 9, 0, 0, 1 },
				{ 1, 7, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 11, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },

			{ //
				{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
				{ 6, 0, 0, 0, 0, 0, 0, 8, 0, 0, 12, 13, 14, 15, 6 },
				{ 6, 0, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 14, 6 },
				{ 6, 13, 6, 0, 13, 14, 13, 0, 22, 20, 21, 0, 6, 13, 6 },
				{ 6, 14, 6, 0, 6, 6, 6, 6, 6, 6, 6, 0, 6, 12, 6 },
				{ 6, 15, 6, 0, 6, 0, 0, 11, 0, 0, 6, 0, 6, 0, 6 },
				{ 6, 14, 6, 0, 6, 12, 6, 6, 6, 0, 6, 0, 6, 0, 6 },
				{ 6, 13, 6, 11, 6, 13, 6, 3, 6, 12, 6, 11, 6, 0, 6 },
				{ 6, 0, 6, 0, 6, 12, 6, 0, 6, 13, 6, 0, 6, 25, 6 },
				{ 6, 0, 6, 0, 6, 0, 0, 0, 6, 12, 6, 0, 6, 24, 6 },
				{ 6, 25, 6, 0, 6, 6, 6, 6, 6, 0, 6, 0, 6, 25, 6 },
				{ 6, 24, 6, 0, 13, 14, 13, 0, 0, 0, 6, 13, 6, 0, 6 },
				{ 6, 25, 6, 6, 6, 6, 6, 6, 6, 6, 6, 14, 6, 0, 6 }, 
				{ 6, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 13, 6, 9, 6 },
				{ 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 2, 6 }, },

			{ 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 25, 22, 0, 1, 0, 0, 13, 13, 0, 0, 1, 1, 13, 1 },
				{ 1, 12, 22, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1 },
				{ 1, 12, 22, 0, 8, 0, 12, 12, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 24, 22, 0, 1, 12, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 1, 1, 1, 1, 13, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 24, 20, 0, 1, 12, 1, 1, 0, 1, 0, 0, 0, 1, 1 },
				{ 1, 12, 20, 0, 8, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 12, 20, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 25, 20, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 11, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 13, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
				{ 1, 14, 13, 0, 8, 14, 1, 1, 0, 0, 0, 0, 14, 14, 1 },
				{ 1, 15, 14, 0, 1, 13, 1, 1, 7, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },

			{ 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 3, 3, 3, 3, 1, 14, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 14, 14, 14, 14, 1, 0, 0, 0, 8, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 10, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 13, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 1 },
				{ 1, 1, 1, 10, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 8, 0, 0, 0, 0, 1 },
				{ 1, 3, 2, 4, 3, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 }, 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },

			{ 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
				{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
				{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0, 13, 0, 0, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, 
				{ 1, 0, 0, 1, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
				{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
				{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },

			} };

	private java.awt.Image wayImage;
	private java.awt.Image wallImage;
	private java.awt.Image stairUpImage;
	private java.awt.Image stairDownImage;
	private java.awt.Image oceanImage;
	private java.awt.Image forestImage;
	private java.awt.Image starImage;
	private java.awt.Image blueDoorImage;
	private java.awt.Image redDoorImage;
	private java.awt.Image uniqueDoorImage;
	private java.awt.Image yellowDoorImage;
	private java.awt.Image monsters1Image;
	private java.awt.Image monsters2Image;
	private java.awt.Image monsters3Image;
	private java.awt.Image monsters4Image;
	private java.awt.Image monsters5Image;
	private java.awt.Image monsters6Image;
	private java.awt.Image monsters7Image;
	private java.awt.Image fairyImage;
	private java.awt.Image blueKeyImage;
	private java.awt.Image magmaImage;
	private java.awt.Image redKeyImage;
	private java.awt.Image yellowKeyImage;
	private java.awt.Image finalKeyImage;
	private java.awt.Image addExpImage;
	private java.awt.Image addLifeImage;
	private java.awt.Image featherImage;
	private java.awt.Image shieldImage;
	private java.awt.Image swardImage;

	private java.awt.Image heroImage;
	
	// images for information panel
		private java.awt.Image redkeyPanelImage;
		private java.awt.Image yellowkeyPanelImage;
		private java.awt.Image bluekeyPanelImage;
		private java.awt.Image coinsPanelImage;
		private java.awt.Image lifePanelImage;
		private java.awt.Image attackPanelImage;
		private java.awt.Image defencePanelImage;
		private java.awt.Image experiencePanelImage;
		private java.awt.Image inforPanelImage;
		private java.awt.Image titlePanelImage;
		private java.awt.Image gameOverImage;
		private Icon mapPanelImage;
		

	private int x, y;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;

	private static int choose = 1;
	public static int count;
	private Thread threadAnime;
	private int direction;

	// the level of floor
	private int floor;
	private boolean ischoose = false;
	private boolean showfly = false;
	private boolean canmove = true;
	private boolean fight = true;
	private int pack = 1;

	Hero hero = new Hero();
	ArrayList<Animal> list = new ArrayList<Animal>();
	// Animal animal1 = new Animal("black guard", 1,300,30,20,50,50);
	// Animal animal2 = new Animal("black guard", 2,400,60,50,70,80);

	public MyPanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		loadImage();
		x = 7;
		y = 14;
		floor = 0;
		direction = DOWN;
		count = 0;
		setFocusable(true);
		addKeyListener(this);
		Hero hero = new Hero();
		init();
		initButton();
		threadAnime = new Thread(new AnimationThread());
		threadAnime.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMap(g);
		drawRole(g);
		drawInformationPanel(g);
		gameOver(g);
		if (showfly == true && getMap(floor)[x][y] == 11) {
			drawFly(g);
			drawChoose(g);
		}
		if (fight == true && getMap(floor)[x][y] == 14) {
			drawFight(g, 14);
		}
		if (pack == 2) {
			drawPackage(g);
		}

	}

	/* The following method 'initButton' is for the function: 
	* check previous and next maps' information by click button in inforPanel
	* (will be completed by NiSha
	* Please DO NOT change anything inside it!!!)
	*/
	
	/*
	 * Reminder: always close the new frame before operate the HERO or open a new
	 * window ('focus' problem & redundant windows)
	 */
	private void initButton() {
		// Creat a Map Guide Button
		JButton mapGuide = new JButton(mapPanelImage); // NEED - improve image's quality
		// Set size & location & appearance
		this.setLayout(null);
		mapGuide.setBounds(500, 400, 40, 40);
		mapGuide.setBorder(null);                      //NEED - cancel borders and set dynamic display
		mapGuide.setMargin(new Insets(0, 0, 0, 0));
		mapGuide.setContentAreaFilled(false);
		this.add(mapGuide);

		// add action
		mapGuide.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				// create a new frame
				JFrame mapGuideFrame = new JFrame("Map Guide");
				// set this window
				mapGuideFrame.setSize(300, 400);
				mapGuideFrame.setVisible(true);
				mapGuideFrame.setLocationRelativeTo(null);
				mapGuideFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				JButton button2 = new JButton("µã»÷ÎÒ");
				button2.setSize(50, 25);
				button2.setBorderPainted(false);
				button2.setLocation(50, 80);
				button2.setVisible(true);
				mapGuideFrame.add(button2);
				focus();
			}
		});
	}

	/*
	 * This method helps the focus change to the main panel after every
	 * actionListener asked for focus
	 */
	public void focus() {
		this.requestFocus();
	}
	
	// information menu method
	private void drawInformationPanel(Graphics g) {
		int locationX = 550;
		int locationY = 70;
		int space = 46;
		g.drawImage(inforPanelImage, HEIGHT, 0, HEIGHT/2, HEIGHT, this);
		g.drawImage(titlePanelImage, HEIGHT+10, 12, 220, 55, this);
		g.drawImage(titlePanelImage, HEIGHT+10, 60, 220, 118, this);
		g.drawImage(titlePanelImage, HEIGHT+10, 175, 220, 55, this);
		g.drawImage(titlePanelImage, HEIGHT+10, 235, 220, 148, this);
		
		g.drawImage(yellowkeyPanelImage, locationX, locationY, CS, CS, this);
		g.drawImage(bluekeyPanelImage, locationX, locationY + 30, CS, CS, this);
		g.drawImage(redkeyPanelImage, locationX, locationY + 30*2, CS, CS, this);
		g.drawImage(lifePanelImage, locationX, locationY + 30*4, CS, CS, this);
		g.drawImage(coinsPanelImage, locationX, locationY + 30*6, CS, CS, this);
		g.drawImage(experiencePanelImage, locationX, locationY + 30*7, CS, CS, this);
		g.drawImage(attackPanelImage, locationX, locationY + 30*8, CS, CS, this);
		g.drawImage(defencePanelImage, locationX, locationY + 30*9, CS, CS, this);
		
		g.setFont(new Font("Tahoma", Font.BOLD, 24));
		Color c = new Color(90, 46, 30);
		g.setColor(c);
		g.drawString( "  MAP LEVEL  " + String.valueOf(floor), 500, 50);
		c = new Color(255, 215, 0);
		g.setColor(c);
		g.drawString( String.valueOf(hero.yellowkey), locationX + space, locationY + 25);
		g.setColor(Color.BLUE);
		g.drawString( String.valueOf(hero.bluekey), locationX + space, locationY + 30*2-2);
		g.setColor(Color.RED);
		g.drawString( String.valueOf(hero.redkey), locationX + space, locationY + 30*3 +3);
		c = new Color(255, 20, 130);
		g.setColor(c);
		g.drawString( String.valueOf(hero.Life), locationX + space, locationY + 30*5-5);
		c = new Color(253,135,0);
		g.setColor(c);
		g.drawString( String.valueOf(hero.money), locationX + space, locationY + 30*7-5);
		g.drawString( String.valueOf(hero.experience), locationX + space, locationY + 30*8-5);
		g.drawString( String.valueOf(hero.attack), locationX + space, locationY + 30*9-5);
		g.drawString( String.valueOf(hero.experience), locationX + space, locationY + 30*10-5);
		
	}
	
	private void gameOver(Graphics g) {
		if(hero.Life <= 0) {
			int c = 0;
			while(c != 15)
			g.drawImage(gameOverImage, c*CS, c*CS, CS, CS, this);
		}
	}
	
	private void drawFight(Graphics g, int num) {
		String string6 = new String("Fight");
		g.setColor(Color.WHITE);
		g.fillRect(3 * CS, 2 * CS, 5 * CS, 5 * CS);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString(string6, 4 * CS, 2 * CS);
		g.drawImage(heroImage, 3 * CS, 3 * CS, CS, CS, this);
		if (num == 14) {
			g.drawImage(monsters1Image, 7 * CS, 3 * CS, CS, CS, this);
		}

	}

	private void drawPackage(Graphics g) {
		String string6 = new String("Your Package");
		g.setColor(Color.BLACK);
		g.fillRect(3 * CS, 2 * CS, 5 * CS, 5 * CS);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString(string6, 4 * CS, 2 * CS);
		g.drawImage(yellowKeyImage, 3 * CS, 3 * CS, CS, CS, this);

	}

	private void drawFly(Graphics g) {
		canmove = false;
		String string1 = new String();
		String string2 = new String();
		String string3 = new String();
		String string4 = new String();
		String string5 = new String();
		String string6 = new String();

		g.setColor(Color.BLACK);
		g.fillRect(60, 45, 150, 200);
		g.setColor(Color.RED);

		g.drawRoundRect(60, 45, 150, 200, 10, 10);
		g.drawRoundRect(59, 44, 152, 202, 10, 10);
		g.drawRoundRect(58, 43, 154, 204, 10, 10);
		g.drawRoundRect(57, 42, 156, 206, 10, 10);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		string4 = "level 0";
		string5 = "level 1";
		string6 = "level 2";
		g.setColor(Color.GREEN);

		g.setColor(Color.WHITE);

		g.drawString(string4, 90, 165);
		g.drawString(string5, 90, 205);
		g.drawString(string6, 90, 245);
		if (choose == 4) {
			choose = 1;
		}

	}

	private void drawChoose(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(70, 110 + choose * 45, 10, 5);
	}

	private void drawRole(Graphics g) {
		g.drawImage(heroImage, x * CS, y * CS, x * CS + CS, y * CS + CS, count * CS, 0, CS + count * CS, CS, this);

	}

	private void drawMap(Graphics g) {
		int x = 0;
		int y = 0;
		while (x < COL) {
			while (y < ROW) {
				if (getMap(floor)[x][y] == 0) {
					g.drawImage(wayImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 1) {
					g.drawImage(wallImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 2) {
					g.drawImage(stairUpImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 3) {
					g.drawImage(stairDownImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 4) {
					g.drawImage(oceanImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 5) {
					g.drawImage(magmaImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 6) {
					g.drawImage(forestImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 7) {
					g.drawImage(starImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 8) {
					g.drawImage(blueDoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 9) {
					g.drawImage(redDoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 10) {
					g.drawImage(uniqueDoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 11) {
					g.drawImage(yellowDoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 12) {
					g.drawImage(monsters1Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 13) {
					g.drawImage(monsters2Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 14) {
					g.drawImage(monsters3Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 15) {
					g.drawImage(monsters4Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 16) {
					g.drawImage(monsters5Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 17) {
					g.drawImage(monsters6Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 18) {
					g.drawImage(monsters7Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 19) {
					g.drawImage(fairyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 20) {
					g.drawImage(blueKeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 21) {
					g.drawImage(redKeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 22) {
					g.drawImage(yellowKeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 23) {
					g.drawImage(finalKeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 24) {
					g.drawImage(addExpImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 25) {
					g.drawImage(addLifeImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 26) {
					g.drawImage(featherImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 27) {
					g.drawImage(shieldImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 28) {
					g.drawImage(swardImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(floor)[x][y] == 29) {
					g.drawImage(heroImage, x * CS, y * CS, CS, CS, this);
				}
				y++;
			}
			y = 0;
			x++;
		}
	}
	
	
	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("Final Image/Background/Way.jpg"));
		wayImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Wall_Y.jpg"));
		wallImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Stair_up.jpg"));
		stairUpImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Stair_down.jpg"));
		stairDownImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Ocean.png"));
		oceanImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Magma.jpg"));
		magmaImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Foerst.png"));
		forestImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Background/Black.jpg"));
		starImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Doors/Blue_D.jpg"));
		blueDoorImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Doors/Red_D.jpg"));
		redDoorImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Doors/Unique_D.jpg"));
		uniqueDoorImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Doors/Yellow_D.jpg"));
		yellowDoorImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_1.png"));
		monsters1Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_2.png"));
		monsters2Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_3.png"));
		monsters3Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_4.png"));
		monsters4Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_5.png"));
		monsters5Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_6.png"));
		monsters6Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Monsters/M_7.png"));
		monsters7Image = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/NPC/Fairy.png"));
		fairyImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Blue_K.jpg"));
		blueKeyImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Red_K.jpg"));
		redKeyImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Yellow_K.jpg"));
		yellowKeyImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Final_K.jpg"));
		finalKeyImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Exp_M.png"));
		addExpImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Life_M.png"));
		addLifeImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Feather.jpg"));
		featherImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Shield.jpg"));
		shieldImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Tools/Sward.jpg"));
		swardImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("Final Image/Main Character/Red1.png"));
		heroImage = icon.getImage();
		
		// Images for information panel
		icon = new ImageIcon(getClass().getResource("Final Image/image/bkeys.png"));
		bluekeyPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/ykeys.png"));
		yellowkeyPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/rkeys.png"));
		redkeyPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/coins.png"));
		coinsPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/inforPanel.jpg"));
		inforPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/life.png"));
		lifePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/attack.png"));
		attackPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/defence.png"));
		defencePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/experience.png"));
		experiencePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/title.png"));
		titlePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("Final Image/image/mapguide.png"));
		mapPanelImage = icon;
		icon = new ImageIcon(getClass().getResource("Final Image/image/gameover.png"));
		gameOverImage = icon.getImage();
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		switch (keyCode) {
		/*
		 * GodMode is for an easy testing through the whole game This is related to the
		 * testing implement in our report do not change it without asking please.
		 */
		case KeyEvent.VK_G:
			System.out.println("God mode");
			hero.Life = 9999;
			hero.attack = 999;
			hero.defence = 999;
			hero.money = 999;
			hero.experience = 999;
			hero.yellowkey = 999;
			hero.bluekey = 999;
			hero.redkey = 999;
			break;
		case KeyEvent.VK_LEFT:
			move(LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			move(RIGHT);
			break;
		case KeyEvent.VK_UP:
			move(UP);
			break;
		case KeyEvent.VK_DOWN:
			move(DOWN);
			break;
		case KeyEvent.VK_J:
			if (getMap(floor)[x][y] == 11) {
				if (choose == 2) {
					choose(2);
				}
				if (choose == 3) {
					choose(3);
				}

			}
			break;
		case KeyEvent.VK_3:
			openPackage(pack);
			break;

		/*
		 * case hoose==.VK_1: level = changeLevel(1);
		 * 
		 * break; case KeyEvent.VK_0: level = changeLevel(0);
		 * 
		 * break;
		 */
		}
		repaint();
		if (x == 7 && y == 0) {
			if (floor == 0) {
				floor = floor + 1;
				x = 6;
				y = 7;
			}
		}
		if (x == 13 && y == 1) {
			if (floor == 1) {
				floor = floor + 1;
				x = 8;
				y = 7;
			}
		}
		if (x == 5 && y == 7) {
			if (floor == 1) {
				floor = floor - 1;
				x = 7;
				y = 0;
			}
		}
		if (x == 14 && y == 13) {
			if (floor == 2) {
				floor = floor + 1;
				x = 2;
				y = 13;
			}
		}
		if (x == 7 && y == 7) {
			if (floor == 2) {
				floor = floor - 1;
				x = 13;
				y = 1;
			}
		}
		if (x == 13 && y == 8) {
			if (floor == 3) {
				floor = floor + 1;
				x = 6;
				y = 12;
			}
		}
		if (x == 1 && y == 13) {
			if (floor == 3) {
				floor = floor - 1;
				x = 14;
				y = 13;
			}
		}
		if (x == 8 && y == 13) {
			if (floor == 4) {
				floor = floor + 1;
				x = 7;
				y = 7;
			}
		}
		if (x == 6 && y == 13) {
			if (floor == 4) {
				floor = floor - 1;
				x = 13;
				y = 8;
			}
		}

	}

	private void move(int event) {
		switch (event) {
		case LEFT:
			if (isAllow(x - 1, y) && canmove == true) {
				x--;
				direction = LEFT;
			}
			break;
		case RIGHT:
			if (isAllow(x + 1, y) && canmove == true) {
				x++;
				direction = RIGHT;
			}
			break;
		case UP:
			if (isAllow(x, y - 1) && canmove == true) {
				y--;
				direction = UP;

			}

			break;
		case DOWN:
			if (isAllow(x, y + 1) && canmove == true) {
				y++;
				direction = DOWN;

			}
			if (showfly) {
				choose = choose + 1;
			}
			break;

		default:
			break;
		}

	}

	private void choose(int event) {
		switch (event) {
		case 2:
			ischoose = false;
			showfly = false;
			canmove = true;
			floor = 0;
			x = 7;
			y = 14;

		case 3:
			ischoose = false;
			showfly = false;
			canmove = true;
			break;
		default:
			break;
		}
	}

	private void openPackage(int e) {
		switch (e) {
		case 1:
			pack = 2;
			break;
		case 2:
			pack = 1;
			break;

		default:
			break;
		}

	}

	private boolean isAllow(int x, int y) {
		if (getMap(floor)[x][y] == 1) {
			return false;
		}
		if (getMap(floor)[x][y] == 6) {
			JOptionPane.showMessageDialog(this, "Please save our Princess, Warroir");
			getMap(floor)[x][y] = 0;
		}
		if (getMap(floor)[x][y] == 11) {
			applyFly();
		}
		if (getMap(floor)[x][y] == 2) {
			hero.keychange(2);
			hero.printstate();
			getMap(floor)[x][y] = 0;
		}
		if (getMap(floor)[x][y] == 3) {
			hero.keychange(3);
			hero.printstate();
			getMap(floor)[x][y] = 0;
		}
		if (getMap(floor)[x][y] == 4) {
			hero.keychange(4);
			hero.printstate();
			getMap(floor)[x][y] = 0;
		}
		if (getMap(floor)[x][y] == 8) {
			if (hero.yellowkey != 0) {
				hero.keychange(8);
				getMap(floor)[x][y] = 0;
			} else {
				return false;
			}
		}
		if (getMap(floor)[x][y] == 9) {
			if (hero.redkey != 0) {
				hero.keychange(9);
				getMap(floor)[x][y] = 0;
			} else {
				return false;
			}
		}
		if (getMap(floor)[x][y] == 10) {
			if (hero.bluekey != 0) {
				hero.keychange(10);
				getMap(floor)[x][y] = 0;
			} else {
				return false;
			}
		}

		if (getMap(floor)[x][y] == 14) {
			fight(14);
			getMap(floor)[x][y] = 0;
		}

		return true;
	}

	private void fight(int x) {
		JOptionPane.showMessageDialog(this, "Fight begin ");
		fight = true;
		int heroinjure = 0;
		int animalinjure = 0;
		int animalhp = list.get(0).gethp();
		if (x == 14) {
			heroinjure = list.get(0).getattack() - hero.getDefence();
			animalinjure = hero.getAttack() - list.get(0).getdefence();
			hero.Life = hero.getLife() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getMoney() + list.get(0).getmoney();
			hero.experience = hero.getExperience() + list.get(0).getexperience();
			hero.printstate();
		}

	}

	public void keyReleased(KeyEvent e) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

	static int num = maps.length;

	public static int[][] getMap(int grade) {
		int temp[][] = null;
		temp = maps[grade];
		return temp;

	}

	public int changefloor(int k) {
		floor = k;
		return floor;

	}

	public int getfloor(int floor) {
		return floor;
	}

	public void applyFly() {
		JOptionPane.showMessageDialog(this, "You can go everywhere");
		ischoose = true;
		showfly = true;

	}

	public void init() {
		// Hero hero = new Hero();
		Animal animal1 = new Animal("black guard", 1, 300, 40, 20, 50, 50);
		Animal animal2 = new Animal("black guard", 2, 400, 60, 50, 70, 80);

		// ArrayList<Animal> list = new ArrayList<Animal>();
		list.add(animal1);
		list.add(animal2);

	}

}