package commandProcessorWithDesignPattern;

/**
 * The UndoCommand class undo one or more command refer to command history
 * @author Elvan Owen
 */
public class UndoCommand implements Command
{
	private ICalculator calculator;
	private int n = 1;
	
	/**
	 * Constructor to initialize the calculator to run UndoCommand
	 * @param calculator  calculator object which will be used to calculate
	 * @param n define how many UndoCommand will be done
	 */
	public UndoCommand(ICalculator calculator, int n)
	{
		this.calculator = calculator;
		this.n = n;
	}
	
	/**
	 * Constructor to initialize the calculator to run UndoCommand
	 * @param calculator  calculator object which will be used to calculate
	 */
	public UndoCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	/**
	 * This method will execute the given command using the given calculator
	 */
	public void execute()
	{
		calculator.undo(n);
	}
	
}