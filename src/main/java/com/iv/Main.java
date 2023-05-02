package com.iv;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Transaction> transactions = new ArrayList<>();

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
        System.out.println("Please provide the date of your deposit(yyyy-MM-dd): \n Answer: ");
        String date = scanner.nextLine();

        System.out.println("Please provide the time of your deposit(hh:MM:ss): \n Answer: ");
        String time = scanner.nextLine();

        System.out.println("Please provide a description: \n Answer: ");
        String desc = scanner.nextLine();

        System.out.println("Please provide the vendor: \n Answer: ");
        String vendor = scanner.nextLine();

        System.out.println("Please provide the amount you are intending to deposit: \n Answer: ");
        String amount = scanner.nextLine();
        try {
            FileWriter depositFiles = new FileWriter("./src/main/java/com/iv/Transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(depositFiles);

            bufferedWriter.write("\n" + date + "|" + time + "|" + desc + "|" + vendor + "|" + amount);

            System.out.println("Deposit successful!");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Deposit unsuccessful, error code 1053R");
            e.printStackTrace();
        }
    }
    public static void makePayment(){
        System.out.println("Please provide the date of your deposit(yyyy-MM-dd): \n Answer: ");
        String date = scanner.nextLine();

        System.out.println("Please provide the time of your deposit(hh:MM:ss): \n Answer: ");
        String time = scanner.nextLine();

        System.out.println("Please provide a description: \n Answer: ");
        String desc = scanner.nextLine();

        System.out.println("Please provide the vendor: \n Answer: ");
        String vendor = scanner.nextLine();

        System.out.println("Please provide the amount you are intending to deposit: \n Answer: ");
        String amount = scanner.nextLine();
        try {
            FileWriter depositFiles = new FileWriter("./src/main/java/com/iv/Transactions.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(depositFiles);

            bufferedWriter.write("\n" + date + "|" + time + "|" + desc + "|" + vendor + "|" + amount);

            System.out.println("Deposit successful!");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Deposit unsuccessful, error code 1053R");
            e.printStackTrace();
        }
    }
    static void ledger() {

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
                    reports();
                    break;
                case "5":
                    System.out.println("Heading back to the Home Page.");
                    break;
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
//    public class Vendor {
//        private String name;
//
//        public Vendor(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
    public static void reports() {
        String reportInput;

        Scanner scanner = new Scanner(System.in);

        int totalNumOfVendors = 9;

        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t 1: Month to date reports");
            System.out.println("\t 2: Previous month reports");
            System.out.println("\t 3: Year to date reports");
            System.out.println("\t 4: Previous year reports");
            System.out.println("\t 5: Search by Vendor");
            System.out.println("\t 6: BACK");

            reportInput = scanner.nextLine();

            switch (reportInput) {
                case "1":
                    monthToDate();
                    break;
                case "2":
                    previousMonth();
                    break;
                case "3":
                    yearToDate();
                    break;
                case "4":
                    previousYear();
                    break;
                case "5":
                    System.out.println("Please type the name of the vendor you would like to search up. \n Name: ");
                    String userInput = scanner.next();

                    break;
                case "6":
                    System.out.println("I guess you can leave me all alone by myself then");
                    break;
                default:
                    System.out.println("Invalid input you Bozo, put in the right name next time.");
            }
        } while (!reportInput.equalsIgnoreCase("6"));
    }


    static void monthToDate() {
        LocalDate userInput = LocalDate.of(2023, 5, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public static void previousMonth() {
        LocalDate userInput = LocalDate.of(2023, 3, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
//        LocalDate latePayment = LocalDate.parse(userInput);
//        return userInput;
    }

    public static void previousYear() {
        LocalDate userInput = LocalDate.of(2022, 10, 9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public static void yearToDate() {
        LocalDate userInput = LocalDate.of(2023, 1, 19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public static void searchByVendor() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type the name of the vendor you would like to search up. \n Name: ");
        String userInput = scanner.next();

//        String currentVendor = vendors
    }
}
//2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50
//2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00