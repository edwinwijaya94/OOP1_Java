package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.*;
import java.io.*;
import java.util.*;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class CalculateCommandTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private String expectedResult;
	private String inputExpression;
	
	public CalculateCommandTest(String inputExpression, String expectedResult)
	{
		this.expectedResult = expectedResult;
		this.inputExpression = inputExpression;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { "(3*6)", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "+ 5 3", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "3 6 *", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "and true false", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "(true and false)", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean"},
		         { "true false and", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "< 3 5", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "(3<4)", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
		         { "3 4 >", "Hasil ekspresi, sebuah angka atau sebuah nilai boolean" },
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
	public void testCalculate() {
		ICalculator calculatorTester = new Calculator();
		CalculateCommand tester = new CalculateCommand(calculatorTester, inputExpression);
		
		tester.execute();
		assertEquals(expectedResult,outContent.toString().trim());
	}

}