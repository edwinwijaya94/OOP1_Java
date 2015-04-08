package Expression;

import java.util.*;

/**
 * @author Elvan Owen and Edwin Wijaya
 *
 * The ExpressionEvaluator class calculates a given
 * postfix expression and returns the result
 */
public class ExpressionEvaluator
{	
	/**
	 * Checks if a character is an operator
	 * @param in  the character to be checked
	 * @return Boolean
	 */
	private static Boolean isOperator(char in)
	{
		if (in == '+') return true;
		if (in == '-') return true;
		if (in == '/') return true;
		if (in == '*') return true;
		if (in == '%') return true;
		if (in == '&') return true;
		if (in == '|') return true;
		if (in == '!') return true;
		if (in == '^') return true;
		if (in == '>') return true;
		if (in == '<') return true;
		if (in == '=') return true;
		// if not an operator
		return false;
	}
	
	/**
	 * Evaluate postfix-expression and returns the result in integer
	 * @param expression  the expression in postfix to be evaluated
	 * @return Integer
	 */
	public static int evaluate(String expression)
	{
		/**
		 * Flag to specify previous character
		 * 0 : previous String is an operand
		 * 1 : previous character is an operator 
		 */
		int opFlag = 0;
		
		/**
		 * Stack used to calculate postfix expression by holding numbers from the expression
		 * 0 : previous String is an operand
		 * 1 : previous character is an operator 
		 */
		Stack<Integer> st = new Stack<Integer>();
		
		/**
		 * String used to hold partial numbers while parsing and calculating the expression 
		 */
		StringBuffer temp = new StringBuffer();
		
		for (int i=0;i<expression.length();i++)
		{
			// if current character is an operator but not a minus in a negative number (ie. -2)
			if (isOperator(expression.charAt(i)) && ((i+1 == expression.length()) || (expression.charAt(i+1) == ' ')))
			{
				opFlag = 1; // setting to 1 : previous character is an operator 
				int a,b; // temporary variable to hold two operands 
				// second operand
				a = st.pop();
				// first operand
				b = st.pop();
				
				switch(expression.charAt(i)){
					case '&': st.push( ((a!=0) && (b!=0)) ? 1 : 0 ); break;
					case '|': st.push( ((a!=0) || (b!=0)) ? 1 : 0 ); break;
					case '!': st.push( (!(a!=0)) ? 1 : 0 ); break;
					case '^': st.push( ((a!=0) ^ (b!=0)) ? 1 : 0 ); break;
					case '>': st.push( (b > a) ? 1 : 0 );break;
					case '<': st.push( (b < a) ? 1 : 0 );break;
					case '=': st.push( (a == b) ? 1 : 0 );break;
					case '+': st.push(a + b); break;
					case '-': st.push(b - a);break;
					case '/': st.push(b / a);break;
					case '*': st.push(a * b);break;
					case '%': st.push(b % a);break;
				}
				
			}else if (expression.charAt(i) == ' ')
			{
				// if previous String is an operand, it needs to be pushed to stack
				if (opFlag == 0){
					int xx = Integer.parseInt(temp.toString());
					st.push(xx);
					temp.setLength(0);
				}
			}
			else
			{
				// buffering current operand
				temp.append(expression.charAt(i));
				opFlag = 0; // setting to 0 : previous String is an operand
			}
		}
	
		// reach end of line and there is still operand left
		if (temp.length() != 0)
		{
			int xx = Integer.parseInt(temp.toString());
			st.push(xx);
			temp.setLength(0);
		}
	
		int tt = st.pop(); // temporary variable to hold result values
		
		// returning values of an expression
		return tt;
	}
}