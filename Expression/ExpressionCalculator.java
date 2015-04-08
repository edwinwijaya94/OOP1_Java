package Expression;

public class ExpressionCalculator{
	
	public static int calculate(String expression){
		ExpressionConverter ec = new ExpressionConverter();
		return ExpressionEvaluator.evaluate(ec.toPostfix(expression));
	}
}