package com.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Dot extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5273420660660009104L;

	public Dot(){
		super();
		this.setBackground(new Color(0, 0, 0));
		this.setMinimumSize(new Dimension(10, 10));
		this.setMaximumSize(new Dimension(10, 10));
		this.setPreferredSize(new Dimension(10, 10));
	}

}
