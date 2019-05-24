import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Start_menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Window window = new Window();
	private Score_menu score_menu = new Score_menu();

	public Start_menu() {
		JFrame jFrame = new JFrame("Let's Rush Out!");
		Container container = jFrame.getContentPane();
		JLabel label = new JLabel();
		container.setBackground(Color.black);
		URL url = Start_menu.class.getResource("image/menu_.jpg");
		Icon icon = new ImageIcon(url);
		label.setIcon(icon);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(label);

		jFrame.setSize(736, 512);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		addKeyListener(new MyKeyEvent());
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Start_menu();
		Window e1 = new Window();
		e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		e1.setLocationRelativeTo(null);
		e1.setVisible(true);
	}
}

class MyKeyEvent extends KeyAdapter {

	private Window window = new Window();
	private Start_menu menu = new Start_menu();
	private Score_menu score_menu = new Score_menu();

	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (e.getKeyCode() == KeyEvent.VK_N) {
			score_menu.setVisible(false);
			window.setVisible(true);
			menu.setVisible(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_H) {
			score_menu.setVisible(true);
			window.setVisible(false);
			menu.setVisible(false);
		}
	}
}
