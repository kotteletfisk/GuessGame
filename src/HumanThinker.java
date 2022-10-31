public class HumanThinker extends AHumanPlayer implements IThinker
{
	public Answer evaluateGuess(int guess, String opponent)
	{
		System.out.println(opponent + " guessed: " + guess);
		System.out.println("  1 - Too low");
		System.out.println("  2 - Too high");
		System.out.println("  3 - Correct");

		while(true)
		{
			System.out.print("Enter your answer (1, 2 or 3): ");
			String answer = scanner.nextLine();
			if("1".equals(answer))
			{
				return Answer.TOO_LOW;
			}
			if("2".equals(answer))
			{
				return Answer.TOO_HIGH;
			}
			if("3".equals(answer))
			{
				return Answer.CORRECT;
			}
		}
	}

	public boolean endOfGame(int numberOfGuesses, String opponent)
	{
		System.out.println("Game over.");
		String guesses = numberOfGuesses == 1 ? "guess" : "guesses";
		System.out.println(opponent + " used " + numberOfGuesses + " " + guesses + " to guess your secret number");
		return playAgain();
	}
}
