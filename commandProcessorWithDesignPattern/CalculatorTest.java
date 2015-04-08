package commandProcessorWithDesignPattern;

import static org.junit.Assert.*;

import org.junit.*;

import java.io.*;

public class CalculatorTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	ICalculator c = new Calculator();
	
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
		int n = 10;
		c.undo(n);
		
		assertEquals("Proses Undo " + n, outContent.toString().trim());
	}
	
	@Test
	public void testRedo() {
		int n = 10;
		c.redo(n);
		
		assertEquals("Proses Redo " + n, outContent.toString().trim());
	}
	
	@Test
	public void testShowMem() {
		int n = 10;
		c.showMem(n);
		
		assertEquals("Proses ShowMem " + n, outContent.toString().trim());
	}
	
	@Test
	public void testSave() {
		c.save();
		
		assertEquals("Proses Save", outContent.toString().trim());
	}
	
	@Test
	public void testShowAll() {
		c.showAll();
		
		assertEquals("Proses Show All", outContent.toString().trim());
	}
	
	@Test
	public void testCalculate() {
		String expression = "> 5 3";
		c.calculate(expression);
		
		assertEquals("Hasil ekspresi, sebuah angka atau sebuah nilai boolean", outContent.toString().trim());
	}

}
