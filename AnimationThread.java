
public class AnimationThread extends Thread implements Runnable {
    private  int count;
    private Thread threadAnime;
	
	public void run() {
		while(true) {
			if(count==0) {
				count =1;
			}else if(count==1) {
				count = 0;
			}
			
			
			repaint();
			try {
				Thread.sleep(300);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void repaint() {
		// TODO Auto-generated method stub
		
	}

	

	

}
