package org.amulin.example.sudoku.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SudokuServiceImplValidatorsTest {
	
	SudokuServiceImpl serviceImpl = new SudokuServiceImpl();
	
	@Test
	public void validateRowNotOkTest() {
		assertEquals(serviceImpl.validateRow(board, 2, 4, 4), 7);
	}
	
	@Test
	public void validateRowOkTest() {
		assertEquals(serviceImpl.validateRow(board, 2, 4, 3), -1);
	}
	
	@Test
	public void validateColumnNotOkTest() {
		assertEquals(serviceImpl.validateColumn(board, 1, 3, 5), 2);
	}
	
	@Test
	public void validateColumnOkTest() {
		assertEquals(serviceImpl.validateColumn(board, 1, 3, 6), -1);
	}

	@Test
	public void validateBlockNotOkTest() {
		int[] result = serviceImpl.validateBlock(board, 3, 5, 2);
		assertEquals(result[0], 5);
		assertEquals(result[1], 4);
	}
	
	@Test
	public void validateBlockOkTest() {
		int[] result = serviceImpl.validateBlock(board, 3, 5, 4);
		assertEquals(result[0], -1);
		assertEquals(result[1], -1);
	}
	
	@Test
	public void updateBoardTest() {
		assertEquals(board[8][8], 0);
		serviceImpl.updateBoard(board, 8, 8, 8);
		assertEquals(board[8][8], 8);
	}
	
	@Test
	public void isNotGameOverTest() {
		assertFalse(serviceImpl.isGameOver(board));
	}
	
	@Test
	public void isGameOverTest() {
		assertTrue(serviceImpl.isGameOver(fullBoard));
	}

	private static int[][] board = {	{ 7, 0, 0, 0, 4, 0, 5, 3, 0 },
										{ 0, 0, 5, 0, 0, 8, 0, 1, 0 }, 
										{ 0, 0, 8, 5, 0, 9, 0, 4, 0 },
										{ 5, 3, 9, 0, 6, 0, 0, 0, 1 }, 
										{ 0, 0, 0, 0, 1, 0, 0, 0, 5 },
										{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, 
										{ 9, 0, 7, 4, 0, 0, 0, 0, 0 },
										{ 0, 0, 0, 0, 5, 7, 0, 0, 0 }, 
										{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };

	private static int[][] fullBoard = {{ 7, 9, 2, 1, 4, 6, 5, 3, 8 },
										{ 4, 6, 5, 2, 3, 8, 7, 1, 9 }, 
										{ 3, 1, 8, 5, 7, 9, 6, 4, 2 },
										{ 5, 3, 9, 8, 6, 4, 2, 7, 1 }, 
										{ 2, 7, 6, 9, 1, 3, 4, 8, 5 },
										{ 8, 4, 1, 7, 2, 5, 9, 6, 3 }, 
										{ 9, 5, 7, 4, 8, 1, 3, 2, 6 },
										{ 1, 2, 3, 6, 5, 7, 8, 9, 4 }, 
										{ 6, 8, 4, 3, 9, 8, 1, 5, 7 } };

}
