package commandProcessor;

public class CommandInvoker
{
	Command c;
	
	public CommandInvoker(Command c)
	{
		this.c = c;
	}
	
	public void invoke()
	{
		c.execute();
	}
}