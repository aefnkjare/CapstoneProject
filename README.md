# CapstoneProject
Creating of the Main Menu

``` do {
            System.out.println("Please choose an option: ");
            System.out.println("\t 1: Add Deposit");
            System.out.println("\t 2: Make Payment");
            System.out.println("\t 3: Ledger Menu");
            System.out.println("\t 4: Exit");
            userInput = scanner.nextLine();
            ```
            
            

Creating of the Vendor Menu

```String ledgerInput;

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
    } ```

Creating the Reports Menu

``` public void reports() {
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
    } ```
