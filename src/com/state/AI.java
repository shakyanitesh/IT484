package com.state;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import com.UI.Board;
import com.UI.Line;

public class AI {
	
	private static AI ai;
	private boolean enabled;
	private Board board;
	
	private AI(){
		
	}
	
	public static AI getInstance(){
		if(ai == null){
			ai = new AI();
		}
		return ai;
	}

	public void run() {
		Line line = checkValidMoves();
		makeMove(line);
		
	}

	private void makeMove(Line line) {
		int x = line.getX();
		int y = line.getY();
		System.out.println("here");
		MouseEvent me = new MouseEvent(line, 0, 0, 0, x, y,1, false,1);
		for(MouseListener ml : line.getMouseListeners()){
			ml.mouseClicked(me);
		}
		System.out.println("here");
	}

	private Line checkValidMoves() {
		List<Line>  lines = board.getHorizontalLines();
		for(Line line : lines){
			if(line.getClicked() != true){
				return line;
			}
		}
		return null;
		
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	

}
