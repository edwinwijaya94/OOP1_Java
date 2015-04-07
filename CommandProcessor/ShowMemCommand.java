package commandProcessor;

public class ShowMemCommand implements Command
{
	private ICalculator calculator;
	private int n = 1;
	
	public ShowMemCommand(ICalculator calculator, int n)
	{
		this.calculator = calculator;
		this.n = n;
	}
	
	public ShowMemCommand(ICalculator calculator)
	{
		this.calculator = calculator;
	}
		
	public void execute()
	{
		calculator.showMem(n);
	}	
}