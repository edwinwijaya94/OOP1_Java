package commandProcessorWithoutDesignPattern;
import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;

/**
 * @author Jessica
 *
 */
public class CommandReceiverTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void testUndo() {
		CommandReceiver.execute("Undo 5");
		
		assertEquals("Proses Undo " + 5, outContent.toString().trim());
	}
	
	@Test
	public void testRedo() {
		CommandReceiver.execute("Redo 3");
		
		assertEquals("Proses Redo " + 3, outContent.toString().trim());
	}
	
	@Test
	public void testShowMem() {
		CommandReceiver.execute("ShowMem 2");
		
		assertEquals("Proses ShowMem " + 2, outContent.toString().trim());
	}
	
	@Test
	public void testSave() {
		CommandReceiver.execute("Save");
		
		assertEquals("Proses Save", outContent.toString().trim());
	}
	
	@Test
	public void testShowAll() {
		CommandReceiver.execute("Show All");
		
		assertEquals("Proses Show All", outContent.toString().trim());
	}
	
	@Test
	public void testCalculate() {
		CommandReceiver.execute("1 2 +");
		
		assertEquals("Hasil ekspresi, sebuah angka atau sebuah nilai boolean", outContent.toString().trim());
	}
}
