package org.amulin.example.sudoku.model;

public class MoveRequest {
	
	private int[][] sudokuBoard;
	
	private int moveRow;
	private int moveColumn;
	private int moveValue;
		
	
	public int[][] getSudokuBoard() {
		return sudokuBoard;
	}
	
	public void setSudokuBoard(int[][] sudokuBoard) {
		this.sudokuBoard = sudokuBoard;
	}
	
	public int getMoveRow() {
		return moveRow;
	}
	
	public void setMoveRow(int moveRow) {
		this.moveRow = moveRow;
	}
	
	public int getMoveColumn() {
		return moveColumn;
	}
	
	public void setMoveColumn(int moveColumn) {
		this.moveColumn = moveColumn;
	}
	
	public int getMoveValue() {
		return moveValue;
	}
	
	public void setMoveValue(int moveValie) {
		this.moveValue = moveValie;
	}
}
