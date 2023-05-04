package com.iv;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LedgerLine {
    Scanner scanner = new Scanner(System.in);

    public String date;
    public String time;
    public String desc;
    public String vendor;
    public float amount;

    public LedgerLine(String date, String time, String desc, String vendor, float amount) {
        this.date = date;
        this.time = time;
        this.desc = desc;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LedgerLine() {

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
        } catch (Exception e) {
            System.out.println("Deposit unsuccessful, error code 1053R");
            e.printStackTrace();
        }
    }

    public void makePayment() {
        try {
            System.out.println("Please provide the date of your payment(yyyy-MM-DD): \n Answer: ");
            String date = scanner.nextLine();

            System.out.println("Please provide the time of your payment(hh:MM:ss): \n Answer: ");
            String time = scanner.nextLine();

            System.out.println("Please provide a description: \n Answer: ");
            String desc = scanner.nextLine();

            System.out.println("Please provide the vendor: \n Answer: ");
            String vendor = scanner.nextLine();

            System.out.println("Please provide the amount you are intending to pay: \n Answer: ");
            Float amount = scanner.nextFloat();
        } catch(Exception e){
            if(true) {
                System.out.println("Hey, you did something wrong. Please try again.");
            }
        }
        try {
            FileWriter depositFiles = new FileWriter("./src/main/java/com/iv/Transactions.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(depositFiles);

            bufferedWriter.write("\n" + date + "|" + time + "|" + desc + "|" + vendor + "|" + "-" + amount);

            System.out.println("Payment successful!");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Payment unsuccessful, error code 1053R");
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
                    paymentEntries();
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
    public void printEntries(String filter, LocalDate start, LocalDate end) {
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

                LedgerLine ledgerItem = new LedgerLine(date, time, description, vendor, amount); // [190, Madison Brown, 40, 17.50]

                if(filter.equals("negative")&&amount<0){
                    System.out.printf("Item: %s, %s, %s, %s, $%.2f\n",
                            ledgerItem.getDate(),
                            ledgerItem.getTime(),
                            ledgerItem.getDesc(),
                            ledgerItem.getVendor(),
                            ledgerItem.getAmount()
                    );
                    continue;
                }
                if(filter.equals("positive")&&amount>0) {
                    System.out.printf("Item: %s, %s, %s, %s, $%.2f\n",
                            ledgerItem.getDate(),
                            ledgerItem.getTime(),
                            ledgerItem.getDesc(),
                            ledgerItem.getVendor(),
                            ledgerItem.getAmount()
                    );
                    continue;
                }
                if(filter.equals("all")) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate transactionDate = LocalDate.parse(date, formatter);
                    if(start!=null && end!=null) {

                        if ((transactionDate.isAfter(start)||transactionDate.isEqual(start))
                                && (transactionDate.isBefore(end)||transactionDate.isEqual(end))) {
                            System.out.printf("Item: %s, %s, %s, %s, $%.2f\n",
                                    ledgerItem.getDate(),
                                    ledgerItem.getTime(),
                                    ledgerItem.getDesc(),
                                    ledgerItem.getVendor(),
                                    ledgerItem.getAmount()
                            );
                        }
                        continue;

                    }
                    System.out.printf("Item: %s, %s, %s, %s, $%.2f\n",
                            ledgerItem.getDate(),
                            ledgerItem.getTime(),
                            ledgerItem.getDesc(),
                            ledgerItem.getVendor(),
                            ledgerItem.getAmount()
                    );
                }

//                System.out.println(splitInput[]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");
    }
        public void allEntries () {
            printEntries("all", null,null);
        }

    public void paymentEntries() {
        printEntries("negative",null, null);
    }

    public void depositEntries() {
        printEntries("positive",null ,null);
    }

    public void reports() {
        String reportInput;

        Scanner scanner = new Scanner(System.in);

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
                    searchByVendor();
                    break;
                case "6":
                    System.out.println("I guess you can leave me all alone by myself then");
                    break;
                default:
                    System.out.println("Invalid input you Bozo, put in the right name next time.");
            }
        } while (!reportInput.equalsIgnoreCase("6"));
    }
    public String zeroPaddedMonthDay(int monthDay){
        if (monthDay<10){
            return "0"+monthDay;
        }
        return ""+monthDay;
    }

    public void monthToDate() {
        // Identify today's date (LocalDate)
        //
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(endDate.getYear() + "-" + zeroPaddedMonthDay(endDate.getMonthValue())
                + "-" + zeroPaddedMonthDay(1), formatter);
        printEntries("all", startDate, endDate);
    }

    public void previousMonth() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate previousMonthDate = currentDate.minusMonths(1);
        LocalDate startDate = LocalDate.parse(previousMonthDate.getYear() + "-" + zeroPaddedMonthDay(previousMonthDate.getMonthValue())
                + "-" + zeroPaddedMonthDay(1), formatter);
        LocalDate endDate = LocalDate.parse(previousMonthDate.getYear() + "-" + zeroPaddedMonthDay(previousMonthDate.getMonthValue())
                + "-" + zeroPaddedMonthDay(previousMonthDate.lengthOfMonth()), formatter);
        printEntries("all", startDate, endDate);
//        LocalDate latePayment = LocalDate.parse(userInput);
//        return userInput;
    }

    public void previousYear() {
        LocalDate currentYear = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate previousYear = currentYear.minusYears(1);
        LocalDate startDate = LocalDate.parse(previousYear.getYear() + "-" + zeroPaddedMonthDay(1) + "-" + zeroPaddedMonthDay(1));
        LocalDate endDate = LocalDate.parse(previousYear.getYear() + "-" + zeroPaddedMonthDay(12) + "-" + zeroPaddedMonthDay(31));
        printEntries("all", startDate, endDate);
    }

    public void yearToDate() {
        LocalDate endDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(endDate.getYear() + "-" + zeroPaddedMonthDay(1) + "-" + zeroPaddedMonthDay(1));
        printEntries("all", startDate, endDate);
    }

    public void searchByVendor() {
        System.out.println("Please type the name of the vendor you would like to search up. \n Name: ");
        String userInput = scanner.next();

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

                LedgerLine ledgerItem = new LedgerLine(date, time, description, vendor, amount); // [190, Madison Brown, 40, 17.50]

                if (vendor.equalsIgnoreCase(userInput)) {

                    System.out.printf("Item: %s, %s, %s, %s, $%.2f\n",
                            ledgerItem.getDate(),
                            ledgerItem.getTime(),
                            ledgerItem.getDesc(),
                            ledgerItem.getVendor(),
                            ledgerItem.getAmount()
                    );
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");
//        String currentVendor = vendors
    }
}
