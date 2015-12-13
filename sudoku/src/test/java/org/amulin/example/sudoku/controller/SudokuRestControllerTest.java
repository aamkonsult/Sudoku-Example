package org.amulin.example.sudoku.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-servlet.xml")
public class SudokuRestControllerTest {
	
	@Autowired
	private WebApplicationContext webAppContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
	}
			
	@Test
	public void sudokuRestAppContextTest() {
		Assert.assertNotNull(webAppContext);
		Assert.assertNotNull(mockMvc);
	}
		
	@Test
	public void incorrectRequestTest() throws Exception {
						
		mockMvc.perform(
				put("/sudoku/")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(bad_request))
					.andExpect(status().isBadRequest());
	}

	@Test
	public void conflictRequestTest() throws Exception {
						
		mockMvc.perform(
				put("/sudoku/")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(conflict_request))
					.andExpect(status().isConflict());
	}

	@Test
	public void okRequestTest() throws Exception {
						
		mockMvc.perform(
				put("/sudoku/")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(ok_request))
					.andExpect(status().isOk());
	}
	
	@Test
	public void secondTimeOkRequestTest() throws Exception {
						
		mockMvc.perform(
				put("/sudoku/")
					.contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(second_ok_request))
					.andExpect(status().isOk());
	}



	final String bad_request = 		"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":2,\"moveColumn\":1,\"moveValue\":10}";	
	final String conflict_request = "{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":2,\"moveColumn\":1,\"moveValue\":7}";	
	final String ok_request = 		"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":2,\"moveColumn\":1,\"moveValue\":1}";	
	final String second_ok_request = 		"{\"sudokuBoard\":[[7,0,0,0,4,0,5,3,9],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],\"moveRow\":2,\"moveColumn\":1,\"moveValue\":1}";	

	
}
