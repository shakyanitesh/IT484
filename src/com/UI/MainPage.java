package com.UI;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.state.Player;

public class MainPage extends JPanel{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -386551712892064216L;

	private static JLabel turnStatus = new JLabel("Player 1's Turn");
	private static JLabel player1Score= new JLabel("Player 1: 0");
	private static JLabel player2Score = new JLabel("Player 2: 0");
	private JPanel score = new JPanel();
	private static Board board;
	public MainPage(){
		board = new Board(5);
		this.setLayout(new BorderLayout());
		this.add(board, BorderLayout.CENTER);
		this.add(turnStatus, BorderLayout.NORTH);
		score.add(player1Score, BorderLayout.LINE_START);
		score.add(player2Score, BorderLayout.LINE_END);
		this.add(score, BorderLayout.SOUTH);
	}
	
	public static void setTurn(){
		if(board.checkComplete()){
			turnStatus.setText("Game Complete");
			return;
		}
		if(Player.turn){
			turnStatus.setText("Player 1's turn");
		} else{
			turnStatus.setText("Player 2's turn");
		}
	}
	public static void refreshScore(){
		player1Score.setText("Player 1: " + Player.getPlayer1Score());
		player2Score.setText("Player 2: " + Player.getPlayer2Score());
	}
	public void setPlayer1Score(int score){
		player1Score.setText("Player 1: " + score);
	}
	
	public void setPlayer2Score(int score){
		player2Score.setText("Player 2: " + score);
	}
	
}

