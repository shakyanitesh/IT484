package com.UI;

import javax.swing.JFrame;

public class Runner {
	static JFrame window = new JFrame();
	
	public static void main(String[] args){
			
		
//		window.setLayout(/*new CardLayout()*/);
//		new JPanel()\\ 
		
		HomePage home = HomePage.getInstance();
		window.getContentPane().add(home);
//		
		window.pack();
		window.setVisible(true);
		
//		window.removeAll();
		window.setSize(600, 600);
		
		
		
		
	}
	
	public static void getGame(int numOfBoxes, boolean player2){
		MainPage mainPage = new MainPage(numOfBoxes, player2);
		window.getContentPane().removeAll();
		window.getContentPane().add(mainPage);
		window.setVisible(false);
		window.setVisible(true);
		
		
		
	}

}
