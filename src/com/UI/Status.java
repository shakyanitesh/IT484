package com.UI;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Status extends JPanel {
	private JLabel turnStatus;
	private JLabel player1ScoreStatus;
	private JLabel player2ScoreStatus;
	
	public Status(){
		this.setLayout(new BorderLayout());
		turnStatus = new JLabel("Player 1");
		player1ScoreStatus = new JLabel("Player 1: 0");
		player2ScoreStatus = new JLabel("Player 2: 0");
		this.add(turnStatus, BorderLayout.CENTER);
		this.add(player1ScoreStatus, BorderLayout.PAGE_END);
	}
	
	public void setPlayer1Score(int score){
		player1ScoreStatus.setText("Player 1: " + score);
	}

}
