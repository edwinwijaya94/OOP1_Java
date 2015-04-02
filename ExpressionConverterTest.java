import java.util.Scanner;

class ExpressionConverterTest {
	public static void main(String args[]) {
		ExpressionConverter e = new ExpressionConverter();
		String exp = new String();
		Scanner sc = new Scanner(System.in);
		exp = sc.nextLine();
		String out = e.toPostfix(exp);
		System.out.println(out);
	}
}