package dz1;

import java.awt.Color;
import java.awt.Graphics;




public abstract class Objekat {
	protected int X;
	protected int Y;
	protected Color col;
	
	public Objekat(int x,int y, Color c) {
		X=x;
		Y=y;
		col=c;
	}
	
	public abstract boolean proveri(int x, int y);
	public abstract int getX();
		
	abstract public void setX(int pomeraj);

	abstract public int getY();

	abstract public void setY(int pomeraj); 
	
	abstract public void paint(Graphics g);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
