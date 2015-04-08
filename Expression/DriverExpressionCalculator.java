package Expression;
import java.util.*;
/**
 * DriverExpressionCalculator adalah kelas yang 
 * berfungsi sebagai driver dari package expression,
 * menerima input ekspresi dari user.
 * 
 * @author Edwin Wijaya
 * 
*/
public class DriverExpressionCalculator{
	/**
	 * method Main untuk menerima input ekspresi dan mencetak
	 * ke layar.
	 * @param -
	 * @see ExpressionCalculator#calculate(Object) calculate
	*/
	public static void main (String[] args){
		String expression = new Scanner(System.in).nextLine();
		System.out.println(ExpressionCalculator.calculate(expression));
	}
}