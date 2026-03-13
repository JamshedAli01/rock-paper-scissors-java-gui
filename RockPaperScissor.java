import java.util.Random;
// backend
public class RockPaperScissor
{
	// all of the choices that a computer can choose:
	private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};
	
	// store the computer choice so that we can retrieve the value and display it to the frontend
	public String computerChoice;
	
	// this will store the scores of computer and player:
	private int computerScore = 0, playerScore = 0;
	
	public String getComputerChoice()
	{
		return computerChoice;
	}
	
	public int getComputerScore()
	{
		return computerScore;
	}
	
	public int getPlayerScore()
	{
		return playerScore;
	}
	
	// used to generate a random number to randomly choose and option for the computer:
	private Random random;
	
	// Constructor to initialize the random object:
	public RockPaperScissor()
	{
		random = new Random();
	}
	
	// call this method to begin playing rock paper scissor: 
	// playChoice - is the choice made by the user (i.e, rock, paper or scissors)
	// this method will return the result of the game (i.e, computer win, player win, draw)
	public String playRockPaperScissor(String playerChoice)
	{
		// generate computer choice:
		computerChoice = computerChoices[random.nextInt(computerChoices.length)];
		
		// this will contain the resulting message that will indicate the result of the game: 
		String result;
		
		// evaluate the winner:
		if (computerChoice.equals("Rock"))
		{
			if (playerChoice.equals("Paper"))
			{
				result = "Player win";
				playerScore++;
			}
			else if (playerChoice.equals("Scissors"))
			{
				result = "Computer wins";
				computerScore++;
			}
			else 
			{
				result = "Draw";
			}
		}
		else if (computerChoice.equals("Paper"))
		{
			if (playerChoice.equals("Scissors"))
			{
				result = "Player win";
				playerScore++;
			}
			else if (playerChoice.equals("Rock"))
			{
				result = "Computer wins";
				computerScore++;
			}
			else 
			{
				result = "Draw";
			}
		}
		else
		{
			// computer chooses the Scissors:
			if (playerChoice.equals("Rock"))
			{
				result = "Player win";
				playerScore++;
			}
			else if (playerChoice.equals("Paper"))
			{
				result = "Computer wins";
				computerScore++;
			}
			else 
			{
				result = "Draw";
			}
		}
		// this will return the result:
		return result;
	}
}
