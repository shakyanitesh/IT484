package com.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Line extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1013186591824142112L;

	public Line(boolean horizontal){
		super();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("HERE");
		this.setBackground(Color.RED);
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setBackground(Color.BLUE);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.WHITE);
		
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
