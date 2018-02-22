package MasterMind;

import java.util.*;
/**
 * Created by Eru on 3/19/2017.
 */
public class MM
{
    /** Creates random combination for player to guess. The level of difficulty chosen
     * will change the number of values used to create the combination.
     */
    public static void main(String[] args) {
        // Keeps track of number of guess made by player
        int attempt = 0;
        // Will ensure the player only inputs 4 values with each guess
        int guessNumber = 0;
        // Will be assigned difficulty level
        int range = 0;
        Scanner level = new Scanner(System.in);
        System.out.println("Welcome to the game of MasterMind.");
        System.out.println("The hints given after each guess are made up of X's, x's and -'s.");
        System.out.println("Each X means one of the numbers in your guess is in the correct position.");
        System.out.println("Each x means a number is correct but in the wrong position.");
        System.out.println("Each - means a number did not match.");
        System.out.print("Please select difficulty 1, 2, or 3 (1 = easy, 2 = medium, 3 = hard): ");
        int difficulty = level.nextInt();
        // Calls highest method to determine difficulty level
        range = highest(difficulty);
        ArrayList<Integer> combo = new ArrayList<Integer>();
        // Calls turn method to determine number of tunes
        int stop = turns(difficulty);
        // Calls randomCombo method to create random combination
        randomCombo(combo, range);
        // Records players guess
        while (attempt <= stop) {
            // Resets the combination after the hints method because the hints method
            // removes values from the combination Array List. This Array List must
            // be reset to all each guess to be compared to the original combination
            ArrayList<Integer> combination = new ArrayList<Integer>();
            for(int a = 0; a < combo.size(); a++) {
                combination.add(combo.get(a));
            }
            // Resets users guess after every guess attempt
            ArrayList<Integer> guess = new ArrayList<Integer>();
            System.out.print("Please enter your guess ");
            if(difficulty == 1) {
                System.out.println("using numbers 1-6.");
            } else if (difficulty == 2) {
                System.out.println("using numbers 1-8.");
            } else{
                System.out.println("using numbers 0-9.");
            }
            // Player's guess
            while(guessNumber < 4) {
                System.out.print("Please enter a positive integer: ");
                Scanner test = new Scanner(System.in);
                guess.add(test.nextInt());
                guessNumber++;
            }
            // Checks if player's guess is correct. If not, provides hints
            if(isCorrect(guess, combination)) {
                break;
            } else {
                System.out.print("interpretation is as folows :"+ hint(guess, combination));
                System.out.println();
                System.out.print("your guesses are as follows :" + guess);
            }
            attempt++;
            guessNumber = 0;
            System.out.println();
        }
        if(attempt < 15) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("YOU LOSE!!!");
        }
    }
    public static ArrayList<Integer> randomCombo(ArrayList<Integer> combo, int highest) {
        for(int i = 0; i < 4; i++) {
            if(highest < 10) {
                combo.add((int)((Math.random() * highest) + 1));
            } else {
                combo.add((int)(Math.random() * highest));
            }
        }
        //   System.out.println(" Combo contaisn " + combo);
        return combo;
    }
    /** Determine the difficulty level of the game. */
    public static int highest(int difficulty) {
        if(difficulty == 1) {
            return 6;
        } else if (difficulty == 2) {
            return 8;
        } else {
            return 10;
        }
    }
    /** Determines the max number of turns the game will play. */
    public static int turns(int difficulty) {
        if((difficulty == 1) || (difficulty == 2)) {
            return 12;
        } else {
            return 15;
        }
    }
    /** Provides the player with hints after each of their guess. "X" means a number
     * matches the combination and is in the correct position. "x" means a number
     * matches the combination and is in the wrong position. "-" means the number
     * is not found within the combination.
     */
    public static String hint(ArrayList<Integer> guess, ArrayList<Integer> pattern) {
        // Keeps track of number of 'X'
        int position = 0;
        // Keeps track of number of 'x'
        int number = 0;
        // Provides clues to player
        String clues = " ";
        // Gives 'X'
        for(int i = 0; i < pattern.size(); i++)
        {

            // Compares values based on position between guess and pattern Array Lists
            if(guess.get(i) == pattern.get(i))
            {
                position++;
                System.out.println(" Congrats !! u got " + guess.get(i)+ " at exact location");
                clues += "X  ";
            }
            else if(pattern.contains(guess.get(i)))
            {
                clues += "x  ";
                System.out.println(" Sorry !! u got " + guess.get(i)+ " at different location");
            }
            else
            {
                clues += "-  ";
                System.out.println(" OOPs " + guess.get(i)+ " is not there any where");
            }
        }
        return clues;
    }


    /** Determines if player's guess was correct. */
    public static boolean isCorrect(ArrayList<Integer> guess, ArrayList<Integer> pattern) {
        return (guess.get(0) == pattern.get(0)) && (guess.get(1) == pattern.get(1))
                && (guess.get(2) == pattern.get(2)) && (guess.get(3) == pattern.get(3));
    }


}