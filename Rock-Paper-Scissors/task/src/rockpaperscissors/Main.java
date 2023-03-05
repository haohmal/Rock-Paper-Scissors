package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Random random = new Random();
        String playerChoiceInput;
        int playerChoice;
        int computerChoice;

        String[] choices = {"rock","paper","scissors"};
        String[] ratings;

        File file = new File("rating.txt");

        Scanner scanner = new Scanner(System.in);
        Scanner fileScanner = new Scanner(file);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name);
        String gameOptions = scanner.nextLine();
        String[] optionList = gameOptions.split(",");
        if (optionList.length > 1) {
            choices = optionList;
        }
        System.out.println("Okay, let's start");
        int score = 0;

        while (fileScanner.hasNext()) {
            String input = fileScanner.nextLine();
            ratings = input.split(" ");
            if (ratings[0].equals(name) && ratings.length > 1) {
                score = Integer.parseInt(ratings[1]);
            }
        }

        do {
            playerChoiceInput = scanner.nextLine();
            playerChoice = -1;
            for (int i = 0; i < choices.length; i++) {
                if (choices[i].equals(playerChoiceInput)) {
                    playerChoice = i;
                }
            }
            computerChoice = random.nextInt(choices.length);

            if (playerChoiceInput.equals("!exit")) {
                System.out.println("Bye!");
            } else if (playerChoiceInput.equals("!rating")) {
                System.out.println("Your rating: " + score);
            } else if (playerChoice == -1) {
                System.out.println("Invalid input");
            } else if (playerChoice == computerChoice) {
                System.out.println("There is a draw (" + choices[computerChoice] + ")");
                score += 50;
            } else if (computerChoice < playerChoice - choices.length / 2 ||
                    computerChoice > playerChoice && computerChoice <= playerChoice + choices.length / 2) {
                System.out.println("Sorry, but the computer chose " + choices[computerChoice]);
            } else {
                System.out.println("Well done. The computer chose " + choices[computerChoice] + " and failed");
                score += 100;
            }
        } while (!playerChoiceInput.equals("!exit"));

    }
}
