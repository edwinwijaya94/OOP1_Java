package commandProcessorWithDesignPattern;

/**
 * The ShowMemCommand class shows a number of expression history and command history
 * @author Elvan Owen
 */
public class ShowMemCommand implements Command
{
	private ICalculator calculator;
	private int n = 1;
	
	/**
	 * Constructor to initialize the calculator to run ShowMemCommand
	 * @param calculator  calculator object which will be used to calculate
	 * @param n define how many expression history and command history will be shown
	 */
	public ShowMemCommand(ICalculator calculator, int n)
	{
		this.calculator = calculator;
		this.n = n;
	}
	
	/**
	 * Constructor to initialize the calculator to run ShowMemCommand
	 * @param calculator  calculator object which will be used to calculate
	 */
	public ShowMemCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
		
	/**
	 * This method will execute the given command using the given calculator
	 */
	public void execute()
	{
		calculator.showMem(n);
	}	
}