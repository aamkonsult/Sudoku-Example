package org.amulin.example.sudoku.service;

import org.amulin.example.sudoku.model.MoveRequest;
import org.amulin.example.sudoku.model.MoveResult;

public interface SudokuService {

	MoveResult validateMove(MoveRequest request);

	boolean isAllowedRequest(MoveRequest request);

}
