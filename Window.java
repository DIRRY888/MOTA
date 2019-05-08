import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

public class Window extends JFrame {
  public Window() {
	  MyPanel panel = new MyPanel();
	  Container contentPane = getContentPane();
	  contentPane.add(panel);
	  pack();
  } 

public static void main(String[] args) {
	  Window mainWindow = new Window();
	  mainWindow.setTitle("Let's Rush Out !");
	  mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  mainWindow.setVisible(true);
	  mainWindow.setLocationRelativeTo(null);
  }
}  
