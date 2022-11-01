public class AlienThinker implements IThinker
{
    @Override
    public void yourTurn()
    {

    }

    public AlienThinker()
    {

    }

    public void makeAlienNoises()
    {
        System.out.println("blublublub");
    }

    @Override
    public String getName()
    {
        return "weird alien noises";
    }

    @Override
    public void newGame(int min, int max, String opponent, String type)
    {

    }

    @Override
    public Answer evaluateGuess(int guess, String opponent)
    {
        return null;
    }

    @Override
    public boolean endOfGame(int numberOfGuesses, String opponent)
    {
        return false;
    }
}
