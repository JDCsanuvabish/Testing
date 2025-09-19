import java.util.Scanner;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        //Initial Value
        int money = 1000;
        int bet = 0;

        //Loop That will run as long as the user still have money
        while(true) {
            printGreet();
            Scanner scanner = new Scanner(System.in);
            char choice = Character.toLowerCase(scanner.nextLine().charAt(0));
            if (choice == 'y') {
                System.out.print("Place your Bet Amount: ");
                bet = scanner.nextInt();
                if (money >= bet) {
                    money -= bet;
                    String[] user_spin = spin();
                    print(user_spin);
                    int win = payout(bet, user_spin);
                    money += win;
                    if(payout(bet, user_spin) > 0){
                        System.out.printf("You've won %d$\n", win);
                    }
                    else {
                        System.out.println("Sorry You Lost");
                    }

                }
            }
          else {
              break;
            }
        }




    }
     static void printGreet(){
        System.out.println("*".repeat(20));
         System.out.println("Welcome to Java Slots");
         System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐ ");
         System.out.println("*".repeat(20));
         System.out.println("Do you want to play Slot Machine? Y/N");
    }

        //Method that will roll the slot machines
    static String[] spin(){
        String[] fruits = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        String[] row = new String[3];
        Random random = new Random();
        for(int i = 0; i < 3;i++){
            row[i] = fruits[random.nextInt(0, fruits.length)];
        }
        return row;

    }

    static void print(String row[]) {
        System.out.println("Spinning....");
        for(int i = 0; i < row.length; i++){
            System.out.print("|" + row[i] + "|");
        }
        System.out.println();
    }

    static int payout(int bet, String[] row){
        if(row[0].equals(row[1]) && row[1].equals(row[2])){
            return switch (row[0]){
                case "🍒" -> bet * 3;
                case "🍉" -> bet * 4;
                case "🍋" -> bet * 5;
                case "🔔" -> bet * 10;
                case "⭐" -> bet * 20;
                default -> 0;

            };
        } else if (row[0].equals(row[1])|| row[1].equals(row[2])) {
            return switch (row[0]){
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;

            };


        }
        return 0;


    }

}