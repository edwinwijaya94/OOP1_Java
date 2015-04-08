package commandProcessorWithDesignPattern;

/**
 * The CalculateCommand class calculates a given expression
 * @author Elvan Owen
 */
public class CalculateCommand implements Command
{
	private ICalculator calculator;
	private String expression;
	
	/**
	 * Constructor to initialize the expression and the calculator to run CalculateCommand
	 * @param calculator  calculator object which will be used to calculate
	 * @param expression  expression that is going to be calculated
	 */
	public CalculateCommand(ICalculator calculator,String expression)
	{
		this.calculator = calculator;
		this.expression = expression;
	}
	
	/**
	 * This method will execute the given command using the given calculator
	 */
	public void execute()
	{
		calculator.calculate(expression);
	}
	
}