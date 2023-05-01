package com.iv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    public static void ledger() {

        String ledgerInput;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t 1: Display All Entries");
            System.out.println("\t 2: Display Deposit Entries");
            System.out.println("\t 3: Display Payment Entries");
            System.out.println("\t 4: Reports");
            System.out.println("\t 5: Return Home");

            ledgerInput = scanner.nextLine();

            switch (ledgerInput) {
                case "1":
                    allEntries();
                    break;
                case "2":
                    depositEntries();
                    break;
                case "3":
                    negativeEntries();
                    break;
                case "4":
                    Reports.reports();
                    break;
                case "5":
                    System.out.println("Heading back to the Home Page.");
                default:
                    System.out.println("Invalid input you Bozo, put in the right number next time.");
            }
        } while (!ledgerInput.equalsIgnoreCase("5"));
    }
    public static void allEntries(){

    }
    public static void negativeEntries(){

    }
    public static void depositEntries(){

    }
}
