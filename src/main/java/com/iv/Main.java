package com.iv;

import java.io.*;
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
            System.out.println("\t 1: Add Deposit");
            System.out.println("\t 2: Make Payment");
            System.out.println("\t 3: Ledger");
            System.out.println("\t 4: Exit");
            userInput = scanner.nextLine();

            switch (userInput) {
            case "1":
                addDeposit();
                break;
            case "2":
                makePayment();
                break;
            case "3":
                Ledger.ledger();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide how much you are intending to deposit: \n Amount: ");
        String depositAmountAdd = scanner.nextLine();
        try {
            FileWriter depositFiles = new FileWriter("./src/main/java/com/iv/Transactions.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(depositFiles);

            bufferedWriter.write(depositAmountAdd);

            for(int i=0;i<100_000;i++){
                bufferedWriter.write(i);
            }
            String input;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void makePayment(){

    }
}
