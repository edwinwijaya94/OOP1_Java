package commandProcessorWithoutDesignPattern;
/* File Name : CommandReceiver.java */
import java.util.*;
/**
 * CommandReceiver receives user input command and execute the
 * appropriate command
 * @author Jessica Andjani 
*/
public class CommandReceiver {
	
	/** 
	* I.S. n is user's input
	* F.S. output "Proses ShowMem n"
	* @param n define how many commands and expression will be shown
	*/
	public static void showMem(int n) {
		System.out.println("Proses ShowMem " + n);
	}
	
	/** 
	* procedure to output "Proses ShowMem All"
	*/
	public static void showAll() {
		System.out.println("Proses Show All");
	}
	
	/** 
	* procedure to output "Proses Save "
	*/
	public static void save() {
		System.out.println("Proses Save");
	}
	
	/** 
	* I.S. n is user's input
	* F.S. output "Proses Undo n"
	* @param n define how many undo command(s) will be done
	*/
	public static void undo (int n) {
		System.out.println("Proses Undo " + n);
	}
	
	/** 
	* I.S. n is user's input
	* F.S. output "Proses Redo n"
	*@param n define how many redo command(s) will be done
	*/
	public static void redo (int n) {
		System.out.println("Proses Redo " + n);
	}
	
	/** 
	* procedure to output "Hasil ekspresi, sebuah angka atau sebuah nilai boolean"
	*/
	public static void expression() {
		System.out.println("Hasil ekspresi, sebuah angka atau sebuah nilai boolean");
	}
	
	/** 
	* I.S. in is user's input
	* F.S. run the  appropriate command
	* @param in user's input command
	*/
	public static void execute(String in) {
		int n;
		Scanner scanner = new Scanner(in);
		String input = scanner.next();
		if (input.equals("ShowMem")){
			n = scanner.nextInt();
			showMem(n);
		}
		else if (in.equals("Show All")) {
			showAll();
		}
		else if (in.equals("Save")) {
			save();
		}
		else if (input.equals("Undo") ) {
			n = scanner.nextInt();
			undo(n);
		}
		else if (input.equals("Redo") ) {
			n = scanner.nextInt();
			redo(n);
		}
		else {
			expression();
		}
			
	}
}	