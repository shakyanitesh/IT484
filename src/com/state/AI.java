package com.state;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.UI.Board;
import com.UI.Box;
import com.UI.Line;


/*
 * This class is the AI class which when enabled will calculate and make the next move
 * This class uses Singleton Pattern as there is only one AI for this class
 */
public class AI {
	
	private static AI ai;	// This is the single instance of this AI class that will be used
	private boolean enabled;	//This is the boolean that takes if the AI is enabled, this will be enabled if user chooses 
	private Board board;	//This is the reference to the board that the AI is making move on
	
	//Making constructor private
	private AI(){
		
	}
	
	//Method to get instance of the class
	public static AI getInstance(){
		if(ai == null){
			ai = new AI();
		}
		return ai;
	}

	//sets the board to the AI to work with
	public void setBoard(Board board) {
		this.board = board;
	}
	
	//Sets if the AI is enabled
	public void setEnabled(boolean enable) {
		this.enabled = enable;
	}
	//Gets if the AI is enabled
	public boolean getEnabled() {
		return this.enabled;
	}
	
	//This is the run method that will be called when the turn is of AI, this method will calculate what line to click and make its move
	public void run() {
		if(!board.checkComplete()){
			Line line = null;
			line = checkValidMoves();
			makeMove(line);
		}
	}

	//This method takes the line and click on it programatically
	private void makeMove(Line line) {
		int x = line.getX();
		int y = line.getY();
		MouseEvent me = new MouseEvent(line, 0, 0, 0, x, y,1, false,1);
		for(MouseListener ml : line.getMouseListeners()){
			ml.mouseClicked(me);
		}
	}

	//This method gets the valid move to make next
	private Line checkValidMoves() {
		Line completeLine = null;
		//First the AI checks for any box completion possibility, if there is then it makes it
		completeLine = checkBoxWithCompletionPossibility() ;
		if(completeLine != null){
			System.out.println("Returning from Completeline: " + completeLine);
			return completeLine; 
		}
		
		//Next it checks the safe line which will not result in the user to make a box
		completeLine = getSafeLine();
		if(completeLine != null){
			System.out.println("Returning from safeline: " + completeLine);
			return completeLine; 
		}
		
		//If it cant find the safe or the box line, it will click on the first line, 
		System.out.println("Returning random Line");
		return returnRandomLine(getUnclickedLines());
		
	}
	
	
	private List<Line> getUnclickedLines(){
		List<Line> tempLine = new ArrayList<Line>();
		
		List<Line> horizontalLines = board.getHorizontalLines();
		List<Line> verticalLines = board.getVerticalLines();
		for(Line line : horizontalLines){
			if(line.getClicked() != true){
				tempLine.add(line);
			}
		}
		for(Line line : verticalLines){
			if(line.getClicked() != true){
				System.out.println("Returning from first encounter: " + line);
				tempLine.add(line);
			}
		}
		
		return tempLine;
	}
	
	//Getting the line if there is a box possibility
	private Line checkBoxWithCompletionPossibility(){
		for(Box box : board.getBoxes()){
			if(box.getNumberOfLinesCompleted() == 3){
				if(box.getVerticalLine1().getClicked()){
					if(box.getHorizontalLine1().getClicked()){
						if(box.getHorizontalLine2().getClicked()){
							return box.getVerticalLine2();
						}
						return box.getHorizontalLine2();
					}
					return box.getHorizontalLine1();
				}
				return box.getVerticalLine1();
			}
		}
		return null;
	}
	
	
	//Method that takes a line and checks if both the boxes related to the lines are safe
	private boolean checkBothBoxesSafe(Line line){
		Box box = line.getBox1();
		if(box != null){
			if(box.getNumberOfLinesCompleted() > 1){
				return false;
			}
		}
		box = line.getBox2();
		if(box != null){
			if(box.getNumberOfLinesCompleted() > 1){
				return false;
			}
		}
		return true;
	}
	
	//Method that checks and returns the first safe line
	private Line getSafeLine() {
		List<Line> tempLines = new ArrayList<Line>();
		for(Line line : getUnclickedLines()){
			if(checkBothBoxesSafe(line)){
				tempLines.add(line);
			}
		}
		return returnRandomLine(tempLines);
	}

	//Method that takes list of lines and returns a random one
	private Line returnRandomLine(List<Line> tempLines){
		if(tempLines.size() > 0){
			Random random = new Random();
			int index = random.nextInt(tempLines.size() - 0);
			return tempLines.get(index);
		}
		return null;
	}


}
