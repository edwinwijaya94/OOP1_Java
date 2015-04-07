package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.*;
import java.io.*;
import java.util.*;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class RedoCommandTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private int inputNumber;
	private String expectedResult;
	
	public RedoCommandTest(int inputNumber, String expectedResult)
	{
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { 2, "Proses Redo 2" },
		         { 6, "Proses Redo 6" },
		         { 19, "Proses Redo 19" },
		         { 22, "Proses Redo 22" },
		         { 23, "Proses Redo 23" }
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
	public void testRedo() {
		ICalculator calculatorTester = new Calculator();
		RedoCommand tester = new RedoCommand(calculatorTester,inputNumber);
		
		tester.execute();
		assertEquals(expectedResult,outContent.toString().trim());
	}

}