import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

public class Window extends JFrame {
  public Window() {
	  setTitle("Let's Rush Out");
	  MyPanel panel = new MyPanel();
	  Container contentPane = getContentPane();
	  contentPane.add(panel);
	  pack();
	  
  } 

public static void main(String[] args) {
	  Window e1 = new Window();
	  e1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  e1.setVisible(true);
  }
}  
