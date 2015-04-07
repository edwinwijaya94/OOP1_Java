package commandProcessor;

public class CalculateCommand implements Command
{
	private ICalculator calculator;
	
	public CalculateCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	public void execute()
	{
		calculator.calculate();
	}
	
}