import java.util.InputMismatchException;

public class HumanGuesser extends AHumanPlayer implements IGuesser
{
	public int makeGuess()
	{
		System.out.print("Please make a guess: ");
		//This loop
		while(true)
		{
			try
			{
				int guess = scanner.nextInt();
				scanner.nextLine();
				return guess;
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please try again: ");
			}
		}
	}

	public void guessFeedback(Answer answer)
	{
		System.out.print("Your guess was ");
		switch(answer)
		{
			case TOO_LOW:
				System.out.println("too low.");
				break;
			case TOO_HIGH:
				System.out.println("too high.");
				break;
			case CORRECT:
				System.out.println("correct.");
				break;
			default:
				throw new RuntimeException("This should never happen!");
		}
		System.out.println("Press ENTER when ready.");
		scanner.nextLine();
	}

	public boolean endOfGame(int numberOfGuesses, String opponent)
	{
		System.out.println("Game over.");
		String guesses = numberOfGuesses == 1 ? "guess" : "guesses";
		System.out.println("You used " + numberOfGuesses + " " + guesses + " to guess "
				+ opponent + "'s secret number.");
		return playAgain();
	}

}
