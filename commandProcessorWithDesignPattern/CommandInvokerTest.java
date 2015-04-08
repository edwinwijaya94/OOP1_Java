package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;

import org.junit.*;

import java.io.*;

public class CommandInvokerTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	String expression = "> 5 3";
	int n = 10;
	ICalculator c = new Calculator();
	Command calculateCommand = new CalculateCommand(c, expression);
	Command undoCommand = new UndoCommand(c,n);
	Command redoCommand = new RedoCommand(c,n);
	Command showMemCommand = new ShowMemCommand(c,n);
	Command showAllCommand = new ShowAllCommand(c);
	Command saveCommand = new SaveCommand(c);
	CommandInvoker CalculateInvoker = new CommandInvoker(calculateCommand);
	CommandInvoker UndoInvoker = new CommandInvoker(undoCommand);
	CommandInvoker RedoInvoker = new CommandInvoker(redoCommand);
	CommandInvoker ShowMemInvoker = new CommandInvoker(showMemCommand);
	CommandInvoker ShowAllInvoker = new CommandInvoker(showAllCommand);
	CommandInvoker SaveInvoker = new CommandInvoker(saveCommand);
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void testCalculateInvoker() {
		calculateCommand.execute();
		String expectedResult = outContent.toString().trim();
		outContent.reset();
		CalculateInvoker.invoke();
		
		assertEquals(expectedResult,outContent.toString().trim());
	}
	
	@Test
	public void testUndoInvoker()
	{
		undoCommand.execute();
		String expectedResult = outContent.toString().trim();
		outContent.reset();
		UndoInvoker.invoke();
		
		assertEquals(expectedResult,outContent.toString().trim());
	}
	
	@Test
	public void testRedoInvoker()
	{
		redoCommand.execute();
		String expectedResult = outContent.toString().trim();
		outContent.reset();
		RedoInvoker.invoke();
		
		assertEquals(expectedResult,outContent.toString().trim());
	}
	
	@Test
	public void testShowMemInvoker()
	{
		showMemCommand.execute();
		String expectedResult = outContent.toString().trim();
		outContent.reset();
		ShowMemInvoker.invoke();
		
		assertEquals(expectedResult,outContent.toString().trim());
	}
	
	@Test
	public void testShowAllInvoker()
	{
		showAllCommand.execute();
		String expectedResult = outContent.toString().trim();
		outContent.reset();
		ShowAllInvoker.invoke();
		
		assertEquals(expectedResult,outContent.toString().trim());
	}
	
	@Test
	public void testSaveInvoker()
	{
		saveCommand.execute();
		String expectedResult = outContent.toString().trim();
		outContent.reset();
		SaveInvoker.invoke();
		
		assertEquals(expectedResult,outContent.toString().trim());
	}
}
