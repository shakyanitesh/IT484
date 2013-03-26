package com.UI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Board extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8195968150749929189L;
	private int numberOfBoxes;
	private GridBagConstraints gbc;
	
	//List of components created
	private List<Line> listOfHorizontalLines = new ArrayList<Line>();
	private List<Line> listOfVerticalLines = new ArrayList<Line>();
	private List<Box> listOfBoxes = new ArrayList<Box>();
	
	public Board(int numberOfBoxes){
		super();
		this.numberOfBoxes = numberOfBoxes;
		this.setLayout(createLayout());
		this.gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.setBackground(Color.gray);
		this.addComponent();
//		this.setSize(400,400);
	}
	
	public boolean checkComplete(){
//		for(Line line : listOfHorizontalLines){
//			if(!line.getClicked()){
//				System.out.println("HERE IN HORI");
//				return false;
//			}
//		}
//		for(Line line : listOfVerticalLines){
//			if(!line.getClicked()){
//				System.out.println("HERE IN VERTICAL");
//				return false;
//			}
//		}
		for(Box box : listOfBoxes){
			if(!box.getComplete()){
				return false;
			}
		}
		return true;
		
	}
	
	private GridBagLayout createLayout(){
		GridBagLayout gridBagLayout = new GridBagLayout(/*this.numberOfBoxes, this.numberOfBoxes*/);
		return gridBagLayout;
	}
	private void addComponent(){
		int numberOfRows = numberOfBoxes * 2 + 1;
		
		//Creating component in board
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
		
		//Creating relation between line and box, each line has two box that they can complete
		for(int i = 1; i <= listOfHorizontalLines.size(); i++){
			Line horizontalLine = listOfHorizontalLines.get(i-1);
			int firstBox  = i - numberOfBoxes;
//			System.out.print("Horizontal Line " + i + " has relation with: ");
			if(firstBox > 0 && firstBox <= listOfBoxes.size()){
				horizontalLine.setBox1(listOfBoxes.get(firstBox - 1));
//				System.out.print(firstBox);
			}
			if(i > 0 && i <= listOfBoxes.size()){
				horizontalLine.setBox2(listOfBoxes.get(i-1));
//				System.out.print(",");
//				System.out.print(i);
			}
//			System.out.println();
		}
		
		for(int i = 1; i <= listOfVerticalLines.size(); i++){
			Line verticalLine = listOfVerticalLines.get(i-1);
			int subFactor = i / (numberOfBoxes +1);
			int firstBox = i - (subFactor + 1) ;
			int secondBox = i - subFactor;
			if(i % (numberOfBoxes + 1) == 0){
				firstBox = i - subFactor;
				secondBox = -3;
			} else if(i % (numberOfBoxes + 1) == 1){
				firstBox = -3;
			}
//			System.out.print("Vertical Line " + i + " has relation with: ");
			if(firstBox > 0 && firstBox <= listOfBoxes.size()){
//				System.out.print(firstBox);
				verticalLine.setBox1(listOfBoxes.get(firstBox-1));
			}
			if(secondBox > 0 && secondBox <= listOfBoxes.size()){
				verticalLine.setBox2(listOfBoxes.get(secondBox-1));
//				System.out.print(",");
//				System.out.print(secondBox);
				
			}
//			System.out.println();
			
		}
		
		//Creating relation between box and line, each box has four lines if which are clicked then the box is to be created.
		for(int i = 1; i <= listOfBoxes.size(); i++){
			Box box = listOfBoxes.get(i-1);
			int addFactor = i / (numberOfBoxes);
			if(i % numberOfBoxes == 0){addFactor -= 1;}
			int verticalLine1 = i + addFactor;
			int verticalLine2 = i + 1 + addFactor;
			int horizontalLine1 = i;
			int horizontalLine2 = i + numberOfBoxes;
//			System.out.println("Box " +i + " has four lines (" + verticalLine1 + ","+ verticalLine2 + ","+ horizontalLine1+ "," + horizontalLine2 + ")");
			box.setVerticalLine1(listOfVerticalLines.get(verticalLine1-1));
			box.setVerticalLine2(listOfVerticalLines.get(verticalLine2-1));
			box.setHorizontalLine1(listOfHorizontalLines.get(horizontalLine1-1));
			box.setHorizontalLine2(listOfHorizontalLines.get(horizontalLine2-1));
		}
	}
	
	private void addDot(){
		Dot comp = new Dot();
		this.add(comp, gbc);
	}
	
	private void addLine(boolean horizontal){
		Line comp = new Line(horizontal);
		if(horizontal){
			listOfHorizontalLines.add(comp);
		} else {
			listOfVerticalLines.add(comp);
		}
		this.add(comp, gbc);
		
	}
	
	private void addBox(){
		Box comp = new Box();
		this.add(comp, gbc);
		this.listOfBoxes.add(comp);
	}

}
