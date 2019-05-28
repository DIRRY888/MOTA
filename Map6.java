
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Map6 extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	BufferedImage image = null;
	int x = 0;
	int y = 0;

	public Map6() {
		this.setTitle("Map5");
		this.setLocation((Constant.width_Screen - Constant.Width) / 2, (Constant.height_Screen - Constant.Height) / 2);
		this.setSize(Constant.Width_Q, Constant.Height_Q);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			image = ImageIO.read(new File("./Final Image/ditu5.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
		this.addMouseListener(this);
		this.repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(image, 8, 31, this);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent event) {
		x = event.getX();
		y = event.getY();
		// next
		if (x > 623 && x < 720 && y > 416 && y < 455) {
			new Map7();
			this.setVisible(false);
		}
		// exit
		if (x > 625 && x < 718 && y > 460 && y < 500) {
			new Start_menu();
			this.setVisible(false);
		}
		// last
		if (x > 624 && x < 718 && y > 377 && y < 411) {
			new Map5();
			this.setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}

