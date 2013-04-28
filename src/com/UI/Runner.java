package com.UI;

import javax.swing.JFrame;

public class Runner {
	static JFrame window = new JFrame();
	
	public static void main(String[] args){
			
		getHomePage();

	}	
	public static void getHomePage(){
		window.setVisible(false);
		HomePage home = HomePage.getInstance();
		window.getContentPane().removeAll();
		window.getContentPane().add(home);
//			
		window.pack();
		window.setVisible(true);
		
//			window.removeAll();
		window.setSize(900, 700);
		window.setResizable(false);

		}
		
	
	
	public static void getGame(int numOfBoxes, boolean player2){
		MainPage mainPage = new MainPage(numOfBoxes, player2);
		window.getContentPane().removeAll();
		window.getContentPane().add(mainPage);
		window.setVisible(false);
		window.setVisible(true);
			
	}
	
	public static void disableWindow(){
		window.setEnabled(false);
			
	}
	
	public static void enableWindow(){
		window.setEnabled(true);
	}

}
