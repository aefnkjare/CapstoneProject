package com.iv;

import java.util.Scanner;

public class Reports {
    public static void reports(){
        String reportInput;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Please choose an option: ");
            System.out.println("\t 1: Display All Entries");
            System.out.println("\t 2: Display Deposit Entries");
            System.out.println("\t 3: Display Payment Entries");
            System.out.println("\t 4: Reports");
            System.out.println("\t 5: Return Home");

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
                    back();
                    break;
                default:
                    System.out.println("Invalid input you Bozo, put in the right number next time.");
            }
        }while(!reportInput.equalsIgnoreCase("6"));
    }
    public static void monthToDate(){

    }
    public static void previousMonth(){

    }
    public static void previousYear(){

    }
    public static void yearToDate(){

    }
    public static void searchByVendor(){

    }
    public static void back(){

    }
}
