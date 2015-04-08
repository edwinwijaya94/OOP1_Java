package commandProcessorWithDesignPattern;

public class SaveCommand implements Command
{
	private ICalculator calculator;
	
	public SaveCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	public void execute()
	{
		calculator.save();
	}	
}