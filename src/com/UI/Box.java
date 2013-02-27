package com.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Box extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8210921496253749477L;

	public Box(){
		super();
		this.setSize(50, 50);
		this.setBackground(Color.WHITE);
		this.setMinimumSize(new Dimension(50, 50));
		this.setMaximumSize(new Dimension(50, 50));
		this.setPreferredSize(new Dimension(50, 50));
	}

}
