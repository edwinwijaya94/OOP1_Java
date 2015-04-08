package Expression;

import java.util.*;

public class ExpressionEvaluator
{
	private static Stack<Integer> st;
	
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
	
	
	public static int evaluate(String expression)
	{
		int opFlag = 0; // 0 : previous String is an operand , 1 : previous character is an operator 
		StringBuffer temp = new StringBuffer();
		for (int i=0;i<expression.length();i++)
		{
			// if current character is an operator but not a minus in a negative number (ie. -2)
			if (isOperator(expression.charAt(i)) && ((expression.charAt(i+1) == ' ') || (i+1 == expression.length())))
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