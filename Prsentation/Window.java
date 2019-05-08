package Prsentation;
import java.awt.Container;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends JFrame {
  public Window() {
	  MyPanel panel = new MyPanel();
	  Container contentPane = getContentPane();
	  contentPane.add(panel);
	  pack();
  } 

public static void main(String[] args) {
	  Window mainWindow = new Window();
	  mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  mainWindow.setTitle(" Let's Rush Out ");
	  mainWindow.setVisible(true);
	  mainWindow.setLocationRelativeTo(null);
	  mainWindow.setResizable(false);
  }
}  
