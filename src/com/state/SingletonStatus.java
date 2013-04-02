package com.state;

import com.UI.MainPage;

public class SingletonStatus {
	
	//This class has status of turn and scores.
	public boolean turn = true;		// This denotes turn, true -> player1 false -> player 2
	
	//Scores for respective player
	private int score1 = 0;
	private int score2 = 0;

	//Instance for singleton pattern
	private static SingletonStatus instance;
	
	//Privatizing constructor so that we only have one instance
	private SingletonStatus(){
		
	}

	//Returns instance for the class
	public static SingletonStatus getInstance(){
		if(instance == null){
			instance = new SingletonStatus();
		}
		return instance;
	}
	
	
	//Accessor and mutators
	public boolean getTurn(){
		return turn;
	}
	
	public void setTurn(boolean turn){
		this.turn = turn;
		MainPage.setTurn();
	}

	//Sets the score of the player whose turn it is
	public void setScore(int score){
		if(turn){
			score1 = score;
			return;
		}
		score2 = score;
	}
	
	//gets the score of the player whose turn it is
	public int getScore(){
		if(turn){
			return score1;
		}
		return score2;
	}
	

	//Methods to get scores of respective players
	public int getPlayer1Score(){
		return score1;

	}

	public int getPlayer2Score(){
		return score2;
	}
	

}
