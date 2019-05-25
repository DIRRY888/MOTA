import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Window extends JFrame {

	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private static final long serialVersionUID = 1L;
	public Window() {
		setTitle("Let's Rush Out");
		MyPanel panel = new MyPanel();
		Container contentPane = getContentPane();
		contentPane.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation((width - Constant.Width)/2, (height - Constant.Height)/2);
		this.setVisible(true);
		pack();
	}
}
