package org.amulin.example.sudoku.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.amulin.example.sudoku.model.MoveRequest;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SudokuServiceImplTest {
			
	SudokuServiceImpl serviceImpl = new SudokuServiceImpl();
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void incorrectMoveValuesUpperTest() throws JsonParseException, JsonMappingException, IOException {
		
		MoveRequest request = mapper.readValue(badUpperValuesRequest, MoveRequest.class);		
		assertFalse(serviceImpl.isAllowedRequest(request));		
	}
	
	@Test
	public void incorrectMoveValuesLowerTest() throws JsonParseException, JsonMappingException, IOException {
		
		MoveRequest request = mapper.readValue(badLowerValuesRequest, MoveRequest.class);		
		assertFalse(serviceImpl.isAllowedRequest(request));		
	}

	@Test
	public void correctMoveValuesUpperTest() throws JsonParseException, JsonMappingException, IOException {
		
		MoveRequest request = mapper.readValue(goodUpperValuesRequest, MoveRequest.class);		
		assertTrue(serviceImpl.isAllowedRequest(request));		
	}
	
	@Test
	public void correctMoveValuesLowerTest() throws JsonParseException, JsonMappingException, IOException {
		
		MoveRequest request = mapper.readValue(goodLowerValuesRequest, MoveRequest.class);		
		assertTrue(serviceImpl.isAllowedRequest(request));		
	}

	
	@Test
	public void rowConflictRequestTest() throws JsonParseException, JsonMappingException, IOException {
		MoveRequest request = mapper.readValue(rowConflictRequest, MoveRequest.class);		
		assertFalse(serviceImpl.validateMove(request).isValid());
		
	}
	
	@Test
	public void columnConflictRequestTest() throws JsonParseException, JsonMappingException, IOException {
		MoveRequest request = mapper.readValue(columnConflictRequest, MoveRequest.class);		
		assertFalse(serviceImpl.validateMove(request).isValid());
		
	}

	@Test
	public void blockConflictRequestTest() throws JsonParseException, JsonMappingException, IOException {
		MoveRequest request = mapper.readValue(blockConflictRequest, MoveRequest.class);		
		assertFalse(serviceImpl.validateMove(request).isValid());
		
	}

	
	final String badUpperValuesRequest = 	"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":10,\"moveColumn\":10,\"moveValue\":10}";	
	final String badLowerValuesRequest = 	"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":-1,\"moveColumn\":-1,\"moveValue\":10}";	

	final String goodUpperValuesRequest = 	"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":8,\"moveColumn\":8,\"moveValue\":9}";	
	final String goodLowerValuesRequest = 	"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":0,\"moveColumn\":0,\"moveValue\":1}";	

	final String rowConflictRequest = 		"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":1,\"moveColumn\":3,\"moveValue\":1}";	
	final String columnConflictRequest = 	"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":1,\"moveColumn\":4,\"moveValue\":2}";	
	final String blockConflictRequest = 	"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":3,\"moveColumn\":5,\"moveValue\":2}";	

	final String goodRequest = 				"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":0,\"moveColumn\":8,\"moveValue\":9}";	


}
