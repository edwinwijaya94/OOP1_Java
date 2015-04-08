package commandProcessorWithoutDesignPattern;
import java.util.*;

/**
 * MainCommand is a driver to test the 
 * commandProcessorWithoutDesignPattern package
 * @author Jessica Andjani
*/
public class Main {
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