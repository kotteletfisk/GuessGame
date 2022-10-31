public interface IGuesser
{
	void yourTurn();

	String getName();

	void newGame(int min, int max, String opponent, String type);

	int makeGuess();

	void guessFeedback(Answer answer);

	boolean endOfGame(int numberOfGuesses, String opponent);
}
