package com.state;

public class Player {
	
	public static boolean turn = true;
	
	
	private int score;
	private String name;
	public Player(String name){
		this.name = name;
		
	}
	
	public String getName(){
		return this.name;
	}
	public void setScore(int score){
		this.score = score;
	}
	
	public int getScore(){
		return score;
	}

}
