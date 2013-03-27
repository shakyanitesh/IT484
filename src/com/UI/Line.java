package com.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.state.AI;
import com.state.SingletonStatus;

public class Line extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1013186591824142112L;
	private boolean clicked;
	private Box box1;
	private Box box2;

	public Line(boolean horizontal){
		super();
		clicked = false;
		if(horizontal){
//			this.setSize(50, 10);
			this.setMinimumSize(new Dimension(50, 10));
			this.setMaximumSize(new Dimension(50, 10));
			this.setPreferredSize(new Dimension(50, 10));
		} else {
//			this.setSize(10, 50);
			this.setMinimumSize(new Dimension(10, 50));
			this.setMaximumSize(new Dimension(10, 50));
			this.setPreferredSize(new Dimension(10, 50));
		}
		this.setBackground(Color.WHITE);
		addMouseListener(this);
	}
	
	public boolean getClicked(){
		return this.clicked;
	}
	
	public void setBox1(Box box) {
		box1 = box;
	}

	public void setBox2(Box box) {
		box2 = box;
	}
	
	public Box getBox1(){
		return box1;
	}
	
	public Box getBox2(){
		return box2;
	}
	
	private boolean checkBox(){
		boolean box1Complete = false;
		boolean box2Complete = false;
		if(this.box1 != null){
			box1Complete = this.box1.checkIfComplete();
		}
		if(this.box2 != null){
			box2Complete = this.box2.checkIfComplete();
		}
		return box1Complete || box2Complete;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!clicked){
			clicked = true;
			if(SingletonStatus.getInstance().getTurn()){
				this.setBackground(Color.RED);
				if(!checkBox()){
					SingletonStatus.getInstance().setTurn(false);
					AI.getInstance().run();
				}
			} else {
				this.setBackground(Color.YELLOW);
				if(!checkBox()){
					SingletonStatus.getInstance().setTurn(true);
				} else {
					AI.getInstance().run();
				}
				
			}
			MainPage.setTurn();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!clicked){
			this.setBackground(Color.BLUE);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(!clicked){
			this.setBackground(Color.WHITE);
		}
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
