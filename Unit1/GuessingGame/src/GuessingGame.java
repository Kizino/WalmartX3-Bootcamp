import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public GuessingGame(){
        Scanner input = new Scanner(System.in);
        boolean correctGuess = false;
        int guess = 0;
        int increment = 0;

        System.out.println("Hello user. What is your name?");
        String name = input.nextLine();

        Random rand = new Random();
        int number = rand.nextInt(100);

        System.out.println("Welcome " + name + ". I'm thinking of a number between 1 and 100.");
        System.out.println("Try to guess my number.");

        while(correctGuess == false ){
            increment++;

            try{
                guess = input.nextInt();
            }catch(Exception e){
                String badInput = input.next();
                System.out.println("That's not an integer, try again");
                continue;
            }

            if(guess < 1 || guess > 100){
                System.out.println("Your guess is out of range. Please try again.");
            } else if (guess > number) {
                System.out.println("Your guess is too high. Please try again");
            } else if (guess < number) {
                System.out.println("Your guess is too low. Please try again");
            } else if (guess == number){
                System.out.println("Well done, " + name + "! You found my number in " + increment + " tries!");
                correctGuess = true;
            }
        }
    }
}
