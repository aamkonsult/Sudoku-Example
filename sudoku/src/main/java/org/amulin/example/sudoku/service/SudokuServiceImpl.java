package org.amulin.example.sudoku.service;

import org.amulin.example.sudoku.model.MoveRequest;
import org.amulin.example.sudoku.model.MoveResult;
import org.springframework.stereotype.Service;

@Service("sudokuService")
public class SudokuServiceImpl implements SudokuService {

//	private static int[][] board =  { 	{7, 0, 0, 0, 4, 0, 5, 3, 0}, 
//										{0, 0, 5, 0, 0, 8, 0, 1, 0}, 
//										{0, 0, 8, 5, 0, 9, 0, 4, 0}, 
//										{5, 3, 9, 0, 6, 0, 0, 0, 1}, 
//										{0, 0, 0, 0, 1, 0, 0, 0, 5}, 
//										{8, 0, 0, 7, 2, 0, 9, 0, 0}, 
//										{9, 0, 7, 4, 0, 0, 0, 0, 0}, 
//										{0, 0, 0, 0, 5, 7, 0, 0, 0}, 
//										{6, 0, 0, 0, 0, 0, 0, 5, 0} };


	/* Method to check correctness of request
	 * Check if Sudoku board is of right size, 9x9
	 * Check if the values of board are allowed, between 0 and 9
	 * Check if move values are allowed, between 0 and 9
	 */
	public boolean isAllowedRequest(MoveRequest request) {
				
		if (request.getSudokuBoard() == null) {
			return false;
		}
		
		int[][] board = request.getSudokuBoard();
						
		if (board.length != 9) {
			return false;
		}
		
		for (int i = 0; i < 9; i++) {
			if (board[i].length != 9) {
				return false;
			}
			
			for (int j = 0; j < 9; j++) {
				if ((board[i][j] < 0) && (board[i][j] > 10)) {
					return false;
				}
			}
		}
		
		if ((request.getMoveRow() >= 0) && (request.getMoveRow() < 9)) {
			if ((request.getMoveColumn() >= 0) && (request.getMoveColumn() < 9)) {
				if ((request.getMoveValue() > 0) && (request.getMoveValue() < 10)) {
					return true;
				}
			}			
		}
		return false;
	}
	
	/* Method to validate the request
	 * Check if the column is valid
	 * Check if the row is valid
	 * Check if the block is valid
	 * Update board
	 * Check if the game is over
	 */
	public MoveResult validateMove(MoveRequest request) {

		int[][] board = request.getSudokuBoard();
		int row = request.getMoveRow();
		int column = request.getMoveColumn();
		int value = request.getMoveValue();
		
		// Print
		System.out.println("Fisrt, Row: " + row + " column: " + column + " value: " + value);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

				
		for (int i = 0; i < 9; i++) {
			if (row != i && board[i][column] == value) {
				return new MoveResult(false, i, column);
			}
		}
		
		for (int j = 0; j < 9; j++) {
			if (column != j && board[row][j] == value) {
				return new MoveResult(false, row, j);
			}
		}
		
		for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
			for (int j = (column / 3) * 3; j < (column / 3) * 3 + 3; j++) {
				if (row != i && column != j && board[i][j] == value) {
					return new MoveResult(false, i, j);
				}
			}
		}

		board[row][column] = value;
		
		// Print
		System.out.println("Result:");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == 0) {
					return new MoveResult(board, true, false);
				}
			}
		}
		
		return new MoveResult(board, true, true);		
		
	}



}
