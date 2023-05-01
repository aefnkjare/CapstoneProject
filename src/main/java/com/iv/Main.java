package com.iv;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Add a homescreen menu that has d, p, l, x
        // make a submenu of ledger, that has a, d, p, r, and h
        //and another submenu in the r, that consists of 1, 2, 3, 4, 5, 0

        String userInput;

        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t D: Add Deposit");
            System.out.println("\t P: Make Payment");
            System.out.println("\t L: Ledger");
            System.out.println("\t X: Exit");
            userInput = scanner.nextLine();

            switch (userInput) {
            case "1":
                addDeposit();
                break;
            case "2":
                makePayment();
                break;
            case "3":
                ledger();
                break;
            case "4":
                System.out.println("Exiting the application.");
                break;
            default:
                System.out.println("Invalid input you Bozo, put in the right number next time.");
            }
        }while(!userInput.equalsIgnoreCase("4"));
    }
    public static void addDeposit(){

    }
    public static void makePayment(){

    }
    public static void ledger(){

    }
    public static void reports(){

    }
}