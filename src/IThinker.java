public interface IThinker
{
	void yourTurn();

	String getName();

	void newGame(int min, int max, String opponent, String type);

	Answer evaluateGuess(int guess, String opponent);

	boolean endOfGame(int numberOfGuesses, String opponent);
}
