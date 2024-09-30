package dz1;

import java.awt.Color;
import java.awt.Graphics;

public class Nebesko_telo extends Objekat {
	protected double r;
	public Nebesko_telo(int x, int y, Color c, double r) {
		super(x, y, c);
		this.r=r;
	}

	@Override
	public int getX() {
		return X;
	}

	@Override
	public void setX(int pomeraj) {
		X=X+pomeraj;
	}

	@Override
	public int getY() {
		return Y;
	}

	@Override
	public void setY(int pomeraj) {
		Y=Y+pomeraj;
	}

	

	public double getR() {
		return r;
	}

	public static void main(String[] args) {
		

	}

	@Override
	public void paint(Graphics g) {
	}

	@Override
	public boolean proveri(int x, int y) {
		return false;
	}



	

}
