package commandProcessorWithDesignPattern;

public class Calculator implements ICalculator
{
	public Boolean undo(int n)
	{
		System.out.println("Proses Undo " + n);
		return true;
	}
	
	public Boolean redo(int n)
	{
		System.out.println("Proses Redo " + n);
		return true;
	}
	
	public Boolean showMem(int n)
	{
		System.out.println("Proses ShowMem " + n);
		return true;
	}
	
	public Boolean showAll()
	{
		System.out.println("Proses Show All");
		return true;
	}
	
	public Boolean save()
	{
		System.out.println("Proses Save");
		return true;
	}
	
	public Boolean calculate(String expression)
	{
		System.out.println("Hasil ekspresi, sebuah angka atau sebuah nilai boolean");
		return true;
	}
}