package org.amulin.example.sudoku.controller;

import org.amulin.example.sudoku.model.MoveRequest;
import org.amulin.example.sudoku.model.MoveResult;
import org.amulin.example.sudoku.service.SudokuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Sudoku Rest Controller
 * Method PUT
 * HTTP request body as JSON, input object MoveRequest
 * HTTP response code indicate response status
 * HTTP response body as JSON, output object MoveResult
 * @author amulin
 *
 */
@RestController
public class SudokuRestController {
	
	final static Logger logger = LoggerFactory.getLogger(SudokuRestController.class);
	
	@Autowired
	SudokuService sudokuService;
		
	@RequestMapping(value = "/sudoku/", method = RequestMethod.PUT)
	public ResponseEntity<MoveResult> validateMove(@RequestBody MoveRequest request) {
		logger.info("Some request: {}", request);
		
		if (!sudokuService.isAllowedRequest(request)) {
			return new ResponseEntity<MoveResult>(HttpStatus.BAD_REQUEST);
		}
				
		MoveResult result = sudokuService.validateMove(request);
		if (!result.isValid()) {
			return new ResponseEntity<MoveResult>(result, HttpStatus.CONFLICT);
		}
				
		return new ResponseEntity<MoveResult>(result, HttpStatus.OK);
	}
}
