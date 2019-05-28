import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Settings extends JFrame implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	BufferedImage image = null;
	int x = 0;
	int y = 0;
	
	public Settings() {
		this.setTitle("Let's Rush Out!");
		this.setLocation((Constant.width_Screen - Constant.Width)/2, (Constant.height_Screen - Constant.Height)/2);
		this.setSize(Constant.Width_Q, Constant.Height_Q);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		try {
			image = ImageIO.read(new File("./Final Image/settings.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
		this.addMouseListener(this);
		this.repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(image, 13, 35, this);
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent event) {
		x = event.getX();
		y = event.getY();
		if (x > 540 && x < 720 && y > 420 && y < 495) {
			new Start_menu();
			this.setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
