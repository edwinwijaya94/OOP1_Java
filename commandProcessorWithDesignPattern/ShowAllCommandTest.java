package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.*;
import java.io.*;
import java.util.*;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ShowAllCommandTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private String expectedResult;
	
	public ShowAllCommandTest(String expectedResult)
	{
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { "Proses Show All" },
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
	public void testShowAll() {
		ICalculator calculatorTester = new Calculator();
		ShowAllCommand tester = new ShowAllCommand(calculatorTester);
		
		tester.execute();
		assertEquals(expectedResult,outContent.toString().trim());
	}

}