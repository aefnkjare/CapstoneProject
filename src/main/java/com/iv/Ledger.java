package com.iv;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ledger {
    Scanner scanner = new Scanner(System.in);

    public String date;
    public String time;
    public String desc;
    public String vendor;
    public float amount;

    public Ledger(String date, String time, String desc, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }

    public Ledger() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void addDeposit() {
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

    public void makePayment() {
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

    public void ledgerMenu() {

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

    public void allEntries() {
        try {
            FileReader transactions = new FileReader("./src/main/java/com/iv/Transactions.txt");
            BufferedReader bufferedReader = new BufferedReader(transactions);

            String input;

            while ((input = bufferedReader.readLine()) != null) {
                /// input split ||
                String[] splitInput = input.split(Pattern.quote("|"));

                String date = splitInput[0];
                String time = splitInput[1];
                String description = splitInput[2];
                String vendor = splitInput[3];
                float amount = Float.parseFloat(splitInput[4]);

                com.iv.Ledger ledgerItem = new com.iv.Ledger(date, time, description, vendor, amount); // [190, Madison Brown, 40, 17.50]

                System.out.printf("Item: %s, %s, %s, %s, $%.2f\n",
                        ledgerItem.getDate(),
                        ledgerItem.getTime(),
                        ledgerItem.getDesc(),
                        ledgerItem.getVendor(),
                        ledgerItem.getAmount()
                );

//                System.out.println(splitInput[]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void negativeEntries() {

    }

    public void depositEntries() {

    }

    public void reports() {
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

    public void monthToDate() {
        LocalDate userInput = LocalDate.of(2023, 5, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public void previousMonth() {
        LocalDate userInput = LocalDate.of(2023, 3, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
//        LocalDate latePayment = LocalDate.parse(userInput);
//        return userInput;
    }

    public void previousYear() {
        LocalDate userInput = LocalDate.of(2022, 10, 9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public void yearToDate() {
        LocalDate userInput = LocalDate.of(2023, 1, 19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public void searchByVendor() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type the name of the vendor you would like to search up. \n Name: ");
        String userInput = scanner.next();

//        String currentVendor = vendors
    }
}
