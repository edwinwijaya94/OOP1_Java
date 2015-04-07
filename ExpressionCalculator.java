package Expression

public class ExpressionEvaluator{
	
	public ExpressionEvaluator(){
		
	}
	public static int calculate(){
		return evaluate(toPostfix(expression));
	}
	public static void main (String[] args){
		private static String expression;
		System.out.println(calculate());
	}
}