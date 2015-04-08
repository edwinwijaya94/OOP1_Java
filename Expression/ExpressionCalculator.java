package Expression;

public class ExpressionCalculator{
	
	public static int calculate(String expression){
		ExpressionConverter ec = new ExpressionConverter();
		System.out.println(ec.toPostfix(expression));
		//return ExpressionEvaluator.evaluate(ec.toPostfix(expression));
		return 0;
	}
}