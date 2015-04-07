package commandProcessor;

public class RedoCommand implements Command
{
	private ICalculator calculator;
	private int n = 1;
	
	public RedoCommand(ICalculator calculator, int n)
	{
		this.calculator = calculator;
		this.n = n;
	}
	
	public RedoCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	public void execute()
	{
		calculator.redo(n);
	}
	
}