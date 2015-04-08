package commandProcessorWithoutDesignPattern;
/* File Name : CommandReceiver.java */
import java.util.*;

public class CommandReceiver {
	/** 
	@param n adalah banyaknya perintah yang akan ditampilkan
	@I.S. n merupakan masukan dari user
	@F.S. mengeluarkan tulisan "Proses ShowMem n"
	*/
	public static void showMem(int n) {
		System.out.println("Proses ShowMem " + n);
	}
	/** 
	@prosedur mengeluarkan tulisan "Proses ShowMem All"
	*/
	public static void showAll() {
		System.out.println("Proses Show All");
	}
	/** 
	@prosedur mengeluarkan tulisan "Proses Save "
	*/
	public static void save() {
		System.out.println("Proses Save");
	}
	/** 
	@param n adalah banyaknya perintah dari user
	@I.S. n merupakan masukan dari user
	@F.S. mengeluarkan tulisan "Proses Undo n"
	*/
	public static void undo (int n) {
		System.out.println("Proses Undo " + n);
	}
	/** 
	@param n adalah banyaknya perintah dari user
	@I.S. n merupakan masukan dari user
	@F.S. mengeluarkan tulisan "Proses Redo n"
	*/
	public static void redo (int n) {
		System.out.println("Proses Redo " + n);
	}
	/** 
	@prosedur mengeluarkan tulisan "Hasil ekspresi, sebuah angka atau sebuah nilai boolean"
	*/
	public static void expression() {
		System.out.println("Hasil ekspresi, sebuah angka atau sebuah nilai boolean");
	}
	/** 
	@param in adalah command masukan
	@I.S. in merupakan masukan dari user
	@F.S. menjalankan command yang dimasukan
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