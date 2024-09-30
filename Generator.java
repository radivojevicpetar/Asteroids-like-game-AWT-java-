package dz1;

import java.util.Random;

public class Generator implements Runnable {
	private Svemir s;
	private long sleepTime = 900;
	 Thread thread;
	private boolean work;
	 
	public Generator(Svemir s) {
		thread= new Thread(this);
		this.s=s;
	}

	public synchronized void finish() {
		if(thread != null) {
			thread.interrupt();
		}
		while (thread != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
	}
	public synchronized void go() {
		work = true;
		notify();
	}
	public synchronized void zaustavi() {
		if(this.thread!=null) {
			this.thread.interrupt();
		}
	}
	
	@Override
	public void run() {
		//finish();	
		
		try {
		while(!Thread.interrupted()) {
				synchronized (this.thread) {
				while(!work){
					thread.wait();
				}
			}
				Thread.sleep(sleepTime);
				Kometa k=new Kometa((int)(Math.random()*200),0,10 + new Random().nextDouble(20));
				synchronized (s) {
				s.dodaj(k);
				//s.repaint();
				}
			} 
		}
		catch (InterruptedException e) {}		
		/*synchronized (this) {
			thread = null;
			notify();
		}*/
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
