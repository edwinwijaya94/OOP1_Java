package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ShowMemCommandTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private int inputNumber;
	private String expectedResult;
	
	public ShowMemCommandTest(int inputNumber, String expectedResult)
	{
		this.inputNumber = inputNumber;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { 2, "Proses ShowMem 2" },
		         { 6, "Proses ShowMem 6" },
		         { 19, "Proses ShowMem 19" },
		         { 22, "Proses ShowMem 22" },
		         { 23, "Proses ShowMem 23" }
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
	public void testShowMem() {
		ICalculator calculatorTester = new Calculator();
		ShowMemCommand tester = new ShowMemCommand(calculatorTester,inputNumber);
		
		tester.execute();
		assertEquals(expectedResult,outContent.toString().trim());
	}

}