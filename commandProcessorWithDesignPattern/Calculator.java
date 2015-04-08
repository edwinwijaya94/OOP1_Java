package commandProcessorWithDesignPattern;

/**
 * The Calculator class implements ICalculator and define its way to implements the interface
 * @author Elvan Owen
 */
public class Calculator implements ICalculator
{
	/**
	 * This method will undo n last commands in this calculator
	 * @param n  the number of undo to be done
	 * @return Boolean  indicating whether the action completed successfully
	 */
	public Boolean undo(int n)
	{
		System.out.println("Proses Undo " + n);
		return true;
	}
	
	/**
	 * This method will redo n last commands in this calculator
	 * @param n  the number of redo to be done
	 * @return Boolean  indicating whether the action completed successfully
	 */
	public Boolean redo(int n)
	{
		System.out.println("Proses Redo " + n);
		return true;
	}
	
	/**
	 * This method will show n last commands in this calculator
	 * @param n  the number of memory to be shown
	 * @return Boolean  indicating whether the action completed successfully
	 */
	public Boolean showMem(int n)
	{
		System.out.println("Proses ShowMem " + n);
		return true;
	}
	
	/**
	 * This method will show all entered commands in this calculator
	 * @return Boolean  indicating whether the action completed successfully
	 */
	public Boolean showAll()
	{
		System.out.println("Proses Show All");
		return true;
	}
	
	/**
	 * This method will save all user input
	 * @return Boolean  indicating whether the action completed successfully
	 */
	public Boolean save()
	{
		System.out.println("Proses Save");
		return true;
	}
	
	/**
	 * This method will calculate given expression
	 * @param expression  the expression to be calculated
	 * @return Boolean  indicating whether the action completed successfully
	 */
	public Boolean calculate(String expression)
	{
		System.out.println("Hasil ekspresi, sebuah angka atau sebuah nilai boolean");
		return true;
	}
}