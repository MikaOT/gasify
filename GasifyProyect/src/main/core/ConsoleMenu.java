package main.core;

import main.utils.TableList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    public void principalMenu() {

        int choice = 0;

        while (choice != 2) {
            Scanner input = new Scanner(System.in);

            try {

                TableList tl = new TableList(2, "Number", "Option Name").sortBy(0).withUnicode(true);
                tl.addRow("1.", "Login");
                tl.addRow("2.", "Exit");
                tl.print();

                choice = input.nextInt();
                if (choice == 1) loginOption();

            } catch (NumberFormatException | InputMismatchException e) {
                System.err.println("Invalid option!");
                input.nextLine();
            }

        }

    }

    private void loginOption() {

        int choice = 0;

        while (choice != 3) {
            Scanner input = new Scanner(System.in);

            try {

                TableList tl = new TableList(2, "Number", "Option Name").sortBy(0).withUnicode(true);
                tl.addRow("1.", "Find Costumer by Name");
                tl.addRow("2.", "Find Costumer by ID");
                tl.addRow("3.", "Exit");
                tl.print();

                choice = input.nextInt();
                if (choice == 1) loginOption();

            } catch (NumberFormatException | InputMismatchException e) {
                System.err.println("Invalid option!");
                input.nextLine();
            }

        }

    }

}
