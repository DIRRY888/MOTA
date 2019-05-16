//
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.FontMetrics;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//
//
//public class Menu {
//	private static final long serialVersionUID = 1616386874546775416L;
//
//	private void drawString(Graphics g, String text, Rectangle rect, int size) {
//		Graphics2D g2d = (Graphics2D) g.create();
//		Font font = new Font("Arial", Font.BOLD, size);
//		g2d.setFont(font);
//		FontMetrics metrics = g2d.getFontMetrics();
//		int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
//		int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
//
//		g2d.setColor(Color.GREEN);
//		g2d.drawString(text, x, y);
//		
//	}
//
//	public void paintComponent(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, MyPanel.WIDTH, MyPanel.HEIGHT);
//		drawString(g, "Let's RUSH OUT!!!!", new Rectangle(MyPanel.WIDTH / 3, MyPanel.HEIGHT / 6,
//				MyPanel.WIDTH / 3, MyPanel.HEIGHT / 3), 24);
//		drawString(g, "To play a game press N", new Rectangle(MyPanel.WIDTH / 3, 2 * MyPanel.HEIGHT / 6,
//				MyPanel.WIDTH / 3, MyPanel.HEIGHT / 3), 18);
//		drawString(g, "To see the High scores press H", new Rectangle(MyPanel.WIDTH / 3, 3 * MyPanel.HEIGHT / 6,
//				MyPanel.WIDTH / 3, MyPanel.HEIGHT / 3), 18);
//		drawString(g, "To exit press X", new Rectangle(MyPanel.WIDTH / 3, 4 * MyPanel.HEIGHT / 6,
//				MyPanel.WIDTH / 3, MyPanel.HEIGHT / 3), 18);
//
//	}
//
//}
