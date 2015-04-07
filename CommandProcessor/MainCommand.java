package CommandProcessor;
import java.util.*;
public class MainCommand {
	public static void main (String args[]) {
		Scanner scan = new Scanner(System.in);
		String ans;
		do {
			System.out.print("Masukan Command : ");
			String in = scan.nextLine();
			CommandReceiver.execute(in);
			System.out.println("Do you want to input a command again ? (Yes / No)");
			ans = scan.nextLine();
		} while (ans.equals("Yes"));	
	}
}