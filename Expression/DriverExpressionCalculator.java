package Expression;
import java.util.*;
public class DriverExpressionCalculator{
	public static void main (String[] args){
		String expression = new Scanner(System.in).nextLine();		;
		System.out.println(ExpressionCalculator.calculate(expression));
	}
}