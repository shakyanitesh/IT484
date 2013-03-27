package com.state;

public class SingletonStatus {
	
	public static boolean turn = true;
	
	
	private static int score1 = 0;
	private static int score2 = 0;
	private String name;
	public SingletonStatus(String name){
		this.name = name;
		
	}
	
	public String getName(){
		return this.name;
	}
	public static void setScore(int score){
		if(turn){
			score1 = score;
			return;
		}
		score2 = score;
		
	}
	
	public static int getScore(){
		if(turn){
			return score1;
		}
		return score2;
	}
	
	public static int getPlayer1Score(){
		return score1;

	}

	public static int getPlayer2Score(){
		return score2;
	}
	

}
