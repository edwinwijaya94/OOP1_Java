package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.*;
import java.io.*;
import java.util.*;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class UndoCommandTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private int inputNumber;
	private String expectedResult;
	
	public UndoCommandTest(int inputNumber, String expectedResult)
	{
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { 2, "Proses Undo 2" },
		         { 6, "Proses Undo 6" },
		         { 19, "Proses Undo 19" },
		         { 22, "Proses Undo 22" },
		         { 23, "Proses Undo 23" }
		      });
	}
	
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
	public void testUndo() {
		ICalculator calculatorTester = new Calculator();
		UndoCommand tester = new UndoCommand(calculatorTester,inputNumber);
		
		tester.execute();
		assertEquals(expectedResult,outContent.toString().trim());
	}

}