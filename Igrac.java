package dz1;

import java.awt.Color;
import java.awt.Graphics;

public class Igrac extends Nebesko_telo {
	
	 private int[] xKoordinate = new int[3];
	 private int[] yKoordinate = new int[3];
	public Igrac(int x, int y) {
		super(x, y, Color.RED, 10);
		
	}

	public int vrhX() {
        return xKoordinate[1];    
    }
    public int vrhY() {
        return yKoordinate[1];    
    }
	
	@Override
	public boolean proveri(int x, int y) {
		return false;
	}

	@Override
	public void paint(Graphics g) {
		for(int i=0; i<3; i++) {
            xKoordinate[i] = (int) (getX() + r*Math.cos(i*2*(Math.PI/3)-22.5));
            yKoordinate[i] = (int) (getY() + r*Math.sin(i*2*(Math.PI/3)-22.5));    
        }
		g.drawPolygon(xKoordinate, yKoordinate, 3);
        g.setColor(Color.RED);
        g.fillPolygon(xKoordinate, yKoordinate, 3);
	}
	
	
	
}
