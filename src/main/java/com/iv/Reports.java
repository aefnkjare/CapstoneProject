package com.iv;

import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Reports {
    public static void reports() {
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
                    System.out.println("Invalid input you Bozo, put in the right number next time.");
            }
        } while (!reportInput.equalsIgnoreCase("6"));
    }

    static void monthToDate() {
        LocalDate userInput = LocalDate.of(2023, 5,1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public static void previousMonth() {
        LocalDate userInput = LocalDate.of(2023, 3,1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
//        LocalDate latePayment = LocalDate.parse(userInput);
//        return userInput;
    }

    public static void previousYear() {
        LocalDate userInput = LocalDate.of(2022, 10,9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public static void yearToDate() {
        LocalDate userInput = LocalDate.of(2023, 1,19);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = userInput.format(formatter);
        System.out.println(formattedDate);
    }

    public static void searchByVendor() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please type the name of the vendor you would like to search up. \n Name: ");
        String userInput = scanner.next();

    }
}
class Vendor{
    private String name;

    public Vendor(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

