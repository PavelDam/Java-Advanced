package _06_DefiningClasses.Lab.P03_BankAccount;

import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Integer, BankAccount> accounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] commandArr = input.split("\\s+");
            String command = commandArr[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accounts.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");

            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(commandArr[1]);
                int amount = Integer.parseInt(commandArr[2]);


                if (accounts.containsKey(id)) {
                    accounts.get(id).deposit(amount);
                    System.out.println("Deposited " + amount + " to " + "ID" + id);
                } else {
                    System.out.println("Account does not exist");
                }


            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(commandArr[1]);
                BankAccount.setInterestRate(interest);

            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(commandArr[1]);
                int years = Integer.parseInt(commandArr[2]);


                if (accounts.containsKey(id)) {
                    double interest = accounts.get(id).getInterest(years);
                    System.out.printf("%.2f%n", interest);
                } else {
                    System.out.printf("Account does not exist%n");
                }


            }

            input = scanner.nextLine();
        }
    }
}
