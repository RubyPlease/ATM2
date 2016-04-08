import com.sun.tools.javah.Util;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerDouble = new Scanner(System.in);
    static String selection = "";
    static double balance = 0;
    static HashMap<String, Double> userInfo = new HashMap<>();
    static String name;
// ask for name
    public static void main(String[] args) throws Exception {
        while (true){
            System.out.println("Please enter your name");

        name = scanner.nextLine();
// no name in hashmap, ask to create account
        while (name.isEmpty()) {
            System.out.println("Please enter your name");
            name = scanner.nextLine();
        }

        System.out.println("Welcome " + name);
// set up balance in account
        while (! userInfo.containsKey(name)) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter balance to create new account");
            balance = scanner1.nextDouble();
// display name and balance of account
            userInfo.put(name, balance);
            System.out.println(userInfo.toString());
            atmProcess();
        }

        /*the main ^ doesn't execute my other process.
        * I might need to undo what was done to make it work.
        * */

        }
    }
    static void atmProcess() {
        while (true) {
// give them options to manipulate account
            System.out.println("Please enter 1, 2, 3, or 4\n" +
                    "[1. Check Balance 2. Withdraw Funds 3. Remove Account 4. Cancel]");

            selection = scanner.nextLine();

            switch (selection) {
// display account balance
                case "1": {
                    System.out.printf("Your balance is $%s0\n", balance);
                    break;
                }
// allow for withdrawal, while checking if negative amount or exceeding balance
                case "2": {
                    System.out.println("Please enter amount to withdraw");
                    double amount = scannerDouble.nextDouble();
                    if (amount > balance) {
                        System.out.println("Insufficient funds available");

                    } else if (amount < 0) {
                        System.out.println("Please enter a positive amount");
// update balance after withdrawal
                    } else {
                        balance -= amount;
                        System.out.printf("Please take your withdrawal\n" +
                                "Your new balance is $%s0\n", balance);
                    }
                    break;
                }
// allow for deleting account
                case "3": {
                    System.out.println("Please confirm account name");
                    String tempName = scanner.nextLine();
                    if (tempName.equals(name)){
                        userInfo.remove(name);
                    }
                    else {
                        System.out.println("Account name does not match");
                        break;
                    }
                }
                case "4": {
                    System.out.println("Thank you. Please come again");
                    return;
                }
// return back to main for new user
                default:
            }
        }
    }
}

