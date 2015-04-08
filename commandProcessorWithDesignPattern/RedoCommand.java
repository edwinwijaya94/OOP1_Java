package commandProcessorWithDesignPattern;

/**
 * The RedoCommand class redo command in a calculator
 * @author Elvan Owen
 */
public class RedoCommand implements Command
{
	private ICalculator calculator;
	private int n = 1;
	
	/**
	 * Constructor to initialize the number of redos and the calculator to run RedoCommand
	 * @param calculator  calculator object which will be used to calculate
	 * @param n  the number of redo to be done by this command
	 */
	public RedoCommand(ICalculator calculator, int n)
	{
		this.calculator = calculator;
		this.n = n;
	}
	
	/**
	 * Constructor to initialize the number of redos and the calculator to run RedoCommand
	 * @param calculator  calculator object which will be used to calculate
	 */
	public RedoCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	/**
	 * This method will execute the given command using the given calculator
	 */
	public void execute()
	{
		calculator.redo(n);
	}
	
}