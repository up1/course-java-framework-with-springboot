package kbtg.tech.demo.controller.response;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class HelloResponseTest {

	@Test @Ignore
	public void Method_Input_Result() {
		// Arrange
		// Act
		// Assert
	} 
	
	@Test
	public void getMessage_Somkiat_HelloSomkiat() {
		// Arrange/Given 
		HelloResponse hr = new HelloResponse("somkiat");
		// Act/When
		String actualResult = hr.getMessage();
		// Assert/Then
		assertEquals("somkiat", actualResult);
	}
	
	@Test
	public void getMessage_Pui_HelloPui() {
		// Arrange/Given
		HelloResponse hr = new HelloResponse("pui");
		// Act/When
		String actualResult = hr.getMessage();
		// Assert/Then
		assertEquals("pui", actualResult);
	} 
	
	@Test
	public void getMessage_XXX_HelloXXX() {
		// Arrange/Given
		HelloResponse hr = new HelloResponse();
		hr.setMessage("xxx");
		// Act/When
		String actualResult = hr.getMessage();
		// Assert/Then
		assertEquals("xxx", actualResult);
	}

}
