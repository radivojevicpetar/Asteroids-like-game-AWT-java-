package dz1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Kometa extends Nebesko_telo {
	private double angle ;
	Polygon p;
	public Kometa(int x, int y, double r) {
		super(x, y, Color.GRAY, r);
		angle=new Random().nextDouble(2*Math.PI);
		
	}

	public static void main(String[] args) {
		
	}

	
	@Override
	public boolean proveri(int x, int y) {
		if(p.contains(x, y)) return true;
		else return false;
	}

	@Override
	public void paint(Graphics g) {
		
		
		
		p = new Polygon();
		for(int i=0;i<5;i++) {	
		int pointX=(int) (r*Math.cos(angle+i*2*Math.PI/5));
		int pointY=(int) (r*Math.sin(angle+i*2*Math.PI/5));
		p.addPoint(getX() + pointX,getY() + pointY);
		}
		g.drawPolygon(p);
		g.setColor(col);
		g.fillPolygon(p);
	}

}
