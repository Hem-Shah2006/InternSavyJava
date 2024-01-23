import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int MinRange=1;
		int MaxRange=100;
		int MaxAttempts=10;
		int Score=0;
		int TargetNo;
		int attempts;
		int UserGuess;
		boolean hasGuessedCorrectly;
		System.out.println("Welcome     Welcome     Welcome");
		System.out.println("Let's Play Number Guessing Game !");
		System.out.println("In This Game The System Will Guess A Random Number From 1 to 100 And You Need To Guess It.");
		do
		{
			TargetNo=rd.nextInt(MaxRange-MinRange+1)+MinRange;
			attempts=0;
			hasGuessedCorrectly=false;
			System.out.println("Select A Number Between "+MinRange+" And "+MaxRange+". Try Your Best To Guess The Number.");
			
			while(attempts<MaxAttempts)
			{
				System.out.println("Enter Your Guess : ");
				UserGuess=sc.nextInt();
				attempts++;

				if(UserGuess==TargetNo)
				{
					hasGuessedCorrectly=true;
					System.out.println("Woah ! , You Guessed The Correct Number In "+attempts+" Attempts.");
					break;
				}
				else if(UserGuess<TargetNo)
				{
					System.out.println("Very Low. Please Try Again.");
				}
				else 
				{
					System.out.println("Very High. Please Try Again.");
				}
			}
			if(!hasGuessedCorrectly)
			{
				System.out.println("Sorry, You Have Reached The Maximum Attempts. The Correct Number Was "+TargetNo);
			}
			Score+=hasGuessedCorrectly?1:0;
			System.out.println("Do You Want To Play Again ? (Yes/No)");
			String PlayAgain=sc.next();
			if(!PlayAgain.equalsIgnoreCase("Yes"))
			{
				System.out.println("Thanks You For Playing . . . . . .Your Final Score Is : "+Score);
				break;
			}
		}while(true);
	}
}