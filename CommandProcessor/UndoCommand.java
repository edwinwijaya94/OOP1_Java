package commandProcessor;

public class UndoCommand implements Command
{
	private ICalculator calculator;
	private int n = 1;
	
	public UndoCommand(ICalculator calculator, int n)
	{
		this.calculator = calculator;
		this.n = n;
	}
	
	public UndoCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
	
	public void execute()
	{
		calculator.undo(n);
	}
	
}