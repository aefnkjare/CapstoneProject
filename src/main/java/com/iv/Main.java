package com.iv;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void main(String[] args) {
        // Add a homescreen menu that has d, p, l, x
        // make a submenu of ledger, that has a, d, p, r, and h
        //and another submenu in the r, that consists of 1, 2, 3, 4, 5, 0

        String userInput;

        LedgerLine ledger = new LedgerLine();

        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t 1: Add Deposit");
            System.out.println("\t 2: Make Payment");
            System.out.println("\t 3: Ledger Menu");
            System.out.println("\t 4: Exit");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    ledger.addDeposit();
                    break;
                case "2":
                    ledger.makePayment();
                    break;
                case "3":
                    ledger.ledgerMenu();
                    break;
                case "4":
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid input you Bozo, put in the right number next time.\n");
            }
        } while (!userInput.equalsIgnoreCase("4"));
    }
}