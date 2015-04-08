package Expression;
import java.util.Stack;

public class ExpressionConverter {

	static final int POSTFIKS_OPERATOR = 2;
	// konstanta untuk operator postfiks
	static final int INFIKS_OPERATOR = 1;
	// konstanta untuk operator infiks
	static final int PREFIKS_OPERATOR = 3;
	// konstanta untuk operator prefiks
	
	private int exp_type;
	// variabel tipe mode
	
	public ExpressionConverter() {
		
	}
	
	public boolean isOperator(char in)
	{
		if (in == '+') return true;
		if (in == '-') return true;
		if (in == '/') return true;
		if (in == '*') return true;
		if (in == '%') return true;
		if(in == '&') return true;
		if(in == '|') return true;
		if(in == '!') return true;
		if(in == '^') return true;
		if(in == '>') return true;
		if(in == '<') return true;
		if(in == '=') return true;
		return false;
	}

	void setExpType(String exp)
	{
		if (isOperator(exp.charAt(exp.length()-1))) exp_type = POSTFIKS_OPERATOR;
		else if (isOperator(exp.charAt(0))) exp_type = PREFIKS_OPERATOR;
		else exp_type = INFIKS_OPERATOR;
	}


	boolean isLeftBrace(char in)
	{
		if (in == '(') return true;
		else return false;
	}

	boolean isRightBrace(char in)
	{
		if (in == ')') return true;
		else return false;
	}

	public int OperatorPrecedence(char op) {
		switch (op) 
		{
			case '!' : return 8;
			case '*' : case '/' : case '%' : return 7;
			case '+' : case '-' : return 6;
			case '<' : case '>' : return 5;
			case '=' : return 4;
			case '&' : return 3;
			case '^' : return 2;
			case '|' : return 1;
			default : return 0;
		}
	}

	public String toPostfix(String expression) {
		StringBuilder postfix = new StringBuilder();
		expression = expression.trim();
		setExpType(expression);
		if (exp_type == POSTFIKS_OPERATOR)
		{
			StringBuilder oprnd = new StringBuilder();
			int mode = 1; // 1 : previous char is space , 0 : previous char is not space
			int nonspc = expression.length() - 1;
			for (int i = 0; i < expression.length(); i++)
			{
				if (expression.charAt(i) != ' ')
				{
					if (((isOperator(expression.charAt(i))) &&(expression.charAt(i) != '-')) || ((expression.charAt(i) == '-') && ((i == nonspc) || (expression.charAt(i+1) == ' '))))
					{
						if (oprnd.length() > 0)
						{
							oprnd.append(' ');
							postfix.append(oprnd);
							oprnd.delete(0,oprnd.length());
						}
						postfix.append(expression.charAt(i));
						if (i != nonspc)
						{
							postfix.append(' ');
						}
					}
					else
					{
						oprnd.append(expression.charAt(i));
					}
				}
				else
				{
					if (oprnd.length() > 0)
					{
						oprnd.append(' ');
						postfix.append(oprnd);
						oprnd.delete(0,oprnd.length());
					}
				}
			}
			return postfix.toString();
		}
		if (exp_type == PREFIKS_OPERATOR) 
		{
			Stack<String> S = new Stack<String>();
			StringBuilder oprnd = new StringBuilder();
			int mode = 0; // 1 : previous char is operand , 2 : previous char is operator or space
			int nonspc = 0; 
			for (int i = expression.length() - 1; i >= 0; i--)
			{
				if (expression.charAt(i) != ' ')
				{
					if (((isOperator(expression.charAt(i))) &&(expression.charAt(i) != '-')) || ((expression.charAt(i) == '-') && (i == nonspc || (expression.charAt(i+1) == ' '))))
					{
						if (oprnd.length() > 0)
						{
							oprnd.reverse();
							oprnd.append(' ');
							S.push(oprnd.toString());
							oprnd.delete(0, oprnd.length());
						}
						StringBuilder op1 = new StringBuilder();
						StringBuilder op2 = new StringBuilder();
						op1.append(S.pop());
						if (expression.charAt(i) != '!')
							op2.append(S.pop());
						op1.append(op2);
						op1.append(expression.charAt(i));
						if (i != nonspc)
						{
							op1.append(' ');
						}
						S.push(op1.toString());
					}
					else
					{
						oprnd.append(expression.charAt(i));
					}
				}
				else 
				{
					if (oprnd.length() > 0)
					{
						oprnd.reverse();
						oprnd.append(' ');
						S.push(oprnd.toString());
						oprnd.delete(0, oprnd.length());
					}
				}
			}
			postfix.append(S.pop());
		}
		else if (exp_type == INFIKS_OPERATOR) 
		{
			Stack<Character> S = new Stack<Character>();
			StringBuilder stemp = new StringBuilder();
			int mode = 0; // 1 : previous char is operand 
						  //2 : previous char is operator that has caused at least one operator has been popped from stack
			int opr = 1;
			for (int i = 0; i < expression.length(); i++)
			{
				if (isLeftBrace(expression.charAt(i)))
					S.push(expression.charAt(i));
				else if (isRightBrace(expression.charAt(i)))
				{
					if ((mode == 1) && (stemp.length() > 0))
					{
						postfix.append(stemp);
						postfix.append(' ');
						stemp.delete(0, stemp.length());
					}
					char op = '(';
					if (!S.empty())
						op = S.pop();
					while ((op != '(') && (!S.empty()))
					{
						if (mode != 1)
							postfix.append(' ');
						postfix.append(op);
						mode = 2;
						op = S.pop();
					}					
				}
				else if ((isOperator(expression.charAt(i))) && ((opr == 0) || (expression.charAt(i) == '!')))
				{
					opr = 1;
					char op;
					if ((mode == 1) && (stemp.length() > 0))
					{
						postfix.append(stemp);
						postfix.append(' ');
						stemp.delete(0, stemp.length());
					}
					if (!S.empty())
						op = S.peek();
					else
						op = ' ';
					if (isLeftBrace(op))
					{
						S.push(expression.charAt(i));
					}
					else 
					{
						while ((!S.empty()) && (OperatorPrecedence(op) >= OperatorPrecedence(expression.charAt(i))))
						{
							op = S.pop();
							if (mode != 1)
								postfix.append(' ');
							postfix.append(op);
							mode = 2;
							op = S.peek();
						}
						S.push(expression.charAt(i));
					}
				}
				else if (expression.charAt(i) != ' ')
				{
					if (mode == 2)
						postfix.append(' ');
					mode = 1;
					opr = 0;
					stemp.append(expression.charAt(i));
				}
			}
			if ((mode == 1) && (stemp.length() > 0))
			{
				postfix.append(stemp);
				postfix.append(' ');
			}
			while (!S.empty())
			{
				char op;
				op = S.pop();
				if (mode != 1)
					postfix.append(' ');
				postfix.append(op);
				mode = 2;
			}
		}
		return postfix.toString();
	}
}