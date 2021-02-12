package casino;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Casino {

    static user u1;
    static File file = fileHandling.file;
    static Scanner scan = new Scanner(System.in);

    public static void userCreate() {
        try {
            System.out.println("Have you been here before? y/n");
            String visited = scan.next();
            System.out.println("What is your first name?");
            String fName = scan.next();
            System.out.println("What is your last name?");
            String lName = scan.next();

            if (visited.equalsIgnoreCase("y")) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String str;
                while ((str = br.readLine()) != null) {
                    String[] users = str.split(", ");
                    String firstName = users[0];
                    String lastName = users[1];
                    double balance = Double.parseDouble(users[2]);
                    
                    if (firstName.equalsIgnoreCase(fName) && lastName.equalsIgnoreCase(lName)) {
                        System.out.println("User found! Your balance is: " + balance);
                        System.out.println("Would you like to add more money? y/n");
                        String choice = scan.next();
                        if (choice.equalsIgnoreCase("y")) {
                            System.out.println("How much would you like to add?");
                            double moneyAdd = scan.nextDouble();
                            balance = balance + moneyAdd;
                        }
                        u1 = new user(firstName, lastName, balance);
                        break;
                    }
                }
                br.close();
            } else {
                System.out.println("How much money would you like to add?");
                double balance = scan.nextDouble();
                u1 = new user(fName, lName, balance);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        userCreate();
        double currentBal;

        while (true) {
            System.out.println("What game would you like to play? \n1 - Roulette \n2 - Higher Or Lower \n3 - Slot Machine");
            int gameChoice = scan.nextInt();
            switch (gameChoice) {
                case 1:
                    roulette.game();
                    currentBal = u1.getBalance();
                    u1.setBalance(currentBal + roulette.totalBet);
                    break;

                case 2:
                    highOrLow.game();
                    currentBal = u1.getBalance();
                    u1.setBalance(currentBal + highOrLow.totalBet);
                    break;
                case 3:
                    slotMachine.game();
                    currentBal = u1.getBalance();
                    u1.setBalance(currentBal + slotMachine.totalBet);
                    break;
                default:
                    break;
            }
            if(u1.getBalance() <= 0){
                System.out.println("Not enough money");
                System.exit(1);
            }
            System.out.println("Would you like to play another game? y/n");
            String playAgain = scan.next();
            if (playAgain.equalsIgnoreCase("n")) {
                System.out.println("Total money is " + u1.getBalance());
                fileHandling.writeFile(u1.toString());
                break;

            }
        }

    }

}
