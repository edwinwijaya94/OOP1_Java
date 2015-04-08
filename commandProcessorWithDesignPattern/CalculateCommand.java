package commandProcessorWithDesignPattern;

public class CalculateCommand implements Command
{
	private ICalculator calculator;
	private String expression;
	
	public CalculateCommand(ICalculator calculator,String expression)
	{
		this.calculator = calculator;
		this.expression = expression;
	}
	
	public void execute()
	{
		calculator.calculate(expression);
	}
	
}