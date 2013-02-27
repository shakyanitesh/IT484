package com.UI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

public class Board extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8195968150749929189L;
	private int numberOfBoxes;
	private GridBagConstraints gbc;
	public Board(int numberOfBoxes){
		super();
		this.numberOfBoxes = 2 * numberOfBoxes +1;
		this.setLayout(createLayout());
		this.gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.addComponent();
//		this.setSize(400,400);
	}
	
	private GridBagLayout createLayout(){
		GridBagLayout gridBagLayout = new GridBagLayout(/*this.numberOfBoxes, this.numberOfBoxes*/);
		return gridBagLayout;
	}
	private void addComponent(){
		int numberOfRows = numberOfBoxes;
		for(int i = 1; i <= numberOfRows; i++){
			gbc.gridy = i - 1;
			for(int j = 1; j <= numberOfRows; j++){
				gbc.gridx = j - 1;
				if(i % 2 == 1){
					if(j % 2 == 1){
						addDot();
					} else {
						addLine(true);
					}
				} else {
					if(j % 2 == 1){
						addLine(false);
					} else {
						addBox();
					}
				}
			}
		}
	}
	
	private void addDot(){
//		gbc.gridheight = 1;
//		gbc.gridwidth = 1;
		Dot comp = new Dot();
		System.out.println("adding dot to " + gbc.gridx + gbc.gridy);
		this.add(comp, gbc);
	}
	
	private void addLine(boolean horizontal){
		if(horizontal){
//			gbc.gridheight =1;
//			gbc.gridwidth = 4;
		} else {
//			gbc.gridheight = 4;
//			gbc.gridwidth = 1;
		}
		Line comp = new Line(horizontal);
		System.out.println("adding line to " + gbc.gridx + gbc.gridy);
		this.add(comp, gbc);
//		getContentPane().add(comp, gbc);
	}
	
	private void addBox(){
//		gbc.gridheight = 4;
//		gbc.gridwidth = 4;
		Box comp = new Box();
		System.out.println("adding box to " + gbc.gridx + gbc.gridy);
		this.add(comp, gbc);
//		getContentPane().add(comp, gbc);
	}

}
