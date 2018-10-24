package lab1a;


import java.util.Random;
import java.util.Scanner;


class lab1a {
    
    public static void main(String args[]) {
        new lab1a(0, 100);
    }
   
    private final int MIN;
    private final int MAX;
    
    private int guessnumber = 0;   
    private int guessestaken = 0; 

    public lab1a(int min, int max) {
        MIN = min;
        MAX = max;
        
        guessnumber = newnumber ();

        int guess;        

        do {
            guessestaken++;            
            guess = getUserInput();            
        } 
        
        while (!check(guess));
    }

 
    private int getUserInput() { 
        
        Scanner input = new Scanner(System.in);
        String userinput;
        
        do {
            System.out.print("Try and guess a number between 1 and 100: ");                       
            userinput = input.nextLine();
            
        } while (!isInteger(userinput));
        
        return Integer.parseInt(userinput);
    }

    
    private int newnumber () {
        Random random = new Random();
        return random.nextInt(MAX - MIN + 1) + MIN;
    }

    private boolean check (int guess) {
        if (guess == guessnumber) {            
            System.out.println( "Sweet! You guessed it in " + guessestaken + " guesses.");
            return true;
      } else {
        
        if (guess > guessnumber) {
            System.out.println("My number is lower than " + guess + ".");
      } else {
            System.out.println("My number is higher than " + guess + ".");
            }
        }        
        return false;
    }
    
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;            
        }       
        return true;
    }     
    
}
