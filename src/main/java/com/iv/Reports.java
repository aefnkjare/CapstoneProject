package com.iv;

import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reports {
    public static void reports(){
        String reportInput;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t 1: Month to date reports");
            System.out.println("\t 2: Previous month reports");
            System.out.println("\t 3: Year to date reports");
            System.out.println("\t 4: Search by Vendor");
            System.out.println("\t 5: BACK");

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
                    System.out.println("Invalid input you Bozo, put in the right number next time.");
            }
        }while(!reportInput.equalsIgnoreCase("5"));
    }
    static void monthToDate(){
        String userInput = "08-03-2000 08:00:00 ";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        LocalDateTime timeTravelDate = LocalDateTime.parse(userInput, formatter);
    }
    public static String previousMonth(){
        String userInput = "2023-03-01";
        LocalDate latePayment = LocalDate.parse(userInput);
        return userInput;
    }
    public static void previousYear(){

    }
    public static void yearToDate(){

    }
    public static void searchByVendor(){

    }
    public static void back(){}
}
