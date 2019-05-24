
public class AnimationThread extends Thread implements Runnable {
	public SoundPlayer sound = new SoundPlayer();
	private Thread threadAnime;

	public void run() {
		while (true) {
			if (MyPanel.count == 0) {

				MyPanel.count = 1;

			} else if (MyPanel.count == 1) {

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

	private void repaint() {}

}
