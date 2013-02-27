package com.UI;

import javax.swing.JFrame;

public class Runner {
	
	public static void main(String[] args){
			
		JFrame window = new JFrame();
//		window.setLayout(new CardLayout());
		window.getContentPane().add(new Board(5));
		window.pack();
		window.setVisible(true);
		window.setSize(600, 600);
		
		
		
	}

}
