
package casino;

import java.util.Random;
import java.util.Scanner;


public class highOrLow {
    static double totalBet;
    public static void game(){
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        String guess;
        boolean winning = true;
        System.out.println("If your answer is correct, your bet will double. If your answer incorrect you will lose your bet.");
        System.out.println("Please enter your betting amount: ");
        double bet = scan.nextDouble();
        
        do{
            System.out.println(randNum);
            System.out.println("Is the next Number higher or lower than this: h/l");
            guess = scan.next();
            if(!guess.equalsIgnoreCase("h") && !guess.equalsIgnoreCase("l")){
                System.out.println("Not a choice, please try again!");
                continue;
            }
            int fNum =randNum;
            randNum = rand.nextInt(13);
            if(guess.equalsIgnoreCase("h") && randNum >= fNum){
                System.out.println("Correct," + " Number was " + randNum);
                winning = true;
                bet = bet*2;
            }else if(guess.equalsIgnoreCase("h") && randNum < fNum){
                System.out.println("Incorrect," + " Number was " + randNum);
                winning = false;
                bet = -bet;
            }else if(guess.equalsIgnoreCase("l") && randNum > fNum){
                System.out.println("Incorrect," + " Number was " + randNum);
                winning = false;
                bet = -bet;
            }else if(guess.equalsIgnoreCase("l") && randNum < fNum){
                System.out.println("Correct," + " Number was " + randNum);
                winning = true;
                bet = bet*2;
            }
            
            
            if(winning){
                System.out.println("Do you want to continue? y/n");
                String keepGoing = scan.next();
                if(keepGoing.equalsIgnoreCase("n")){
                    winning = false;
                }
            }
            
        }while(winning);
        totalBet = bet;
        System.out.println("Your total money is: " + totalBet);
        
    }
}
