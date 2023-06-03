package main.core;

import main.utils.InvoiceGeneratorHTTP;
import main.utils.ProcessData;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// @@ https://blog.terresquall.com/2022/08/javas-scanner-nextline-call-is-being-skipped/

public class ConsoleMenu {

    private Scanner userInput;
    private Data search;
    private ProcessData find;
    public ConsoleMenu() {
        userInput = new Scanner(System.in);
        search = new Data();
        find = new ProcessData();
    }

    public void principalMenu() {

        int choice = 0;

        while (choice != 2) {

            try {
                principal();
                choice = userInput.nextInt();

                if (choice == 1) loginOption();

            } catch (NumberFormatException | InputMismatchException e) {
                System.err.println("Invalid option!");
                userInput.nextLine();
            }
        }
    }

    private void loginOption() {

        int choice = 0;

        while (choice != 4) {

            try {
                logged();
                choice = userInput.nextInt();

                if (choice == 1) {
                    userInput.nextLine();
                    System.out.println("Please, enter the name to search:");
                    searchByName(userInput.nextLine());
                }

                if (choice == 2) {
                    userInput.nextLine();
                    System.out.println("Please, enter the ID to search:");
                    searchByID(userInput.nextLine());
                }

                if (choice == 3) {
                    userInput.nextLine();
                    System.out.println("Insert the customer ID:");
                    workWithUserOption(userInput.nextLine());
                }

            } catch (NumberFormatException | InputMismatchException e) {
                System.err.println("Invalid option!");
                userInput.nextLine();
            }
        }
    }

    private void searchByName(String name) {
        List<Customer> data = search.findCustomerByName(name);
        if (data.size() > 0) {
            customerList(data);
        }
    }

    private void searchByID(String ID) {
        List<Customer> data = search.findCustomerByID(ID);
        if (data.size() > 0) {
            customerList(data);
        }
    }

 private void workWithUserOption(String ID) {

     List<Customer> data = search.findCustomerByID(ID);

     if (data.size() == 1) {
         String customerId = data.get(0).getIdCustomer();
         String customerName = data.get(0).getNameCustomer();
         String customerAddress = data.get(0).getAddress();

         int choiceWorkWith = 0;
         while (choiceWorkWith != 4) {

             try {
                 actionsCustomer();

                 choiceWorkWith = userInput.nextInt();

                 if (choiceWorkWith == 1) findBillingByDate(ID);

                 if (choiceWorkWith == 2) findBillingByRangeDate(ID);

                 if (choiceWorkWith == 3) generateInvoiceOption(customerId, customerName, customerAddress);

             } catch (NumberFormatException | InputMismatchException e) {
                 System.err.println("Invalid option!");
                 userInput.nextLine();
             }
         }
     }
 }

    private void findBillingByDate(String customerId) {

        userInput.nextLine();
        System.out.println("Insert the period [MM/YYYY]");
        String date = userInput.nextLine();

        List<Billing> getMonthBill = find.findSpecificMonthBill(customerId, date);

        if (getMonthBill != null) {
            if (getMonthBill.size() != 0) {
                billSpecificMonth(getMonthBill, customerId, date);
            }
        }
    }

    private void findBillingByRangeDate(String customerId) {

        userInput.nextLine();
        System.out.println("Insert the first period [DD/MM/YYYY]");
        String date = userInput.nextLine();

        System.out.println("Insert the second period [DD/MM/YYYY]");
        String date2 = userInput.nextLine();

        List<String> info = find.allUsage(customerId, date, date2);

        if (info != null) {
            billRangeMonth(info);
        }
    }

    private void generateInvoiceOption(String customerId, String customerName, String customerAddress) {

        userInput.nextLine();
        System.out.println("Insert the period [MM/YYYY]");
        String date = userInput.nextLine();
        List<Billing> dataBilling = find.findSpecificMonthBill(customerId, date);
        if (dataBilling != null) {
            if ((dataBilling.size() > 0)) {
                for (Billing b: dataBilling) {
                    InvoiceGeneratorHTTP invoice = new InvoiceGeneratorHTTP();
                    System.out.println(invoice.generateInvoice("customerName", customerName, "customerAddress", customerAddress, "reportId", String.valueOf(b.getIdReport()), "secondDate", b.getSecondDate(), "priceMonth", String.valueOf(find.priceCalc(b.getIdCustomer(),b.getFirstDate()))));
                }
            }
        }
    }

}
