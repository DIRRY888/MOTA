import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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

/*
 * This class create a new JPanel called buttonPanel
 * It is for the information that have to be presented in the map guide
 * after click the map guide button in information panel
 * the data of monsters and keys wail be shown in a new frame
 * ask team member NiSha if have any questions please
 * 
 * */

class buttonPanel extends JPanel {
	buttonPanel() {
		setPreferredSize(new Dimension(500, 355));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMapInform(g);
	}

	void drawMapInform(Graphics g) {
		ImageIcon icon = new ImageIcon(getClass().getResource("image/inforPanel.png"));
		Image bkImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("fightImage/1-14.png"));
		Image m1 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/2-17.png"));
		Image m2 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/3-18.png"));
		Image m3 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/4-19.png"));
		Image m4 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/5-20.png"));
		Image m5 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/6-21.png"));
		Image m6 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/7-22.png"));
		Image m7 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/rk-2.png"));
		Image rk = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/yk-3.png"));
		Image yk = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/bk-4.png"));
		Image bk = icon.getImage();

		int level = MyPanel.level;
		int nextlevel = level + 1;
		int prelevel = level - 1;

		g.drawImage(bkImage, 0, 0, 500, 355, this);
		Color c = new Color(90, 46, 30);
		g.setColor(c);

		if (level == 0 || level == 1) {
			g.setFont(new Font("Tahoma", Font.BOLD, 24));
			g.drawString("NEXT Map ", 30, 50);
			g.drawString("LEVEL " + String.valueOf(level + 1), 30, 75);

			// check how many types of next level's monster & key
			int[] type = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int i = 0; i < MyPanel.map[nextlevel].length; i++) {
				for (int j = 0; j < MyPanel.map[level][i].length; j++) {
					if (MyPanel.map[nextlevel][i][j] == 14) {
						type[0]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 17) {
						type[1]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 18) {
						type[2]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 19) {
						type[3]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 20) {
						type[4]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 21) {
						type[5]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 22) {
						type[6]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 2) {
						type[7]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 3) {
						type[8]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 4) {
						type[9]++;
					}
				}
			}

