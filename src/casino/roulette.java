package casino;

import java.util.Random;
import java.util.Scanner;

public class roulette {

    static int numberRolled;
    static Random rand = new Random();
    static double totalBet;
    static double bet;
    
    
    public static void game() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your bet: ");
        bet = scan.nextDouble();
        
        numberRolled = rand.nextInt(36);
        System.out.println("Would you like to bet on a colour? y/n");
        String colourBet = scan.next();
        if (colourBet.equals("y")) {
            System.out.println("What colour would you like to bet on? Red, Black or Green?");
            String colour = scan.next();

            if (colour.equalsIgnoreCase("red") && ((numberRolled >= 1 && numberRolled <= 10) || (numberRolled >= 19 && numberRolled <= 28)) && (numberRolled % 2 == 1)) {
                System.out.println("You win");
                totalBet = bet * 2;
            } else if (colour.equalsIgnoreCase("black") && ((numberRolled >= 1 && numberRolled <= 10) || (numberRolled >= 19 && numberRolled <= 28)) && (numberRolled % 2 == 0)) {
                System.out.println("You win");
                totalBet = bet * 2;
            } else if (colour.equalsIgnoreCase("red") && ((numberRolled >= 1 && numberRolled <= 10) || (numberRolled >= 19 && numberRolled <= 28)) && (numberRolled % 2 == 0)) {
                System.out.println("You lose");
                totalBet = -bet;
            } else if (colour.equalsIgnoreCase("black") && ((numberRolled >= 1 && numberRolled <= 10) || (numberRolled >= 19 && numberRolled <= 28)) && (numberRolled % 2 == 1)) {
                System.out.println("You lose");
                totalBet = -bet;
            } else if (colour.equalsIgnoreCase("red") && ((numberRolled >= 11 && numberRolled <= 18) || (numberRolled >= 29 && numberRolled <= 36)) && (numberRolled % 2 == 0)) {
                System.out.println("You win");
                totalBet = bet * 2;
            } else if (colour.equalsIgnoreCase("black") && ((numberRolled >= 11 && numberRolled <= 18) || (numberRolled >= 29 && numberRolled <= 36)) && (numberRolled % 2 == 1)) {
                System.out.println("You win");
                totalBet = bet * 2;
            } else if (colour.equalsIgnoreCase("red") && ((numberRolled >= 11 && numberRolled <= 18) || (numberRolled >= 29 && numberRolled <= 36)) && (numberRolled % 2 == 1)) {
                System.out.println("You lose");
                totalBet = -bet;
            } else if (colour.equalsIgnoreCase("black") && ((numberRolled >= 11 && numberRolled <= 18) || (numberRolled >= 29 && numberRolled <= 36)) && (numberRolled % 2 == 0)) {
                System.out.println("You lose");
                totalBet = -bet;
            }else if(colour.equalsIgnoreCase("green") && numberRolled == 0){
                System.out.println("You win");
                totalBet = bet * 36;
            }else if(colour.equalsIgnoreCase("green") && numberRolled != 0){
                System.out.println("You lose");
                totalBet = -bet;
            }
        } else {
            System.out.println("Would you like to bet on odd or even? y/n");
            String oddOrEvenChoice = scan.next();
            if (oddOrEvenChoice.equalsIgnoreCase("y")) {
                System.out.println("What would you like to bet on? odd/even");
                String oddOrEven = scan.next();
                if (oddOrEven.equalsIgnoreCase("odd") && numberRolled % 2 == 1) {
                    System.out.println("You win");
                    totalBet = bet * 2;
                } else if (oddOrEven.equalsIgnoreCase("even") && numberRolled % 2 == 0) {
                    System.out.println("You win");
                    totalBet = bet * 2;
                } else if (oddOrEven.equalsIgnoreCase("odd") && numberRolled % 2 == 0) {
                    System.out.println("You lose");
                    totalBet = -bet;
                } else if (oddOrEven.equalsIgnoreCase("even") && numberRolled % 2 == 1) {
                    System.out.println("You lose");
                    totalBet = -bet;
                }
            } else {
                System.out.println("Would you like to bet on low or high? y/n");
                String lowOrHighChoice = scan.next();
                if(lowOrHighChoice.equalsIgnoreCase("y")){
                    System.out.println("What would you like to bet on? low/high");
                    String lowOrHigh = scan.next();
                    if(lowOrHigh.equalsIgnoreCase("low") && numberRolled >=1 && numberRolled <= 18){
                        System.out.println("You win");
                        totalBet = bet * 2;
                    }else if(lowOrHigh.equalsIgnoreCase("high") && numberRolled >=19 && numberRolled <=36){
                        System.out.println("You win");
                        totalBet = bet * 2;
                    }else if(lowOrHigh.equalsIgnoreCase("low") && numberRolled >=19 && numberRolled <=36){
                        System.out.println("You lose");
                        totalBet = -bet;
                    }else if(lowOrHigh.equalsIgnoreCase("high") && numberRolled >=1 && numberRolled <=18){
                        System.out.println("You lose");
                        totalBet = -bet;
                    }else if(numberRolled == 0){
                        System.out.println("You lose");
                        totalBet = -bet;
                    }
                }else{
                    System.out.println("Would you like to bet on a dozen? y/n");
                    String dozenChoice = scan.next();
                    if(dozenChoice.equalsIgnoreCase("y")){
                        System.out.println("Which dozen would you like to bet on? 1,2,3");
                        int dozen = scan.nextInt();
                        if(dozen == 1 && numberRolled >= 1 && numberRolled <= 12){
                            System.out.println("You win");
                            totalBet = bet * 3;
                        }else if(dozen == 2 && numberRolled >= 13 && numberRolled <= 24){
                            System.out.println("You win");
                            totalBet = bet *3;
                        }else if(dozen == 3 && numberRolled >= 25 && numberRolled <=36){
                            System.out.println("You win");
                            totalBet = bet * 3;
                        }else if(dozen == 1 && !(numberRolled >= 1 && numberRolled <= 12)){
                            System.out.println("You lose");
                            totalBet = -bet;
                        }else if(dozen == 2 && !(numberRolled >= 13 && numberRolled <= 24)){
                            System.out.println("You lose");
                            totalBet = -bet;
                        }else if(dozen == 3 && !(numberRolled >= 25 && numberRolled <= 36)){
                            System.out.println("You lose");
                            totalBet = -bet;
                        }else{
                            System.out.println("You lose");
                            totalBet = -bet;
                        }
                    }else{
                        System.out.println("Would you like to bet on a number? y/n");
                        String numberChoice = scan.next();
                        if(numberChoice.equalsIgnoreCase("y")){
                            System.out.println("What number would you like to bet on?");
                            int number = scan.nextInt();
                            if(number == numberRolled){
                                System.out.println("You win");
                                totalBet = bet *36;
                            }else if(number!= numberRolled){
                                System.out.println("You lose");
                                totalBet = -bet;
                            }
                        }
                    }
                }
            }

        }
        System.out.println("Your total money is: " + totalBet);
        
    }

}
