
public class AnimationThread extends Thread implements Runnable {

	public void run() {
		while (true) {
			if (MyPanel.count == 0) {
				System.out.println(MyPanel.count);
				MyPanel.count = 1;

			} else if (MyPanel.count == 1) {
				System.out.println(MyPanel.count);
				MyPanel.count = 2;
			} else if (MyPanel.count == 2) {
				System.out.println(MyPanel.count);
				MyPanel.count = 3;
			} else if (MyPanel.count == 3) {
				System.out.println(MyPanel.count);
				MyPanel.count = 0;
			}

			repaint();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void repaint() {
	}
}
