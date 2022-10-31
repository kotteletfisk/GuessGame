import java.util.Scanner;

public abstract class AHumanPlayer
{
	protected static final Scanner scanner = new Scanner(System.in);
	private String name;

	public AHumanPlayer()
	{
		name = null;
	}

	public void yourTurn()
	{
		//Clear the console
		for(int i = 0; i < 100; ++i)
		{
			System.out.println();
		}
		System.out.println(getName() + " it is now your turn.");
		System.out.println("Press ENTER when ready!");
		scanner.nextLine();
		//Clear the console
		for(int i = 0; i < 100; ++i)
		{
			System.out.println();
		}
	}

	public String getName()
	{
		if(name != null)
		{
			return name;
		}

		System.out.print(", please enter your name: ");
		name = scanner.nextLine();
		return name;
	}

	public void newGame(int min, int max, String opponent, String type)
	{
		System.out.println("A new game is about to start. You are the " + type +".");
		System.out.println("You are playing against " + opponent + ".");
		System.out.println("The range is from " + min + " to " + max + ".");
		if("thinker".equalsIgnoreCase(type))
		{
			System.out.println("Please think of a number in the range [" + min + ":" + max + "].");
		}
		System.out.println("Press ENTER when ready.");
		scanner.nextLine();
	}

	protected boolean playAgain()
	{
		System.out.print("Do you want to play again (y/n)? ");
		while(true)
		{
			String answer = scanner.nextLine();
			if ("y".equalsIgnoreCase(answer))
			{
				return true;
			}
			if ("n".equalsIgnoreCase(answer))
			{
				return false;
			}
			System.out.print("Try again: ");
		}
	}
}
