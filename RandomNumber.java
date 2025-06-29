import java.util.*;

public class RandomNumber{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        boolean keepPlaying = true;

        System.out.println("=== Welcome to the Random Number Guessing Game ===");
        System.out.print("Enter your name:");
        String name=in.nextLine();
        while (keepPlaying) {
            int targetNumber = random.nextInt(100) + 1;
            
            System.out.println("\nChoose difficulty:");
            System.out.println("1. Easy (7 attempts)");
            System.out.println("2. Medium (5 attempts)");
            System.out.println("3. Hard (3 attempts)");
            System.out.print("Enter your choice: ");
            int difficulty = in.nextInt();

            int maxAttempts;

            if (difficulty == 1) {
                maxAttempts = 7;
            } else if (difficulty == 2) {
                maxAttempts = 5;
            } else if (difficulty == 3) {
                maxAttempts = 3;
            } else {
                System.out.println("Invalid choice. Skipping this round.");
                continue;
            }

            System.out.println("Okay! I've picked a number between 1 and 100. Try to guess it!");

            boolean guessed = false;
            int score = 100;
            int penalty = 100 / maxAttempts;

            for (int attempt = 1; attempt <= maxAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Your guess: ");
                int guess = in.nextInt();

                if (guess == targetNumber) {
                    System.out.println("Nice! You got it right!");
                    guessed = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Nope, it's higher.");
                } else {
                    System.out.println("Nope, it's lower.");
                }
                score -= penalty;
            }

            if (!guessed) {
                System.out.println("Too bad! The number was: " + targetNumber);
                score = 0;
            }

            System.out.println("Your score for this round: " + score + "/100");
            totalScore += score;

            System.out.print("Do you want to play another round? (yes/no): ");
            in.nextLine(); 
            String playAgain = in.nextLine().trim().toLowerCase();

            if (!playAgain.equals("yes")) {
                keepPlaying = false;
                System.out.println("\nThanks for playing "+name+"!\n Your total score: " + totalScore);
            }
        }

        in.close();
        System.out.println("Goodbye!");
    }
}
