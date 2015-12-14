package org.amulin.example.sudoku.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SudokuServiceImplCheckersTest {
	
	SudokuServiceImpl serviceImpl = new SudokuServiceImpl();
	
	@Test
	public void isCorrectMoveRequestTest() {
		assertTrue(serviceImpl.isCorrectValuesRequest(1, 1, 9));
	}
	
	@Test
	public void isBadRowMoveRequesteTest() {
		assertFalse(serviceImpl.isCorrectValuesRequest(9, 1, 1));
	}
	
	@Test
	public void isBadColumnMoveRequestTest() {
		assertFalse(serviceImpl.isCorrectValuesRequest(1, 9, 1));
	}

	@Test
	public void isTooSmallValueMoveRequestTest() {
		assertFalse(serviceImpl.isCorrectValuesRequest(1, 2, 0));
	}

	@Test
	public void isTooBigValueMoveRequestTest() {
		assertFalse(serviceImpl.isCorrectValuesRequest(1, 2, 10));
	}

	@Test
	public void isRightSizeBoardTest() {
		assertTrue(serviceImpl.isRightSizeBoard(rightBoard));
	}
	
	@Test
	public void isTooBigBoardTest() {
		assertFalse(serviceImpl.isRightSizeBoard(tooBigBoard));
	}
	
	@Test
	public void isTooSmallBoardTest() {
		assertFalse(serviceImpl.isRightSizeBoard(tooSmallBoard));
	}

	@Test
	public void isRightValuesBoardTest() {
		assertTrue(serviceImpl.isRightValuesBoard(rightBoard));
	}
	
	@Test
	public void isBadValuesBoardTest() {
		assertFalse(serviceImpl.isRightValuesBoard(badValueBoard));
	}


	private static int[][] rightBoard = {	{ 7, 0, 0, 0, 4, 0, 5, 3, 0 },
											{ 0, 0, 5, 0, 0, 8, 0, 1, 0 }, 
											{ 0, 0, 8, 5, 0, 9, 0, 4, 0 },
											{ 5, 3, 9, 0, 6, 0, 0, 0, 1 }, 
											{ 0, 0, 0, 0, 1, 0, 0, 0, 5 },
											{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, 
											{ 9, 0, 7, 4, 0, 0, 0, 0, 0 },
											{ 0, 0, 0, 0, 5, 7, 0, 0, 0 }, 
											{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };

	private static int[][] tooBigBoard = {	{ 7, 0, 0, 0, 4, 0, 5, 3, 0 },
											{ 0, 0, 5, 0, 0, 8, 0, 1, 0 }, 
											{ 0, 0, 8, 5, 0, 9, 0, 4, 0 },
											{ 5, 3, 9, 0, 6, 0, 0, 0, 1 }, 
											{ 0, 0, 0, 0, 1, 0, 0, 0, 5 },
											{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, 
											{ 5, 3, 9, 0, 6, 0, 0, 0, 1 },
											{ 9, 0, 7, 4, 0, 0, 0, 0, 0 },
											{ 0, 0, 0, 0, 5, 7, 0, 0, 0 }, 
											{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };

	private static int[][] tooSmallBoard = {{ 7, 0, 0, 0, 4, 0, 5, 3, 0 },
											{ 0, 0, 5, 0, 0, 8, 0, 1, 0 }, 
											{ 0, 0, 8, 5, 0, 9, 0, 0 },
											{ 5, 3, 9, 0, 6, 0, 0, 0, 1 }, 
											{ 0, 0, 0, 0, 1, 0, 0, 0, 5 },
											{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, 
											{ 9, 0, 7, 4, 0, 0, 0, 0, 0 },
											{ 0, 0, 0, 0, 5, 7, 0, 0, 0 }, 
											{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };

	private static int[][] badValueBoard = {{ 7, 0, 0, 0, 4, 0, 5, 3, 0 },
											{ 0, 0, 5, 0, 0, 8, 0, 1, 0 }, 
											{ 0, 0, 8, 5, 0, 9, 0, 4, 0 },
											{ 5, 3, 9, 0, 6, 0, 0, 10, 1 }, 
											{ 0, 0, 0, 0, 1, 0, 0, 0, 5 },
											{ 8, 0, 0, 7, 2, 0, 9, 0, 0 }, 
											{ 9, 0, 7, 4, 0, 0, 0, 0, 0 },
											{ 0, 0, 0, 0, 5, 7, 0, 0, 0 }, 
											{ 6, 0, 0, 0, 0, 0, 0, 5, 0 } };


}
