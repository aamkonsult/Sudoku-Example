package org.amulin.example.sudoku.model;

public class MoveResult {
	
	private int[][] board;
	
	private boolean isValid;
	private int conflictRow;
	private int conflictColumn;
	
	private boolean isGameOver;
	
	public MoveResult() {
	}
	
	public MoveResult (int[][] board, boolean isValid, boolean isGameOver) {
		this.isValid = isValid;
		this.isGameOver = isGameOver;
	}
	
	public MoveResult(boolean isValid, int conflictRow, int conflictColumn) {
		this.isValid = isValid;
		this.conflictRow = conflictRow;
		this.conflictColumn = conflictColumn;
	}
	
	
	public int[][] getboard() {
		return board;
	}
	
	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public int getConflictRow() {
		return conflictRow;
	}
	public void setConflictRow(int conflictRow) {
		this.conflictRow = conflictRow;
	}
	public int getConflictColumn() {
		return conflictColumn;
	}
	public void setConflictColumn(int conflictColumn) {
		this.conflictColumn = conflictColumn;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public void setGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
	}

}
