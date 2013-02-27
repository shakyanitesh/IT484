package com.UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Line extends JPanel {
	
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
		this.setBackground(new Color(100, 100, 100));
	}

}
