package com.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.state.SingletonStatus;

public class Box extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8210921496253749477L;
	private Line verticalLine1;
	private Line verticalLine2;
	private Line horizontalLine1;
	private Line horizontalLine2;
	private boolean complete;

	public Box(){
		super();
		complete = false;
		this.setSize(50, 50);
		this.setBackground(Color.WHITE);
		this.setMinimumSize(new Dimension(50, 50));
		this.setMaximumSize(new Dimension(50, 50));
		this.setPreferredSize(new Dimension(50, 50));
	}

	public void setVerticalLine1(Line line){
		this.verticalLine1 = line;
	}

	public void setVerticalLine2(Line line) {
		this.verticalLine2 = line;
	}
	
	public void setHorizontalLine2(Line line) {
		this.horizontalLine1 = line;
	}

	public void setHorizontalLine1(Line line) {
		this.horizontalLine2 = line;
	}
	
	public Line getVerticalLine1(Line line){
		return this.verticalLine1;
	}

	public Line getVerticalLine2(Line line) {
		return this.verticalLine2;
	}
	
	public Line getHorizontalLine2(Line line) {
		return this.horizontalLine1;
	}

	public Line getHorizontalLine1(Line line) {
		return this.horizontalLine2;
	}
	;
	public boolean getComplete(){
		return complete;
	}
	
	public boolean checkIfComplete(){
		if(verticalLine1.getClicked()){
			if(verticalLine2.getClicked()){
				if(horizontalLine1.getClicked()){
					if(horizontalLine2.getClicked()){
						SingletonStatus.setScore(SingletonStatus.getScore() + 1);
						MainPage.refreshScore();
						complete = true;
						if(SingletonStatus.turn){
							this.setBackground(Color.RED);

						} else {
							this.setBackground(Color.YELLOW);
						}
						return complete;
					}
				}
			}
		}
		return false;
	}
}
