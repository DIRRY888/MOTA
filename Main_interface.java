package interfaces;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Main_interface extends JFrame {

	public void Window() {
		JFrame frame = new JFrame("Let's Rush Out!");
		Container container = frame.getContentPane();
		container.setBackground(Color.black);
		frame.setBounds(0, 0, 750, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
//		Draw draw = new Draw();

		JButton button1 = new JButton(); // "start game"
		button1.setIcon(new ImageIcon("Start Game"));
		button1.setBounds(500, 490, 150, 40);
		JButton button2 = new JButton("Load Game"); // "Load Game"
		button2.setBounds(500, 550, 150, 40);
		JButton button3 = new JButton("Settings"); // "Settings"
		button3.setBounds(500, 610, 150, 40);

		container.add(button1);
		container.add(button2);
		container.add(button3);
//		container.add(label);

		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MyJDialog(Main_interface.this).setVisible(true);
			}
		});
	}

	public static void main(String[] args) {
		new Main_interface().Window();
	}
}
