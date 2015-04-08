package commandProcessorWithDesignPattern;

public class ShowAllCommand implements Command
{
	private ICalculator calculator;
	
	public ShowAllCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	public void execute()
	{
		calculator.showAll();
	}
	
}