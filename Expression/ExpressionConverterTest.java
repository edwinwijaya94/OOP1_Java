package Expression;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ExpressionConverterTest {

	private String expression;
	private String expectedResult;
	ExpressionConverter ec = new ExpressionConverter();
	
	public ExpressionConverterTest(String expression, String expectedResult)
	{
		this.expression = expression;
		this.expectedResult = expectedResult;
	}
	
	@Parameterized.Parameters
	public static Collection examples() {
		return Arrays.asList(new Object[][] {
		         { "(3 + 5)", "3 5 +" },
		         { "(3<4)", "3 4 <" },
		         { "((10 - -5) * ((-4 * 3) + (2 * -7)))", "10 -5 - -4 3 * 2 -7 * + *" },
		         { "((-5 - -5) - -5)", "-5 -5 - -5 -" },
		         { "(0 - 3 * 0)", "0 3 0 * -" }
		      });
	}
	
	@Test
	public void test() {
		
		assertEquals(ec.toPostfix(expression),expectedResult);
	}


}
