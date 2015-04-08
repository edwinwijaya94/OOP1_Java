package commandProcessorWithDesignPattern;

/**
 * The CommandInvoker class takes a Command and invoke the corresponding command
 * @author Elvan Owen
 */
public class CommandInvoker
{
	Command c;
	
	/**
	 * Constructor to initialize what command this invoker will invoke
	 * @param c  the command that will be invoked
	 */
	public CommandInvoker(Command c)
	{
		this.c = c;
	}
	
	/**
	 * This method will run the set command
	 */
	public void invoke()
	{
		c.execute();
	}
}