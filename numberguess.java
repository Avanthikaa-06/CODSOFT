package org.num;
import java.util.Scanner;

public class numberguess {
	Scanner scan = new Scanner(System.in);
	int totalScore = 0;
	int roundWon = 0;

	public static void main(String[] args) {
		numberguess ng = new numberguess();
		boolean guess_correct = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To Number Guessing Game");
		
		while (guess_correct) {
			System.out.println("Do you want to continue(yes/no)");
			String multiple_rounds = sc.nextLine().toLowerCase();
			
			if (multiple_rounds.equals("yes")) {
				ng.multipleRounds();
			} else {
				System.out.println("Thank you! Game Over");
				System.out.println("Rounds won: " + ng.roundWon);
				System.out.println("Total Score: " + ng.totalScore);
				guess_correct = false;
			}
		}
		
		sc.close();
		ng.scan.close();
	}

	public void multipleRounds() {
		int generated_number = (int)(Math.random() * 100) + 1;
		int attempts = 10;
		boolean won = false;

		System.out.println("Number of Attempts is Limited to 'TEN'");

		while (attempts > 0) {
			System.out.println("Guess the number");
			int user_guess = scan.nextInt();
			attempts--;
			System.out.println("No of attempts left: " + attempts);

			if (user_guess > generated_number) {
				System.out.println(user_guess + " is too high");
			} else if (user_guess < generated_number) {
				System.out.println(user_guess + " is too low");
			} else {
				System.out.println("Congratulations! You guessed the correct number: " + generated_number);
				int score = attempts * 10;
				totalScore += score;
				roundWon++;
				won = true;
				break;
			}
		}

		if (!won) {
			System.out.println("You've used all attempts! The number was: " + generated_number);
		}
	}
}
