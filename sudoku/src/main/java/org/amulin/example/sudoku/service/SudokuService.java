package org.amulin.example.sudoku.service;

import org.amulin.example.sudoku.model.MoveRequest;
import org.amulin.example.sudoku.model.MoveResult;

public interface SudokuService {

	/**
	 * Interface to validate Sudoku move
	 * @param request	MoveRequest object sent from FrontEnd
	 * @return			MoveResult object to sent to FrontEnd
	 */
	MoveResult validateMove(MoveRequest request);

	/**
	 * Interface to check corectness of the request
	 * @param request	MoveRequest object sent from FrontEnd
	 * @return			True if the request is correct
	 */
	boolean isAllowedRequest(MoveRequest request);

}
