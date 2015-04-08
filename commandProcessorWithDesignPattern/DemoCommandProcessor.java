package commandProcessorWithDesignPattern;
import java.util.*;
import java.util.regex.*;

/**
 * DemoCommandProcessor class simulates how to use all of the classes in the commandProcessorWithDesignPattern package
 * @author Elvan Owen
 */
public class DemoCommandProcessor
{
	public static void main(String[] args)
	{
		int n = 1; // set default
		Calculator c = new Calculator();
		
		// Get input from Console
		Scanner sc = new Scanner(System.in);
		String userinput = sc.nextLine();
		
		// Check if input is an expression
		String line = userinput;
		String pattern = "[%+*-/><=()]|and|or|xor|div|mod|not|true|false";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(line);
		
		// If expression
		if (m.find( ))
		{
			CommandInvoker CalculateInvoker = new CommandInvoker(new CalculateCommand(c, userinput));
			CalculateInvoker.invoke();
		}
		else
		{
			// Parse input
			Scanner sc2 = new Scanner(userinput);
			String firstword = sc2.next();
			if (sc2.hasNext() == true && !firstword.equals("Show")) { n = sc2.nextInt(); }
		
			CommandInvoker UndoInvoker = new CommandInvoker(new UndoCommand(c,n));
			CommandInvoker RedoInvoker = new CommandInvoker(new RedoCommand(c,n));
			CommandInvoker ShowMemInvoker = new CommandInvoker(new ShowMemCommand(c,n));
			CommandInvoker ShowAllInvoker = new CommandInvoker(new ShowAllCommand(c));
			CommandInvoker SaveInvoker = new CommandInvoker(new SaveCommand(c));
		
			if (firstword.equals("Undo")) 
			{
				UndoInvoker.invoke();
			}
			else if (firstword.equals("Redo")) 
			{
				RedoInvoker.invoke();
			}
			else if (firstword.equals("ShowMem")) 
			{
				ShowMemInvoker.invoke();
			}
			else if (firstword.equals("Save")) 
			{
				SaveInvoker.invoke();
			}
			else if (userinput.equals("Show All")) 
			{
				ShowAllInvoker.invoke();
			}
		}	
	}
}