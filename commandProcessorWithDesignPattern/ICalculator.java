package commandProcessorWithDesignPattern;

public interface ICalculator
{
	public Boolean undo(int n);
	public Boolean redo(int n);
	public Boolean showMem(int n);
	public Boolean save();
	public Boolean showAll();
	public Boolean calculate(String expression);
}