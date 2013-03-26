package com.UI;

import javax.swing.JFrame;

public class Runner {
	
	public static void main(String[] args){
			
		JFrame window = new JFrame();
//		window.setLayout(/*new CardLayout()*/);
//		new JPanel()\\ 
		MainPage mainPage = new MainPage();
		window.getContentPane().add(mainPage);
//		
		window.pack();
		window.setVisible(true);
		
//		window.removeAll();
		window.setSize(600, 600);
		
		
		
	}

}
