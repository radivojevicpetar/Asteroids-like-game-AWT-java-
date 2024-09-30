package dz1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Simulator extends Frame {
	
	private Panel buttonPanel=new Panel();
	private Button startButton = new Button("Pokreni!");
	private Svemir scene;
	private Generator g;
	Panel centerPanel = new Panel();
	
	public Simulator() {
		setBounds(700, 200,200, 400);
		setResizable(false);
		scene=new Svemir();
		g=new Generator(scene);
		populateWindow();
		pack();
		
		
		/*for(int i=0;i<=5;i++) {
			Kometa k=new Kometa(new Random().nextInt(200),0,10 + new Random().nextDouble(20));
			scene.dodaj(k);
		}*/
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				g.zaustavi();
				scene.zaustavi();
				dispose();
			}
		});
		
		setVisible(true);
	}
	private void populateWindow(){
		buttonPanel.add(startButton);
		add(buttonPanel, BorderLayout.SOUTH);
		/*centerPanel.setLayout(new BorderLayout());
		centerPanel.add(scene,BorderLayout.CENTER);
		add(centerPanel,BorderLayout.CENTER);*/
		scene.setPreferredSize(new Dimension(getWidth(),getHeight()));
		add(scene,BorderLayout.CENTER);
		startButton.addActionListener((ae) -> {
			scene.thread.start();
			scene.go();
			g.thread.start();
			g.go();
			startButton.setEnabled(false);
		});
	}
	
	//Kometa k=new Kometa(150,150,Color.BLACK,50);

	
	public static void main(String[] args) {
		new Simulator();

	}

}
