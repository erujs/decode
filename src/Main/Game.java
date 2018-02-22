package Main;

import java.util.ArrayList;
/**
 * Created by Eru on 3/19/2017.
 */
public class Game {
    public int difficulty,stop,attempt,range;
    public ArrayList<Integer> combo, guess,combination;
    public String[] clues=new String[4];
    Game(int difficulty){
        this.difficulty=difficulty;
        attempt = 0;
        range = highest(difficulty);
        combo = new ArrayList<Integer>();
        stop = turns(difficulty);
        randomCombo(combo, range);
    }
    public int max(){
        switch(difficulty){
            case 1: return 6;
            case 2: return 8;
            case 3: return 9;
        }
        return 0;
    }
    public void combandguess(){
        combination = new ArrayList<Integer>();
        for(int a = 0; a < combo.size(); a++) {
            combination.add(combo.get(a));
        }
        guess = new ArrayList<Integer>();
    }

    public ArrayList<Integer> randomCombo(ArrayList<Integer> combo, int highest) {
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
    public int highest(int difficulty) {
        if(difficulty == 1) {
            return 6;
        } else if (difficulty == 2) {
            return 8;
        } else {
            return 10;
        }
    }
    /** Determines the max number of turns the game will play. */
    public int turns(int difficulty) {
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
    public void hint(ArrayList<Integer> guess, ArrayList<Integer> pattern) {
        // Provides clues to player
        // Gives 'X'
        for(int i = 0; i < pattern.size(); i++){
            clues[i]=null;
        }
        for(int i = 0; i < pattern.size(); i++)  {
            // Compares values based on position between guess and pattern Array Lists
            if(guess.get(i) == pattern.get(i))
                clues[i]="X";
            else if(pattern.contains(guess.get(i)))
                clues[i]="x";
            else
                clues[i]="-";
        }
    }


    /** Determines if player's guess was correct. */
    public boolean isCorrect(ArrayList<Integer> guess, ArrayList<Integer> pattern) {
        return (guess.get(0) == pattern.get(0)) && (guess.get(1) == pattern.get(1))
                && (guess.get(2) == pattern.get(2)) && (guess.get(3) == pattern.get(3));
    }

}

