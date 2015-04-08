package commandProcessorWithDesignPattern;

/**
 * ICalculator interface makes sure that every calculator that implements it have basic
 * functionality such as undo, redo, save, etc.
 * @author Elvan Owen
 */
public interface ICalculator
{
	public Boolean undo(int n);
	public Boolean redo(int n);
	public Boolean showMem(int n);
	public Boolean save();
	public Boolean showAll();
	public Boolean calculate(String expression);
}