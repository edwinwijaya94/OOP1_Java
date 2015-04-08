package commandProcessorWithDesignPattern;

/**
 * The SaveCommand class save expression history and command history to an external file
 * @author Elvan Owen
 */
public class SaveCommand implements Command
{
	
	private ICalculator calculator;
	
	/**
	 * Constructor to initialize the calculator to run SaveCommand
	 * @param calculator  calculator object which will be used to calculate
	 */
	public SaveCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	/**
	 * This method will execute the given command using the given calculator
	 */
	public void execute()
	{
		calculator.save();
	}	
}