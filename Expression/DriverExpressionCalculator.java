package Expression;
import java.util.*;
/**
 * DriverExpressionCalculator acts as a driver for 
 * package "expression"
 * 
 * @author Edwin Wijaya
 * 
*/
public class DriverExpressionCalculator{
	/**
	 * receives an expression then calculate it and output the result
	 * @param args unused, no explanation
	 * @see ExpressionCalculator#calculate(Object) calculate
	*/
	public static void main (String[] args){
		String expression = new Scanner(System.in).nextLine();
		System.out.println(ExpressionCalculator.calculate(expression));
	}
}