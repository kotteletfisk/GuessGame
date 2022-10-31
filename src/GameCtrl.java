import java.util.Scanner;

public class GameCtrl
{
	private static final Scanner scanner = new Scanner(System.in);
	private final int min;
	private final int max;

	public GameCtrl(int min, int max)
	{
		this.min = min;
		this.max = max;
	}

	public void runGame(IThinker thinker, IGuesser guesser)
	{
		System.out.print("Thinker");
		String thinkerName = thinker.getName();
		System.out.print("Guesser");
		String guesserName = guesser.getName();

		boolean thinkerPlayAgain;
		boolean guesserPlayAgain;
		do
		{
			//Thinker start game
			thinker.yourTurn();
			thinker.newGame(min, max, guesserName, "Thinker");
			//Guesser start game
			guesser.yourTurn();
			guesser.newGame(min, max, thinkerName, "Guesser");

			//game main loop
			Answer answer;
			int numberOfGuesses = 0;
			do
			{
				int guess = guesser.makeGuess();
				++numberOfGuesses;
				thinker.yourTurn();
				answer = thinker.evaluateGuess(guess, guesserName);
				guesser.yourTurn();
				guesser.guessFeedback(answer);
			} while (answer != Answer.CORRECT);

			guesserPlayAgain = guesser.endOfGame(numberOfGuesses, thinkerName);
			thinker.yourTurn();
			thinkerPlayAgain = thinker.endOfGame(numberOfGuesses, guesserName);

			String guesses = numberOfGuesses == 1 ? " guess " : " guesses ";
			System.out.println("End of game! " + numberOfGuesses + guesses + "was used!");
		} while (thinkerPlayAgain && guesserPlayAgain);
		System.out.println("Goodbye!");
	}

	public static int chooseType(String s)
	{
		System.out.println("What kind of " + s + " do you want?");
		System.out.println("  1 - Human");
		System.out.println("  2 - Computer");
		System.out.print("Enter your choice: ");
		while(true)
		{
			String answer = scanner.nextLine();
			if("1".equals(answer))
			{
				return 1;
			}
			if("2".equals(answer))
			{
				return 2;
			}
			System.out.print("Try again: ");
		}
	}

	public static void main(String[] args)
	{
		IThinker thinker = chooseType("Thinker") == 1 ? new HumanThinker() : new ComputerThinker();
		IGuesser guesser = chooseType("Guesser") == 1 ? new HumanGuesser() : new ComputerGuesser();
		GameCtrl gc = new GameCtrl(0, 100);
		gc.runGame(thinker, guesser);
	}
}