			// display monsters & keys
			if (type[0] != 0) {
				g.drawImage(m1, 30, 100, 32, 32, this);
				g.drawString(String.valueOf(type[0]), 70, 125);
			}
			if (type[1] != 0) {
				g.drawImage(m2, 30, 140, 32, 32, this);
				g.drawString(String.valueOf(type[1]), 70, 165);
			}
			if (type[2] != 0) {
				g.drawImage(m3, 30, 180, 32, 32, this);
				g.drawString(String.valueOf(type[2]), 70, 205);
			}
			if (type[3] != 0) {
				g.drawImage(m4, 30, 220, 32, 32, this);
				g.drawString(String.valueOf(type[3]), 70, 245);
			}
			if (type[4] != 0) {
				g.drawImage(m5, 30, 260, 32, 32, this);
				g.drawString(String.valueOf(type[4]), 70, 285);
			}
			if (type[5] != 0) {
				g.drawImage(m6, 30, 300, 32, 32, this);
				g.drawString(String.valueOf(type[5]), 70, 325);
			}
			if (type[6] != 0) {
				g.drawImage(m7, 30, 340, 32, 32, this);
				g.drawString(String.valueOf(type[6]), 70, 365);
			}
			if (type[7] != 0) {
				g.drawImage(rk, 130, 100, 32, 32, this);
				g.drawString(String.valueOf(type[7]), 170, 125);
			}
			if (type[8] != 0) {
				g.drawImage(yk, 130, 140, 32, 32, this);
				g.drawString(String.valueOf(type[8]), 170, 165);
			}
			if (type[9] != 0) {
				g.drawImage(bk, 130, 180, 32, 32, this);
				g.drawString(String.valueOf(type[9]), 170, 205);
			}

		} else {
			g.setFont(new Font("Tahoma", Font.BOLD, 21));
			g.drawString("PREVIOUS Map", 30, 50);
			g.drawString("LEVEL " + String.valueOf(level - 1), 30, 75);
			g.drawString("NEXT Map", 280, 50);
			g.drawString("LEVEL " + String.valueOf(level + 1), 280, 75);

			// check how many types of next level's monster & key
			int[] type = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int i = 0; i < MyPanel.map[nextlevel].length; i++) {
				for (int j = 0; j < MyPanel.map[level][i].length; j++) {
					if (MyPanel.map[nextlevel][i][j] == 14) {
						type[0]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 17) {
						type[1]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 18) {
						type[2]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 19) {
						type[3]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 20) {
						type[4]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 21) {
						type[5]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 22) {
						type[6]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 2) {
						type[7]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 3) {
						type[8]++;
					}
					if (MyPanel.map[nextlevel][i][j] == 4) {
						type[9]++;
					}
				}
			}

			// display monsters & keys
			if (type[0] != 0) {
				g.drawImage(m1, 280, 100, 32, 32, this);
				g.drawString(String.valueOf(type[0]), 320, 125);
			}
			if (type[1] != 0) {
				g.drawImage(m2, 280, 140, 32, 32, this);
				g.drawString(String.valueOf(type[1]), 320, 165);
			}
			if (type[2] != 0) {
				g.drawImage(m3, 280, 180, 32, 32, this);
				g.drawString(String.valueOf(type[2]), 320, 205);
			}
			if (type[3] != 0) {
				g.drawImage(m4, 280, 220, 32, 32, this);
				g.drawString(String.valueOf(type[3]), 320, 245);
			}
			if (type[4] != 0) {
				g.drawImage(m5, 280, 260, 32, 32, this);
				g.drawString(String.valueOf(type[4]), 320, 285);
			}
			if (type[5] != 0) {
				g.drawImage(m6, 280, 300, 32, 32, this);
				g.drawString(String.valueOf(type[5]), 320, 325);
			}
			if (type[6] != 0) {
				g.drawImage(m7, 280, 340, 32, 32, this);
				g.drawString(String.valueOf(type[6]), 320, 365);
			}
			if (type[7] != 0) {
				g.drawImage(rk, 380, 100, 32, 32, this);
				g.drawString(String.valueOf(type[7]), 420, 125);
			}
			if (type[8] != 0) {
				g.drawImage(yk, 380, 140, 32, 32, this);
				g.drawString(String.valueOf(type[8]), 420, 165);
			}
			if (type[9] != 0) {
				g.drawImage(bk, 380, 180, 32, 32, this);
				g.drawString(String.valueOf(type[9]), 420, 205);
			}

			// check how many types of previous level's monster & key
			int[] type1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			for (int i = 0; i < MyPanel.map[prelevel].length; i++) {
				for (int j = 0; j < MyPanel.map[level][i].length; j++) {
					if (MyPanel.map[prelevel][i][j] == 14) {
						type1[0]++;
					}
					if (MyPanel.map[prelevel][i][j] == 17) {
						type1[1]++;
					}
					if (MyPanel.map[prelevel][i][j] == 18) {
						type1[2]++;
					}
					if (MyPanel.map[prelevel][i][j] == 19) {
						type1[3]++;
					}
					if (MyPanel.map[prelevel][i][j] == 20) {
						type1[4]++;
					}
					if (MyPanel.map[prelevel][i][j] == 21) {
						type1[5]++;
					}
					if (MyPanel.map[prelevel][i][j] == 22) {
						type1[6]++;
					}
					if (MyPanel.map[prelevel][i][j] == 2) {
						type1[7]++;
					}
					if (MyPanel.map[prelevel][i][j] == 3) {
						type1[8]++;
					}
					if (MyPanel.map[prelevel][i][j] == 4) {
						type1[9]++;
					}
				}
			}

			// display monsters & keys
			if (type1[0] != 0) {
				g.drawImage(m1, 30, 100, 32, 32, this);
				g.drawString(String.valueOf(type[0]), 70, 125);
			}
			if (type1[1] != 0) {
				g.drawImage(m2, 30, 140, 32, 32, this);
				g.drawString(String.valueOf(type[1]), 70, 165);
			}
			if (type1[2] != 0) {
				g.drawImage(m3, 30, 180, 32, 32, this);
				g.drawString(String.valueOf(type[2]), 70, 205);
			}
			if (type1[3] != 0) {
				g.drawImage(m4, 30, 220, 32, 32, this);
				g.drawString(String.valueOf(type[3]), 70, 245);
			}
			if (type1[4] != 0) {
				g.drawImage(m5, 30, 260, 32, 32, this);
				g.drawString(String.valueOf(type[4]), 70, 285);
			}
			if (type1[5] != 0) {
				g.drawImage(m6, 30, 300, 32, 32, this);
				g.drawString(String.valueOf(type[5]), 70, 325);
			}
			if (type1[6] != 0) {
				g.drawImage(m7, 30, 340, 32, 32, this);
				g.drawString(String.valueOf(type[6]), 70, 365);
			}
			if (type1[7] != 0) {
				g.drawImage(rk, 130, 100, 32, 32, this);
				g.drawString(String.valueOf(type[7]), 170, 125);
			}
			if (type1[8] != 0) {
				g.drawImage(yk, 130, 140, 32, 32, this);
				g.drawString(String.valueOf(type[8]), 170, 165);
			}
			if (type1[9] != 0) {
				g.drawImage(bk, 130, 180, 32, 32, this);
				g.drawString(String.valueOf(type[9]), 170, 205);
			}

		}

	}
}

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

	static int map[][][] = {
			// 0
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 },
					{ 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 }, { 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
					{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 }, { 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 7, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
					{ 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 }, { 1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 1 },
					{ 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 }, { 1, 5, 5, 5, 5, 1, 5, 5, 5, 5, 1, 5, 5, 5, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },
			// 1
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
					{ 1, 3, 4, 2, 1, 1, 1, 1, 1, 1, 1, 2, 4, 3, 1 }, { 1, 3, 4, 0, 1, 0, 3, 17, 0, 0, 1, 0, 4, 3, 1 },
					{ 1, 3, 0, 0, 1, 14, 1, 1, 1, 14, 1, 0, 0, 3, 1 },
					{ 1, 17, 18, 17, 8, 17, 1, 13, 1, 17, 1, 17, 18, 17, 1 },
					{ 1, 14, 17, 14, 1, 14, 1, 0, 1, 14, 1, 14, 17, 14, 1 },
					{ 1, 0, 14, 0, 1, 0, 0, 0, 0, 0, 1, 0, 14, 0, 1 }, { 1, 1, 8, 1, 1, 1, 1, 0, 1, 1, 1, 1, 8, 1, 1 },
					{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 0, 1, 1, 10, 1, 1, 0, 1, 1, 1, 1 },
					{ 1, 0, 15, 1, 0, 1, 0, 17, 0, 1, 0, 1, 15, 14, 1 },
					{ 1, 14, 0, 9, 0, 1, 0, 0, 0, 1, 0, 9, 14, 18, 1 },
					{ 1, 7, 14, 1, 0, 1, 0, 16, 0, 1, 0, 1, 18, 11, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },
			// 2
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 10, 0, 0, 14, 17, 18, 19, 1 },
					{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 18, 1 },
					{ 1, 17, 1, 0, 17, 18, 17, 0, 3, 4, 2, 0, 1, 17, 1 },
					{ 1, 18, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 14, 1 }, { 1, 19, 1, 0, 1, 0, 0, 8, 0, 0, 1, 0, 1, 0, 1 },
					{ 1, 18, 1, 0, 1, 14, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
					{ 1, 17, 1, 8, 1, 17, 1, 13, 1, 14, 1, 8, 1, 0, 1 },
					{ 1, 0, 1, 0, 1, 14, 1, 0, 1, 17, 1, 0, 1, 15, 1 },
					{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 14, 1, 0, 1, 16, 1 },
					{ 1, 15, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 15, 1 },
					{ 1, 16, 1, 0, 17, 18, 17, 0, 0, 0, 1, 17, 1, 0, 1 },
					{ 1, 15, 1, 1, 1, 1, 1, 1, 1, 1, 1, 18, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 1, 9, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1 }, },
			// 3
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 23, 3, 14, 1, 0, 0, 17, 17, 0, 0, 1, 1, 13, 1 },
					{ 1, 14, 3, 18, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1 },
					{ 1, 14, 3, 17, 8, 0, 14, 14, 0, 1, 0, 1, 0, 1, 1 },
					{ 1, 24, 3, 18, 1, 14, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
					{ 1, 1, 1, 1, 1, 17, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
					{ 1, 24, 4, 18, 1, 14, 1, 1, 0, 1, 14, 17, 14, 1, 1 },
					{ 1, 14, 4, 17, 8, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
					{ 1, 14, 4, 18, 1, 0, 1, 1, 0, 0, 14, 17, 14, 0, 1 },
					{ 1, 23, 4, 14, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1, 0, 1, 1, 17, 0, 0, 8, 0, 0, 1 },
					{ 1, 28, 0, 0, 1, 17, 1, 1, 18, 1, 1, 1, 1, 1, 1 },
					{ 1, 29, 0, 0, 10, 18, 1, 1, 17, 0, 0, 0, 14, 14, 1 },
					{ 1, 30, 0, 0, 1, 17, 1, 1, 7, 1, 1, 1, 1, 1, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },
			// 4
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 3, 3, 3, 3, 1, 17, 18, 18, 1, 0, 15, 16, 25, 1 },
					{ 1, 17, 17, 17, 17, 1, 14, 17, 18, 8, 19, 15, 16, 0, 1 },
					{ 1, 0, 18, 18, 18, 1, 0, 14, 17, 1, 0, 15, 16, 0, 1 },
					{ 1, 0, 0, 19, 0, 1, 0, 0, 14, 1, 0, 15, 16, 0, 1 },
					{ 1, 1, 1, 10, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 17, 17, 17, 0, 0, 0, 17, 18, 17, 0, 0, 13, 1 },
					{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 17, 17, 17, 0, 0, 0, 17, 18, 17, 0, 0, 7, 1 },
					{ 1, 1, 1, 10, 1, 1, 1, 9, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 0, 19, 0, 1, 0, 0, 14, 1, 0, 15, 16, 0, 1 },
					{ 1, 0, 18, 18, 18, 1, 0, 14, 17, 1, 0, 15, 16, 0, 1 },
					{ 1, 17, 17, 17, 17, 1, 14, 17, 18, 8, 19, 15, 16, 0, 1 },
					{ 1, 3, 3, 3, 3, 1, 17, 18, 18, 1, 0, 15, 16, 26, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, },
			// 5
			{ { 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27 },
					{ 27, 0, 0, 0, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27 },
					{ 27, 25, 0, 0, 8, 19, 0, 0, 18, 18, 18, 0, 0, 0, 27 },
					{ 27, 0, 0, 0, 27, 27, 27, 27, 27, 7, 27, 27, 27, 18, 27 },
					{ 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 17, 27 },
					{ 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 18, 27 },
					{ 27, 27, 27, 27, 27, 4, 27, 15, 27, 23, 27, 0, 27, 0, 27 },
					{ 27, 13, 0, 0, 18, 0, 18, 0, 18, 0, 18, 0, 0, 0, 27 },
					{ 27, 27, 27, 27, 3, 27, 2, 27, 16, 27, 24, 27, 27, 0, 27 },
					{ 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 18, 27 },
					{ 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 17, 27 },
					{ 27, 0, 0, 0, 27, 27, 27, 27, 27, 7, 27, 27, 27, 18, 27 },
					{ 27, 26, 0, 0, 8, 19, 0, 0, 18, 18, 18, 0, 0, 0, 27 },
					{ 27, 0, 0, 0, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27 },
					{ 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27, 27 },

			},
			// 6
			{ { 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 },
					{ 31, 0, 0, 0, 0, 23, 24, 23, 24, 23, 0, 0, 0, 7, 31 },
					{ 31, 0, 31, 31, 31, 31, 31, 10, 31, 31, 31, 31, 31, 0, 31 },
					{ 31, 0, 31, 31, 0, 19, 19, 19, 19, 19, 0, 31, 31, 0, 31 },
					{ 31, 0, 31, 0, 31, 31, 20, 20, 20, 31, 31, 0, 31, 0, 31 },
					{ 31, 23, 31, 19, 31, 31, 0, 21, 0, 31, 31, 19, 31, 23, 31 },
					{ 31, 24, 31, 19, 20, 0, 31, 32, 31, 0, 20, 19, 31, 24, 31 },
					{ 31, 23, 10, 19, 20, 21, 32, 33, 32, 21, 20, 19, 10, 23, 31 },
					{ 31, 24, 31, 19, 20, 0, 31, 32, 31, 0, 20, 19, 31, 24, 31 },
					{ 31, 23, 31, 19, 31, 31, 0, 21, 0, 31, 31, 19, 31, 23, 31 },
					{ 31, 0, 31, 0, 31, 31, 20, 20, 20, 31, 31, 0, 31, 0, 31 },
					{ 31, 0, 31, 31, 0, 19, 19, 19, 19, 19, 0, 31, 31, 0, 31 },
					{ 31, 0, 0, 31, 31, 31, 31, 10, 31, 31, 31, 31, 31, 0, 31 },
					{ 31, 13, 0, 0, 0, 23, 24, 23, 24, 23, 0, 0, 0, 0, 31 },
					{ 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31 }, },
			// 7
			{ { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
					{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
					{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 0, 1, 0, 0, 21, 20, 19, 19, 18, 18, 17, 0, 0, 1 },
					{ 1, 0, 1, 0, 22, 21, 20, 19, 19, 18, 18, 17, 16, 0, 1 },
					{ 1, 34, 32, 22, 22, 21, 20, 19, 19, 18, 18, 17, 16, 13, 1 },
					{ 1, 0, 1, 0, 22, 21, 20, 19, 19, 18, 18, 17, 16, 0, 1 },
					{ 1, 0, 1, 0, 0, 21, 20, 19, 19, 18, 18, 17, 0, 0, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
					{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
					{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
					{ 1, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, } };
	private java.awt.Image floorImage;
	private java.awt.Image wallImage;
	private java.awt.Image heroImage;
	private java.awt.Image redkeyImage;
	private java.awt.Image yellowkeyImage;
	private java.awt.Image bluekeyImage;
	private java.awt.Image magmaImage;
	private java.awt.Image angelImage;
	private java.awt.Image upImage;
	private java.awt.Image yellowdoorImage;
	private java.awt.Image bluedoorImage;
	private java.awt.Image reddoorImage;
	private java.awt.Image flyImage;
	private java.awt.Image blackImage;
	private java.awt.Image downImage;

	private java.awt.Image oceanImage;
	private java.awt.Image uniqueDoorImage;
	private java.awt.Image finalKeyImage;

	private java.awt.Image swordImage;
	private java.awt.Image shieldImage;
	private java.awt.Image chutouImage;
	private java.awt.Image ykeyImage;
	private java.awt.Image rkeyImage;
	private java.awt.Image bkeyImage;
	private java.awt.Image bbottleImage;
	private java.awt.Image rbottleImage;
	private java.awt.Image bbottle2Image;
	private java.awt.Image rbottle2Image;

	private java.awt.Image M1Image;
	private java.awt.Image M2Image;
	private java.awt.Image M3Image;
	private java.awt.Image M4Image;
	private java.awt.Image M5Image;
	private java.awt.Image M6Image;
	private java.awt.Image M7Image;

	private java.awt.Image greengemImage;
	private java.awt.Image yellowgemImage;
	private java.awt.Image princess;

	private java.awt.Image forestImage;
	private java.awt.Image leftImage;
	private java.awt.Image middleImage;
	private java.awt.Image rightImage;

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
	private java.awt.Image heroDisplayImage;
	private Icon mapPanelImage;

	private int x, y;
	private static final int LEFT = 0;
	private static final int RIGHT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;

	private static int choose = 1;
	private static int choose2 = 1;
	private static int choose3 = 1;
	public static int count;
	private Thread threadAnime;
	private int direction;

	static int level; /* level of tower */
	private boolean ischoose = false;
	private boolean showfly = false;
	private boolean canmove = true;
	private boolean fight = true;
	private boolean usingpackage = false;
	private boolean shopping = false;
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
		level = 0;
		direction = DOWN;
		count = 0;
		setFocusable(true);
		addKeyListener(this);
		Hero hero = new Hero();
		init();
		initButton();
		// list.add(animal1);
		// list.add(animal2);

		threadAnime = new Thread(new AnimationThread());
		threadAnime.start();
		// print();
		sounds();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawMap(g);
		drawRole(g);
		drawInformationPanel(g);
		if (showfly == true && getMap(level)[x][y] == 11) {
			drawFly(g);
			drawChoose(g);
		}
		if (shopping == true) {

			drawShop(g);
			drawChooseshop(g, choose3);
		}
		if (fight == true && getMap(level)[x][y] == 14) {
			drawFight(g, 14);
			getMap(level)[x][y] = 0;
		}
		if (fight == true && getMap(level)[x][y] == 17) {
			drawFight(g, 17);
			getMap(level)[x][y] = 0;
		}
		if (fight == true && getMap(level)[x][y] == 18) {
			drawFight(g, 18);
			getMap(level)[x][y] = 0;
		}
		if (fight == true && getMap(level)[x][y] == 19) {
			drawFight(g, 19);
			getMap(level)[x][y] = 0;
		}
		if (fight == true && getMap(level)[x][y] == 20) {
			drawFight(g, 20);
			getMap(level)[x][y] = 0;
		}
		if (fight == true && getMap(level)[x][y] == 21) {
			drawFight(g, 21);
			getMap(level)[x][y] = 0;
		}
		if (fight == true && getMap(level)[x][y] == 22) {
			drawFight(g, 22);
			getMap(level)[x][y] = 0;
		}
		if (pack == 2 && usingpackage == true) {
			drawPackage(g);
			if (usingpackage == true) {
				drawChoosebottle(g, choose2);
			}
		}
		gameOver(g);
	}

	private void gameOver(Graphics g) {
		if (hero.hp <= 0) {
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					g.drawImage(gameOverImage, i * CS, j * CS, CS, CS, this);
				}
			}
			g.drawImage(inforPanelImage, HEIGHT, 0, HEIGHT / 2, HEIGHT, this);
			g.setFont(new Font("Tahoma", Font.BOLD, 50));
			Color c = new Color(90, 46, 30);
			g.setColor(c);
			g.drawString(" YOU", 525, 170);
			g.drawString(" ARE", 525, 240);
			g.drawString("DIED", 530, 310);
			g.drawImage(titlePanelImage, 0, 5 * CS, 15 * CS, 5 * CS, this);
			g.drawString("     LOSE", 90, 230);
			g.drawString("GAME OVER", 90, 280);
		}
		
		if(getMap(level)[x][y] == 34 && hero.hp > 0) {
			ImageIcon icon = new ImageIcon(getClass().getResource("image/g1.png"));
			Image grass1 = icon.getImage();
			icon = new ImageIcon(getClass().getResource("image/g2.png"));
			Image grass2 = icon.getImage();
			icon = new ImageIcon(getClass().getResource("image/g3.png"));
			Image grass3 = icon.getImage();
			icon = new ImageIcon(getClass().getResource("image/b4.png"));
			Image title = icon.getImage();
			
			int[][] win = {
					{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3},
					{3,2,3,2,3,2,3,2,3,2,3,2,3,2,3},
					{3,3,2,2,3,2,2,3,2,2,3,2,2,3,3},
					{3,2,1,2,3,2,1,2,3,2,1,2,3,2,3},
					{3,2,2,1,2,2,1,2,2,1,2,2,1,2,3},
					{3,3,2,2,1,2,2,1,2,2,1,2,2,1,3},
					{3,2,1,2,2,1,2,2,1,2,2,1,2,2,3},
					{3,2,2,1,2,1,2,1,2,1,2,1,2,2,3},
					{3,2,1,2,2,1,2,2,1,2,2,1,2,2,3},
					{3,3,2,2,1,2,2,1,2,2,1,2,2,1,3},
					{3,2,2,1,2,2,1,2,2,1,2,2,1,2,3},
					{3,2,1,2,3,2,1,2,3,2,1,2,3,2,3},
					{3,3,2,2,3,2,2,3,2,2,3,2,2,3,3},
					{3,2,3,2,3,2,3,2,3,2,3,2,3,2,3},
					{3,3,3,3,3,3,3,3,3,3,3,3,3,3,3}
					};
			
			for (int i = 0; i < win.length; i++) {
				for (int j = 0; j < win[i].length; j++) {
					if(win[i][j] == 1){
						g.drawImage(grass1, i * CS, j * CS, CS, CS, this);
					}
					if(win[i][j] == 2){
						g.drawImage(grass2, i * CS, j * CS, CS, CS, this);
					}
					if(win[i][j] == 3){
						g.drawImage(grass3, i * CS, j * CS, CS, CS, this);
					}
				}
			}
			g.drawImage(inforPanelImage, HEIGHT, 0, HEIGHT / 2, HEIGHT, this);
			g.setFont(new Font("Tahoma", Font.BOLD, 50));
			Color c = new Color(90, 46, 30);
			g.setColor(c);
			g.drawString(" YOU", 525, 170);
			g.drawString(" WIN", 525, 240);
			
			g.setFont(new Font("Tahoma", Font.BOLD, 24));
			g.drawString("designed by L.S.N.", 490, 300);
			
			g.setFont(new Font("Tahoma", Font.BOLD, 30));
			g.setColor(Color.white);
			g.drawImage(title, 0, 5 * CS, 15 * CS, 5 * CS, this);
			g.drawString("CONGRATULATIONS!", 90, 230);
			g.drawString("    Let's Rush Out!", 90, 280);
			
		}
	}


	/*
	 * The following method 'initButton' is for the function: check previous and
	 * next maps' information by click button in inforPanel (will be completed by
	 * NiSha Please DO NOT change anything inside it!!!)
	 */

	/*
	 * Reminder: always close the new frame before operate the HERO or open a new
	 * window ('focus' problem & redundant windows)
	 */

	private void initButton() {
		// Create a Map Guide Button
		JButton mapGuide = new JButton(mapPanelImage);
		// Create two add blood Button
		ImageIcon rbImage = new ImageIcon(getClass().getResource("image/rboold.png"));
		ImageIcon bbImage = new ImageIcon(getClass().getResource("image/bboold.png"));

		JButton addHp1 = new JButton(rbImage);
		JButton addHp2 = new JButton(bbImage);

		// Set size & location & appearance
		this.setLayout(null);
		mapGuide.setBounds(500, 400, 40, 40);
		mapGuide.setBorder(null);
		mapGuide.setMargin(new Insets(0, 0, 0, 0));
		mapGuide.setContentAreaFilled(false);
		this.add(mapGuide);
		addHp1.setBounds(550, 400, 40, 40);
		addHp1.setBorder(null);
		addHp1.setMargin(new Insets(0, 0, 0, 0));
		addHp1.setContentAreaFilled(false);
		this.add(addHp1);
		addHp2.setBounds(600, 400, 40, 40);
		addHp2.setBorder(null);
		addHp2.setMargin(new Insets(0, 0, 0, 0));
		addHp2.setContentAreaFilled(false);
		this.add(addHp2);

		// add action
		mapGuide.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// create a new frame
				JFrame mapGuideFrame = new JFrame("Map Guide");
				// set this window
				mapGuideFrame.setSize(500, 355);
				mapGuideFrame.setVisible(true);
				mapGuideFrame.setLocation(324, 174);
				buttonPanel panel = new buttonPanel();
				Container contentPane = mapGuideFrame.getContentPane();
				contentPane.add(panel);

				focus();
			}
		});

		// add action
		addHp1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// add blood
//				hero.hp = hero.hp + 300;
				usebottle(1);
				focus();
			}
		});
		
		// add action
		addHp1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				// add blood
