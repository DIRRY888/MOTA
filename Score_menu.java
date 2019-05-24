import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Score_menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private Hero hero = new Hero();
	
	public Score_menu() {
		JFrame jFrame = new JFrame("Rank List");
		Container container = jFrame.getContentPane();
		JLabel label = new JLabel();
		container.setBackground(Color.black);
		URL url = Start_menu.class.getResource("image/list_.jpg");
		Icon icon = new ImageIcon(url);
		label.setIcon(icon);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(label);

		jFrame.setSize(736, 512);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		add(new ShapesPanel());
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < 3; i++) {
			g.drawString("Life: " + hero.gethp() + "Attack: " + hero.getattack() + 
						 "Defence: " + hero.getdefence() + "Experience: " + hero.getexperience() +
						 "Red Key: " + hero.redkey + "Yellow Key: " + hero.redkey +
						 "Yellow Key: " + hero.yellowkey, 100, 200);
		}
	}
	
	private class ShapesPanel extends JPanel {
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			Score_menu score_menu = new Score_menu();
			score_menu.draw(g2);
		}
	}

}

