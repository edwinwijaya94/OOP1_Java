package Expression;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.runners.*;
import java.io.*;
import java.util.*;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class ExpressionEvaluatorTest {
	
	private String expression;
	private String expectedResult;
	
	public ExpressionEvaluatorTest(String expression, String expectedResult)
	{
		this.expression = expression;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { "3 4 +", "7" },
		         { "5 6 7 * +", "47" },
		         { "3 5 - 6 -10 + >", "1" },
		         { "3 -5 -3 * -", "-12" },
		         { "3 4 < 1 ! &", "0" }
		      });
	}
	
	@Test
	public void test() {
		assertEquals(ExpressionEvaluator.evaluate(expression) + "",expectedResult);
	}

}
