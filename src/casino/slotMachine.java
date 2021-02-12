package casino;

import java.util.Random;
import java.util.Scanner;

public class slotMachine {

    static double totalBet;

    public static void game() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        boolean playing = true;
        do {
            System.out.println("Enter your bet: ");
            double bet = scan.nextDouble();
            int rand1 = rand.nextInt(8);
            int rand2 = rand.nextInt(8);
            int rand3 = rand.nextInt(8);
            System.out.println(rand1 + " " + rand2 + " " + rand3);
            if (rand1 == rand2 && rand1 == rand3 && rand1 == 7) {
                System.out.println("JackPot!!!");
                bet = bet * 3;
            } else if (rand1 == rand2 && rand1 == rand3) {
                System.out.println("Triple");
                bet = bet * 2;
            } else if (rand1 == rand2 || rand1 == rand3 || rand2 == rand3) {
                System.out.println("Double");
                bet = bet * 1.5;
            } else {
                System.out.println("You lost");
                bet = -bet;
            }
            totalBet = totalBet + bet;
            System.out.println("Bet is " + bet);
            System.out.println("Do you want to continue playing? y/n");
            String keepPlaying = scan.next();
            if (keepPlaying.equalsIgnoreCase("n")) {
                playing = false;
            }
        } while (playing);
        System.out.println("Your total money is: " + totalBet);
        
    }

}
