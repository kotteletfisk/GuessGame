import java.util.Random;

public class ComputerThinker implements IThinker
{
	private int secretNumber;

	public void yourTurn()
	{}

	public String getName()
	{
		return "Computer thinker";
	}

	public void newGame(int min, int max, String opponent, String type)
	{
		Random rnd = new Random();
		int range = max - min + 1;
		this.secretNumber = rnd.nextInt(range) + min;
	}

	public Answer evaluateGuess(int guess, String opponent)
	{
		if(guess < secretNumber)
		{
			return Answer.TOO_LOW;
		}
		if(guess > secretNumber)
		{
			return Answer.TOO_HIGH;
		}
		return Answer.CORRECT;
	}

	public boolean endOfGame(int numberOfGuesses, String opponent)
	{
		return true;
	}
}