//				hero.hp += 500;
				usebottle(2);
				focus();
			}
		});
		
		
		/*private void usebottle(int i) {
		if (i == 1) {
			if (hero.redbottle == 0) {
				System.out.println("no redbotttle");
				hero.printstate();
			} else {
				hero.hp = hero.hp + 300;
				hero.redbottle = hero.redbottle - 1;
				hero.printstate();
			}
		}
		if (i == 2) {
			if (hero.bluebottle == 0) {
				System.out.println("no bluebotttle");
				hero.printstate();
			} else {
				hero.hp = hero.hp + 500;
				hero.bluebottle = hero.bluebottle - 1;
				hero.printstate();
			}
		}

	}*/
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
		g.drawImage(inforPanelImage, HEIGHT, 0, HEIGHT / 2, HEIGHT, this);
		g.drawImage(titlePanelImage, HEIGHT + 10, 12, 220, 55, this);
		g.drawImage(titlePanelImage, HEIGHT + 10, 60, 220, 118, this);
		g.drawImage(titlePanelImage, HEIGHT + 10, 175, 220, 55, this);
		g.drawImage(titlePanelImage, HEIGHT + 10, 235, 220, 148, this);

		g.drawImage(yellowkeyPanelImage, locationX, locationY, CS, CS, this);
		g.drawImage(bluekeyPanelImage, locationX, locationY + 30, CS, CS, this);
		g.drawImage(redkeyPanelImage, locationX, locationY + 30 * 2, CS, CS, this);
		g.drawImage(lifePanelImage, locationX, locationY + 30 * 4, CS, CS, this);
		g.drawImage(coinsPanelImage, locationX, locationY + 30 * 6, CS, CS, this);
		g.drawImage(experiencePanelImage, locationX, locationY + 30 * 7, CS, CS, this);
		g.drawImage(attackPanelImage, locationX, locationY + 30 * 8, CS, CS, this);
		g.drawImage(defencePanelImage, locationX, locationY + 30 * 9, CS, CS, this);

		g.setFont(new Font("Tahoma", Font.BOLD, 24));
		Color c = new Color(90, 46, 30);
		g.setColor(c);
		g.drawString("  MAP LEVEL  " + String.valueOf(level + 1), 500, 50);
		c = new Color(255, 215, 0);
		g.setColor(c);
		g.drawString(String.valueOf(hero.yellowkey), locationX + space, locationY + 25);
		g.setColor(Color.BLUE);
		g.drawString(String.valueOf(hero.bluekey), locationX + space, locationY + 30 * 2 - 2);
		g.setColor(Color.RED);
		g.drawString(String.valueOf(hero.redkey), locationX + space, locationY + 30 * 3 + 3);
		c = new Color(255, 20, 130);
		g.setColor(c);
		g.drawString(String.valueOf(hero.hp), locationX + space, locationY + 30 * 5 - 5);
		c = new Color(253, 135, 0);
		g.setColor(c);
		g.drawString(String.valueOf(hero.money), locationX + space, locationY + 30 * 7 - 5);
		g.drawString(String.valueOf(hero.experience), locationX + space, locationY + 30 * 8 - 5);
		g.drawString(String.valueOf(hero.attack), locationX + space, locationY + 30 * 9 - 5);
		g.drawString(String.valueOf(hero.defence), locationX + space, locationY + 30 * 10 - 5);

	}

	private void drawChooseshop(Graphics g, int choose3) {
		g.setColor(Color.WHITE);
		g.fillRect(70, choose3 * 40 + 58, 10, 5);

	}

	private void drawShop(Graphics g) {
		canmove = false;
		String string4 = new String("");
		String string5 = new String("");
		String string6 = new String("");

		g.setColor(Color.BLACK);
		g.fillRect(60, 45, 250, 200);
		g.setColor(Color.RED);

		g.drawRoundRect(60, 45, 250, 200, 10, 10);
		g.drawRoundRect(59, 44, 252, 202, 10, 10);
		g.drawRoundRect(58, 43, 254, 204, 10, 10);
		g.drawRoundRect(57, 42, 256, 206, 10, 10);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		string4 = "Using 100 upgrade level";
		string5 = "Using 80 increase attack";
		string6 = "Using 80 increase defence";
		g.setColor(Color.GREEN);

		g.setColor(Color.WHITE);

		g.drawString(string4, 90, 105);
		g.drawString(string5, 90, 145);
		g.drawString(string6, 90, 185);
		if (choose3 == 4) {
			choose3 = 1;
		}

	}

	private void drawChoosebottle(Graphics g, int chooses2) {
		if (choose2 == 1) {
			g.setColor(Color.RED);
			g.fillRect(5 * CS + 20 + 30, 2 * CS - 30 + choose2 * 45, 10, 5);
		}
		if (choose2 == 2) {
			g.setColor(Color.RED);
			g.fillRect(5 * CS + 20 + 30, 2 * CS - 45 + choose2 * 45, 10, 5);
		}

	}

	private void drawFight(Graphics g, int num) {

		ImageIcon icon = new ImageIcon(getClass().getResource("fightImage/1-14.png"));
		Image m1 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/2-17.png"));
		Image m2 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/3-18.png"));
		Image m3 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/4-19.png"));
		Image m4 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/5-20.png"));
		Image m5 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/6-21.png"));
		Image m6 = icon.getImage();
		icon = new ImageIcon(getClass().getResource("fightImage/7-22.png"));
		Image m7 = icon.getImage();

		g.drawImage(titlePanelImage, 0, 5 * CS, 15 * CS, 5 * CS, this);
		g.drawImage(heroDisplayImage, 2 * CS, 7 * CS - 15, 48, 48, this);
		g.setFont(new Font("Tahoma", Font.BOLD, 40));
		Color c = new Color(90, 46, 30);
		g.setColor(c);
		g.drawString("VS", 6 * CS + 15, 8 * CS - 3);
		if (num == 14) {
			g.drawImage(m1, 11 * CS, 7 * CS - 15, 48, 48, this);
		}
		if (num == 17) {
			g.drawImage(m2, 11 * CS, 7 * CS - 15, 48, 48, this);
		}
		if (num == 18) {
			g.drawImage(m3, 11 * CS, 7 * CS - 15, 48, 48, this);
		}
		if (num == 19) {
			g.drawImage(m4, 11 * CS, 7 * CS - 15, 48, 48, this);
		}
		if (num == 20) {
			g.drawImage(m5, 11 * CS, 7 * CS - 15, 48, 48, this);
		}
		if (num == 21) {
			g.drawImage(m6, 11 * CS, 7 * CS - 15, 48, 48, this);
		}
		if (num == 22) {
			g.drawImage(m7, 11 * CS, 7 * CS - 15, 48, 48, this);
		}

	}

	private void drawPackage(Graphics g) {

		String string6 = new String("Your Package");
		g.setColor(Color.BLUE);

		g.drawRoundRect(3 * CS, 2 * CS, 5 * CS, 5 * CS, 10, 10);
		g.drawRoundRect(3 * CS - 2, 2 * CS - 2, 5 * CS + 2, 5 * CS + 2, 15, 15);
		g.drawRoundRect(3 * CS - 3, 2 * CS - 3, 5 * CS + 4, 5 * CS + 4, 15, 15);
		g.drawRoundRect(3 * CS - 4, 2 * CS - 4, 5 * CS + 6, 5 * CS + 6, 15, 15);
		g.setColor(Color.WHITE);
		g.fillRect(3 * CS, 2 * CS, 5 * CS, 5 * CS);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		g.drawString(string6, 4 * CS, 2 * CS);
		g.drawImage(ykeyImage, 3 * CS, 2 * CS, CS, CS, this);
		g.drawImage(bkeyImage, 3 * CS, 3 * CS, CS, CS, this);
		g.drawImage(rkeyImage, 3 * CS, 4 * CS, CS, CS, this);
		g.drawImage(bbottle2Image, 4 * CS + 20, 2 * CS, CS, CS, this);
		g.drawImage(rbottle2Image, 4 * CS + 20, 3 * CS, CS, CS, this);

		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String h = " " + hero.yellowkey;
		g.drawString(h, 4 * CS, 3 * CS - 10);

		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String o = " " + hero.bluekey;
		g.drawString(o, 4 * CS, 4 * CS - 10);

		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String p = " " + hero.redkey;
		g.drawString(p, 4 * CS, 5 * CS - 10);

		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String h1 = " " + hero.redbottle;
		g.drawString(h1, 5 * CS + 20, 3 * CS - 10);

		g.setFont(new Font("ITALIC ", Font.BOLD, 15));
		g.setColor(Color.BLACK);
		String h2 = " " + hero.bluebottle;
		g.drawString(h2, 5 * CS + 20, 4 * CS - 10);

	}

	private void drawFly(Graphics g) {
		canmove = false;
		String string1 = new String("");
		String string2 = new String("");
		String string3 = new String("");
		String string4 = new String("");
		String string5 = new String("");
		String string6 = new String("");
		String string7 = new String("");
		String string8 = new String("");
		String string9 = new String("");

		Color c = new Color(90, 46, 30);
		g.setColor(c);
		g.fillRect(60, 45, 150, 240);
		g.setColor(Color.GRAY);

		g.drawRoundRect(60, 45, 150, 240, 10, 10);
		g.drawRoundRect(59, 44, 152, 242, 10, 10);
		g.drawRoundRect(58, 43, 154, 244, 10, 10);
		g.drawRoundRect(57, 42, 156, 246, 10, 10);
		g.drawRoundRect(56, 41, 158, 248, 10, 10);
		g.setFont(new Font("TimesRoman", Font.BOLD, 15));
		string1 = " exit";
		string2 = "level 1";
		string3 = "level 2";
		string4 = "level 3";
		string5 = "level 4";
        string6 = "level 8";
		g.setColor(Color.GREEN);

		g.setColor(Color.WHITE);

		g.drawString(string1, 90, 65);
		g.drawString(string2, 90, 105);
		g.drawString(string3, 90, 145);
		g.drawString(string4, 90, 185);
		g.drawString(string5, 90, 225);
		g.drawString(string6, 90, 265);
		if (choose == 7) {
			choose = 1;
		}

	}

	private void drawChoose(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(70, choose * 40 + 15, 10, 5);
	}

	private void drawRole(Graphics g) {
		g.drawImage(heroImage, x * CS, y * CS, x * CS + CS, y * CS + CS, count * CS, 0, CS + count * CS, CS, this);

	}

	private void drawMap(Graphics g) {
		int x = 0;
		int y = 0;
		while (x < COL) {

			while (y < ROW) {
				if (getMap(level)[x][y] == 0) {
					g.drawImage(floorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 1) {
					g.drawImage(wallImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 2) {
					g.drawImage(redkeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 3) {
					g.drawImage(yellowkeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 4) {
					g.drawImage(bluekeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 5) {
					g.drawImage(magmaImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 6) {
					g.drawImage(angelImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 7) {
					g.drawImage(upImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 8) {
					g.drawImage(yellowdoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 9) {
					g.drawImage(reddoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 10) {
					g.drawImage(bluedoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 11) {
					g.drawImage(flyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 12) {
					g.drawImage(blackImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 13) {
					g.drawImage(downImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 14) {
					g.drawImage(M1Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 15) {
					g.drawImage(rbottleImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 16) {
					g.drawImage(bbottleImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 17) {
					g.drawImage(M2Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 18) {
					g.drawImage(M3Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 19) {
					g.drawImage(M4Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 20) {
					g.drawImage(M5Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 21) {
					g.drawImage(M6Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 22) {
					g.drawImage(M7Image, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 23) {
					g.drawImage(greengemImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 24) {
					g.drawImage(yellowgemImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 25) {
					g.drawImage(swordImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 26) {
					g.drawImage(shieldImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 27) {
					g.drawImage(forestImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 28) {
					g.drawImage(leftImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 29) {
					g.drawImage(middleImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 30) {
					g.drawImage(rightImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 31) {
					g.drawImage(oceanImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 32) {
					g.drawImage(uniqueDoorImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 33) {
					g.drawImage(finalKeyImage, x * CS, y * CS, CS, CS, this);
				}
				if (getMap(level)[x][y] == 34) {
					g.drawImage(princess, x * CS, y * CS, CS, CS, this);
				}
				y++;
			}
			y = 0;
			x++;
		}
	}

	private void loadImage() {
		ImageIcon icon = new ImageIcon(getClass().getResource("image/floor.jpg"));
		floorImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/wall.jpg"));
		wallImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/hero1.jpg"));
		heroImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/bluekey.jpg"));
		bluekeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/yellowkey.jpg"));
		yellowkeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/redkey.jpg"));
		redkeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/magma.jpg"));
		magmaImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/angel.jpg"));
		angelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/up.jpg"));
		upImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/yellowdoor.jpg"));
		yellowdoorImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/reddoor.jpg"));
		reddoorImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/bluedoor.jpg"));
		bluedoorImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/fly.jpg"));
		flyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/black.jpg"));
		blackImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/down.jpg"));
		downImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/p.jpg"));
		swordImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/s.jpg"));
		shieldImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/q.jpg"));
		chutouImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/101-01.png"));
		ykeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/101-02.png"));
		bkeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/101-03.png"));
		rkeyImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/bt.jpg"));
		bbottleImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/rt.jpg"));
		rbottleImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/103-10.png"));
		bbottle2Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/103-11.png"));
		rbottle2Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_1.png"));
		M1Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_2.png"));
		M2Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_3.png"));
		M3Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_4.png"));
		M4Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_5.png"));
		M5Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_6.png"));
		M6Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/M_7.png"));
		M7Image = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/103-03.png"));
		greengemImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/103-04.png"));
		yellowgemImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/Foerst.png"));
		forestImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/left.jpg"));
		leftImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/midle.jpg"));
		middleImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/right.jpg"));
		rightImage = icon.getImage();

		// Images for information panel
		icon = new ImageIcon(getClass().getResource("image/bkeys.png"));
		bluekeyPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/ykeys.png"));
		yellowkeyPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/rkeys.png"));
		redkeyPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/coins.png"));
		coinsPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/inforPanel.jpg"));
		inforPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/life.png"));
		lifePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("/image/attack.png"));
		attackPanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/defence.png"));
		defencePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/experience.png"));
		experiencePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/title.png"));
		titlePanelImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/mapguide.png"));
		mapPanelImage = icon;
		icon = new ImageIcon(getClass().getResource("image/gameover.png"));
		gameOverImage = icon.getImage();
		icon = new ImageIcon(getClass().getResource("image/heroDisplay.png"));
		heroDisplayImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("image/Ocean.png"));
		oceanImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("image/uniquedoor.jpg"));
		uniqueDoorImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("image/Final_K.jpg"));
		finalKeyImage = icon.getImage();

		icon = new ImageIcon(getClass().getResource("image/Red1.png"));
		princess = icon.getImage();
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		SoundPlayer sound = new SoundPlayer();

		sound.loadSound("mota/moving.wav");
		sound.playSound();

		switch (keyCode) {

		/*
		 * GodMode is for an easy testing through the whole game This is related to the
		 * testing implement in our report do not change it without asking please.
		 */
		case KeyEvent.VK_G:
			System.out.println("God mode");
			hero.hp = 9999;
			hero.attack = 999;
			hero.defence = 999;
			hero.money = 999;
			hero.experience = 999;
			hero.yellowkey = 999;
			hero.bluekey = 999;
			hero.redkey = 999;
			break;

		/*
		 * LoserMode is for testing game over condition
		 */
		case KeyEvent.VK_L:
			System.out.println("Loser mode");
			hero.hp = 10;
			hero.attack = 0;
			hero.defence = 0;
			hero.money = 0;
			hero.experience = 0;
			hero.yellowkey = 0;
			hero.bluekey = 0;
			hero.redkey = 0;
			break;

		case KeyEvent.VK_LEFT:
			sound.playSound();
			move(LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			sound.playSound();
			move(RIGHT);
			break;
		case KeyEvent.VK_UP:
			sound.playSound();
			move(UP);
			break;
		case KeyEvent.VK_DOWN:
			sound.playSound();
			move(DOWN);
			break;
		case KeyEvent.VK_J:

			if (getMap(level)[x][y] == 11) {
				SoundPlayer sound1 = new SoundPlayer();

				sound1.loadSound("mota/choosing.wav");

				if (choose == 1) {
					sound1.playSound();
					choose(1);
				}
				if (choose == 2) {
					sound1.playSound();
					choose(2);
				}
				if (choose == 3) {
					sound1.playSound();
					choose(3);
				}
				if (choose == 4) {
					sound1.playSound();
					choose(4);
				}
				if (choose == 5) {
					sound1.playSound();
					choose(5);
				}
				if (choose == 6) {
					sound1.playSound();
					choose(6);
				}
				
				

			}
			if (pack == 2 && usingpackage == true) {
				SoundPlayer sound1 = new SoundPlayer();

				sound1.loadSound("mota/choosing.wav");
				if (choose2 == 1) {
					sound1.playSound();
					usebottle(1);
				}
				if (choose2 == 2) {
					sound1.playSound();
					usebottle(2);
				}

			}
			if (shopping) {
				SoundPlayer sound1 = new SoundPlayer();

				sound1.loadSound("mota/choosing.wav");
				if (choose3 == 1) {
					sound1.playSound();
					choose3(1);
				}
				if (choose3 == 2) {
					sound1.playSound();
					choose3(2);
				}
				if (choose3 == 3) {
					sound1.playSound();
					choose3(3);
				}
			}
			break;
		case KeyEvent.VK_P:

			openPackage(pack);
			break;

		}
		repaint();
		if (x == 7 && y == 0) {
			if (level == 0) {
				level = level + 1;
				x = 6;
				y = 7;
			}
		}
		if (x == 13 && y == 1) {
			if (level == 1) {
				level = level + 1;
				x = 8;
				y = 7;
			}
		}
		if (x == 5 && y == 7) {
			if (level == 1) {
				level = level - 1;
				x = 7;
				y = 0;
			}
		}
		if (x == 14 && y == 13) {
			if (level == 2) {
				level = level + 1;
				x = 2;
				y = 13;
			}
		}
		if (x == 7 && y == 7) {
			if (level == 2) {
				level = level - 1;
				x = 13;
				y = 1;
			}
		}
		if (x == 13 && y == 8) {
			if (level == 3) {
				level = level + 1;
				x = 6;
				y = 12;
			}
		}
		if (x == 1 && y == 13) {
			if (level == 3) {
				level = level - 1;
				x = 14;
				y = 13;
			}
		}
		if (x == 8 && y == 13) {
			if (level == 4) {
				level = level + 1;
				x = 7;
				y = 2;
			}
		}
		if (x == 6 && y == 13) {
			if (level == 4) {
				level = level - 1;
				x = 13;
				y = 8;
			}
		}
		// level 5 -> level 6
		if ((x == 3 && y == 9) || (x == 11 && y == 9)) {
			if (level == 5) {
				level = level + 1;
				x = 12;
				y = 1;
			}
		}
		// level 5 -> level 4
		if (x == 7 && y == 1) {
			if (level == 5) {
				level = level - 1;
				x = 8;
				y = 12;
			}
		}
		// level 6 -> level 7
		if (x == 1 && y == 13) {
			if (level == 6) {
				level = level + 1;
				x = 8;
				y = 13;
			}
		}
		// level 6 -> level 5
		if (x == 13 && y == 1) {
			if (level == 6) {
				level = level - 1;
				x = 8;
				y = 13;
			}
		}
		if (x == 7 && y == 13) {
			if (level == 7) {
				level = level - 1;
				x = 1;
				y = 13;
			}
		}
	}

	private void choose3(int i) {
		switch (i) {
		case 1:
			if (hero.money >= 100) {
				ischoose = false;
				shopping = false;
				canmove = true;
				hero.upgrade();
			} else {
				System.out.println("No money!!!");
			}
			break;
		case 2:
			if (hero.money >= 100) {
				ischoose = false;
				shopping = false;
				canmove = true;
				hero.attack = (int) (hero.attack * 2.1);
			} else {
				System.out.println("No money!!!");
			}
			break;
		case 3:
			if (hero.money >= 80) {
				ischoose = false;
				shopping = false;
				canmove = true;
				hero.defence = (int) (hero.defence * 2);
			} else {
				System.out.println("No money!!!");
			}
			break;

		default:
			break;
		}

	}

	private void usebottle(int i) {
		if (i == 1) {
			if (hero.redbottle == 0) {
				System.out.println("no redbotttle");
				hero.printstate();
			} else {
				hero.hp = hero.hp + 300;
				hero.redbottle = hero.redbottle - 1;
				hero.printstate();
			}
		}
		if (i == 2) {
			if (hero.bluebottle == 0) {
				System.out.println("no bluebotttle");
				hero.printstate();
			} else {
				hero.hp = hero.hp + 500;
				hero.bluebottle = hero.bluebottle - 1;
				hero.printstate();
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
			if (usingpackage) {
				choose2 = choose2 + 1;
				if (choose2 == 3) {
					choose2 = 1;
				}
			}
			if (shopping) {
				choose3 = choose3 + 1;
			}
			break;

		default:
			break;
		}

	}

	private void choose(int event) {
		switch (event) {
		case 1: {
			ischoose = false;
			showfly = false;
			canmove = true;
			level = 1;
			x = 13;
			y = 13;
		}
			break;
		case 2: {
			ischoose = false;
			showfly = false;
			canmove = true;
			level = 0;
			x = 7;
			y = 14;
		}
			break;
		case 3: {
			ischoose = false;
			showfly = false;
			canmove = true;
			level = 1;
			x = 6;
			y = 7;
		}
			break;
		case 4: {
			ischoose = false;
			showfly = false;
			canmove = true;
			level = 2;
			x = 8;
			y = 7;
		}
			break;
		case 5: {
			ischoose = false;
			showfly = false;
			canmove = true;
			level = 3;
			x = 2;
			y = 13;
		}
			break;
		case 6: {
			ischoose = false;
			showfly = false;
			canmove = true;
			level = 7;
			x = 8;
			y = 13;
		}
			break;
		default:
			break;
		}
	}

	private void openPackage(int e) {
		switch (e) {
		case 1:
			pack = 2;
			usingpackage = true;
			canmove = false;
			break;
		case 2:
			pack = 1;
			usingpackage = false;
			canmove = true;
			break;

		default:
			break;
		}

	}

	private boolean isAllow(int x, int y) {
		SoundPlayer sound = new SoundPlayer();

		sound.loadSound("mota/choosing.wav");

		if (getMap(level)[x][y] == 1 || getMap(level)[x][y] == 27||getMap(level)[x][y] == 31) {
			return false;
		}
		if (getMap(level)[x][y] == 6) {
			JOptionPane.showMessageDialog(this,
					"OoPs!  >_<  It's NOT NICE to see you here  >_<  " + '\n' + "You are stuck on this deserted island."
							+ '\n' + "Fortunately, you could find Miss.S and ask her to guide you out of here!" + '\n'
							+ "However, this is an dangerous island, lots of monsters will attack you." + '\n'
							+ "Go! Begin your adventure! GOOD LUCK and BE CAREFUL" + '\n'
							+ "____________________________________________________________________________" + '\n'
							+ "Reminder: " + '\n'
							+ "CLICK MAP BUTTON: to konw monsters and props that are waiting for you" + '\n'
							+ "PRESS 'J': confirm choice" + '\n' + "PRESS 'P': open your package" + '\n'
							+ "PRESS '3': close windows");
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 11) {
			applyFly();
		}
		if (getMap(level)[x][y] == 2) {
			hero.keychange(2);
			hero.printstate();
			sound.playSound();
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 3) {
			hero.keychange(3);
			hero.printstate();
			sound.playSound();
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 4) {
			hero.keychange(4);
			hero.printstate();
			sound.playSound();
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 8) {
			if (hero.yellowkey != 0) {
				hero.keychange(8);
				getMap(level)[x][y] = 0;
			} else {
				return false;
			}
		}
		if (getMap(level)[x][y] == 9) {
			if (hero.redkey != 0) {
				hero.keychange(9);
				getMap(level)[x][y] = 0;
			} else {
				return false;
			}
		}
		if (getMap(level)[x][y] == 10) {
			if (hero.bluekey != 0) {
				hero.keychange(10);
				getMap(level)[x][y] = 0;
			} else {
				return false;
			}
		}

		if (getMap(level)[x][y] == 14) {
			fight(14);

		}
		if (getMap(level)[x][y] == 17) {
			fight(17);

		}
		if (getMap(level)[x][y] == 18) {
			fight(18);

		}
		if (getMap(level)[x][y] == 19) {
			fight(19);

		}
		if (getMap(level)[x][y] == 20) {
			fight(20);

		}
		if (getMap(level)[x][y] == 21) {
			fight(21);

		}
		if (getMap(level)[x][y] == 22) {
			fight(22);

		}
		if (getMap(level)[x][y] == 15) {
			hero.changebottle(15);
			sound.playSound();
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 16) {
			hero.changebottle(16);
			sound.playSound();
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 29) {
			shop();

		}
		if (getMap(level)[x][y] == 32) {
			if (hero.bluekey != 0&&hero.redkey!=0 &&hero.yellowkey!=0 ) {
				hero.keychange(10);
				hero.keychange(9);
				hero.keychange(8);
				getMap(level)[x][y] = 0;
			} else {
				return false;
			}
		}
		// for sword and shield in level 5
		if (getMap(level)[x][y] == 25) {
			hero.attack += 50;
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 26) {
			hero.defence += 50;
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 23) {
			hero.attack += 20;
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 24) {
			hero.defence += 20;
			getMap(level)[x][y] = 0;
		}
		if (getMap(level)[x][y] == 33) {
			
			getMap(level)[x][y] = 0;
		}
		return true;
	}

	private void shop() {
		JOptionPane.showMessageDialog(this, "You can buy something");
		ischoose = true;
		shopping = true;
		y++;
	}

	private void fight(int x) {
		JOptionPane.showMessageDialog(this, "Fight Begin");
		fight = true;
		SoundPlayer sound = new SoundPlayer();

		sound.loadSound("mota/fight.wav");
		sound.playSound();

		if (x == 14) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(0).gethp();
			heroinjure = list.get(0).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(0).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(0).getmoney();
			hero.experience = hero.getexperience() + list.get(0).getexperience();
			hero.printstate();
		}
		if (x == 17) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(1).gethp();
			heroinjure = list.get(1).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(1).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(1).getmoney();
			hero.experience = hero.getexperience() + list.get(1).getexperience();
			hero.printstate();
		}
		if (x == 18) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(2).gethp();
			heroinjure = list.get(2).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(2).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(1).getmoney();
			hero.experience = hero.getexperience() + list.get(2).getexperience();
			hero.printstate();
		}
		if (x == 19) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(3).gethp();
			heroinjure = list.get(3).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(3).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(3).getmoney();
			hero.experience = hero.getexperience() + list.get(3).getexperience();
			hero.printstate();
		}
		if (x == 20) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(4).gethp();
			heroinjure = list.get(4).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(4).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(4).getmoney();
			hero.experience = hero.getexperience() + list.get(4).getexperience();
			hero.printstate();
		}
		if (x == 21) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(5).gethp();
			heroinjure = list.get(5).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(5).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(5).getmoney();
			hero.experience = hero.getexperience() + list.get(5).getexperience();
			hero.printstate();
		}
		if (x == 22) {
			int heroinjure = 0;
			int animalinjure = 0;
			int animalhp = list.get(6).gethp();
			heroinjure = list.get(6).getattack() - hero.getdefence();
			animalinjure = hero.getattack() - list.get(6).getdefence();
			hero.hp = hero.gethp() - heroinjure;
			animalhp = animalhp - animalinjure;
			hero.money = hero.getmoney() + list.get(6).getmoney();
			hero.experience = hero.getexperience() + list.get(6).getexperience();
			hero.printstate();
		}

	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent arg0) {
	}

	static int num = map.length;

	public static int[][] getMap(int grade) {
		int temp[][] = null;
		temp = map[grade];
		return temp;
	}

	public int changeLevel(int k) {
		level = k;
		return level;

	}

	public int getLevel(int level) {
		return level;
	}

	public void applyFly() {
		JOptionPane.showMessageDialog(this, "You can go everywhere");
		ischoose = true;
		showfly = true;

	}

	public void init() {
		// Hero hero = new Hero();
		Animal animal1 = new Animal("V1", 1, 300, 40, 20, 50, 50);
		Animal animal2 = new Animal("V2", 2, 400, 60, 50, 70, 80);
		Animal animal3 = new Animal("V3", 2, 400, 80, 58, 80, 90);
		Animal animal4 = new Animal("V4", 3, 500, 100, 90, 180, 140);
		Animal animal5 = new Animal("V5", 3, 600, 160, 168, 210, 200);
		Animal animal6 = new Animal("V6", 4, 680, 200, 180, 250, 300);
		Animal animal7 = new Animal("V7", 5, 900, 230, 200, 300, 400);
		// ArrayList<Animal> list = new ArrayList<Animal>();
		list.add(animal1);
		list.add(animal2);
		list.add(animal3);
		list.add(animal4);
		list.add(animal5);
		list.add(animal6);
		list.add(animal7);

	}

	public SoundPlayer sound = new SoundPlayer();

	public void sounds() {

		sound.loadSound("mota/start.wav");
		sound.playSound();
	}

}