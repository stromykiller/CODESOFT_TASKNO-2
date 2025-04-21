import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int roundsPlayed = 0;
        String playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean isCorrect = false;

            System.out.println("\nI've picked a number between 1 and 100.");
            System.out.println("Can you guess it? You have " + maxAttempts + " tries.");

            while (attemptsUsed < maxAttempts) {
                System.out.print("Guess " + (attemptsUsed + 1) + ": ");

                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    continue;
                }

                attemptsUsed++;

                if (guess < targetNumber) {
                    System.out.println("Too low.");
                } else if (guess > targetNumber) {
                    System.out.println("Too high.");
                } else {
                    System.out.println("Nice! You got it in " + attemptsUsed + " tries.");
                    score++;
                    isCorrect = true;
                    break;
                }
            }

            if (!isCorrect) {
                System.out.println("No luck this time. The number was: " + targetNumber);
            }

            roundsPlayed++;

            System.out.print("\nWould you like to play again? (yes/no): ");
            playAgain = scanner.nextLine().trim().toLowerCase();

        } while (playAgain.equals("yes") || playAgain.equals("y"));

        System.out.println("\nThanks for playing!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + score);

        scanner.close();
    }
}

