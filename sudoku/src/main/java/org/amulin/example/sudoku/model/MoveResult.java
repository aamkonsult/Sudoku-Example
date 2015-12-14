package org.amulin.example.sudoku.model;

/**
 * Move result object
 * to sent to FrondEnd
 * @author amulin
 *
 */
public class MoveResult {
	
	private int[][] board;
	
	private boolean isValidMove;
	private int conflictRow;
	private int conflictColumn;
	
	private boolean isGameOver;
	
	public MoveResult() {
	}
	
	/**
	 * Constructor to create response to valid Move
	 */
	public MoveResult (int[][] board, boolean isValid, boolean isGameOver) {
		this.isValidMove = isValid;
		this.isGameOver = isGameOver;
	}
	
	/**
	 * Constructor used to create response to incorrect Move
	 */
	public MoveResult(boolean isValid, int conflictRow, int conflictColumn) {
		this.isValidMove = isValid;
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
		return isValidMove;
	}
	public void setValid(boolean isValid) {
		this.isValidMove = isValid;
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
