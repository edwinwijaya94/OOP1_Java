package commandProcessorWithDesignPattern;

/**
 * The ShowAllCommand class shows all expression history and command history
 * @author Elvan Owen
 */
public class ShowAllCommand implements Command
{
	private ICalculator calculator;
	
	/**
	 * Constructor to initialize the calculator to run ShowAllCommand
	 * @param calculator  calculator object which will be used to calculate
	 */
	public ShowAllCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	/**
	 * This method will execute the given command using the given calculator
	 */
	public void execute()
	{
		calculator.showAll();
	}
	
}