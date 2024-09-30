package dz1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Svemir extends Canvas implements Runnable {
	
	List<Nebesko_telo> list=new ArrayList<Nebesko_telo>();
	Thread thread;
	private long sleepTime = 100;
	private boolean work;
	
	public Svemir() {
		this.setBackground(Color.BLACK);
		this.thread = new Thread(this);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//if(!((e.getSource()) instanceof Kometa)) return;
				//Kometa k= (Kometa) e.getSource();
				//e.getPoint();
				Iterator<Nebesko_telo> iter = list.iterator();
				synchronized(this) {
				while(iter.hasNext()) {
					Nebesko_telo n=iter.next();
					if(!(n instanceof Kometa)) return;
					if(((Kometa)n).p !=null){
					if (((Kometa) n).p.contains(e.getPoint())) {
						iter.remove();
					}
		}
					}
				}
				
				
				//System.out.println("lalat");
				
			}
			
		});
		
	}
	
	public void dodaj(Nebesko_telo n) {
		list.add(n);
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
	
	@Override
	public void paint(Graphics g) {
		Iterator<Nebesko_telo> iter = list.iterator();
		Iterator<Nebesko_telo> iter2 = list.iterator();
		while(iter.hasNext()) {
			iter.next().paint(g);
		}
		while(iter2.hasNext()) {
			iter2.next().setY(5);
		}
		//finish();
		//synchronized (this) {
		/*for(Nebesko_telo n:list) {
			n.paint(g);
		}
		for(Nebesko_telo n:list) {
			n.setY(5);
		}*/
		//}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
		
		Graphics g = this.getGraphics();
		try {
			while(!Thread.interrupted()) {
			synchronized (this.thread) {
					while(!work){
						thread.wait();
					}
				}
			Thread.sleep(sleepTime);
			repaint();
			}
		} catch (InterruptedException e) {
		}
		/*synchronized (this) {
			thread = null;
			notify();
		}*/
	}

}
