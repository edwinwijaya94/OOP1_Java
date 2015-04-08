package commandProcessorWithDesignPattern;

/**
 * The Command Interface makes sure every subclasses of Command have their own execute instructions
 * @author Elvan Owen
 */
public interface Command {
	public abstract void execute();
}