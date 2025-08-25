package com.mycompany.ammar_project;

import java.util.Scanner;
import java.util.Random;

public class Ammar_project{
    private static Inventory inventory = new Inventory();
    private static double totalPrice = 0;
    private static String customerName;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to Smart Buy!");
        System.out.print("Please enter your name: ");
        customerName = scanner.nextLine();

        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Buy a Device");
            System.out.println("2. Show Invoice");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    showDeviceMenu(scanner);
                    break;
                case 2:
                    showInvoice();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for visiting Smart Buy, " + customerName + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showDeviceMenu(Scanner scanner) {
        System.out.println("\nAvailable Devices:");
        System.out.println("1. Fridge");
        System.out.println("2. AC");
        System.out.println("3. Monitor");
        System.out.println("4. Phone");
        System.out.print("Enter the number of the device you want to buy: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        switch (choice) {
            case 1:
                addFridge(scanner);
                break;
            case 2:
                addAC(scanner);
                break;
            case 3:
                addMonitor(scanner);
                break;
            case 4:
                addPhone(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static void addFridge(Scanner scanner) {
        System.out.println("\nChoose a Fridge Brand:");
        System.out.println("1. Beko");
        System.out.println("2. LG");
        System.out.println("3. Samsung");
        int brandChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Serial No: ");
        String serialNo = scanner.nextLine();
        System.out.print("Enter Model: ");
        int model = scanner.nextInt();
        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter Height: ");
        double height = scanner.nextDouble();
        System.out.print("Enter Doors (1 or 2): ");
        int doors = scanner.nextInt();

        Fridge fridge = new Fridge(price, "Fridge", serialNo, model, weight, height, brandChoice, doors);
        inventory.addDevice(fridge);
        totalPrice += PricingCalculator.calculatePrice(fridge);
        System.out.println("Fridge added to your cart!");
    }

    private static void addAC(Scanner scanner) {
        System.out.println("\nChoose an AC Brand:");
        System.out.println("1. LG");
        System.out.println("2. GoGreen");
        int brandChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Serial No: ");
        String serialNo = scanner.nextLine();
        System.out.print("Enter Model: ");
        int model = scanner.nextInt();
        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();

        Ac ac = new Ac(price, "AC", serialNo, model, weight, brandChoice);
        inventory.addDevice(ac);
        totalPrice += PricingCalculator.calculatePrice(ac);
        System.out.println("AC added to your cart!");
    }

    private static void addMonitor(Scanner scanner) {
        System.out.println("\nChoose a Monitor Brand:");
        System.out.println("1. G-Guard");
        System.out.println("2. Samsung");
        System.out.println("3. TCL");
        int brandChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        System.out.print("Enter Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Serial No: ");
        String serialNo = scanner.nextLine();
        System.out.print("Enter Model: ");
        int model = scanner.nextInt();
        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter Size: ");
        int size = scanner.nextInt();

        Monitors monitor = new Monitors(price, "Monitor", serialNo, model, weight, size, brandChoice);
        inventory.addDevice(monitor);
        totalPrice += PricingCalculator.calculatePrice(monitor);
        System.out.println("Monitor added to your cart!");
    }

    private static void addPhone(Scanner scanner) {
        System.out.println("\nChoose a Phone Brand:");
        System.out.println("1. iPhone");
        System.out.println("2. Samsung");
        int brandChoice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Serial No: ");
        String serialNo = scanner.nextLine();
        System.out.print("Enter Model: ");
        int model = scanner.nextInt();
        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter Storage (in GB): ");
        int storage = scanner.nextInt();

        Phones phone = new Phones(price, "Phone", serialNo, model, storage, weight, brandChoice);
        inventory.addDevice(phone);
        totalPrice += PricingCalculator.calculatePrice(phone);
        System.out.println("Phone added to your cart!");
    }

    private static void showInvoice() {
        if (inventory.getDevices().isEmpty()) {
            System.out.println("\nYour cart is empty!");
            return;
        }

        Random random = new Random();
        int invoiceNumber = random.nextInt(9875 - 6499 + 1) + 6499;

        System.out.println("\nInvoice:");
        System.out.println("==============================================");
        System.out.printf("Customer Name: %s%n", customerName);
        System.out.printf("Invoice Number: %d%n", invoiceNumber);
        System.out.println("==============================================");
        System.out.printf("%-20s %-15s %-10s%n", "Device", "Type", "Price");
        System.out.println("----------------------------------------------");
        for (Device device : inventory.getDevices()) {
            System.out.printf("%-20s %-15s $%-10.2f%n",
                    device.getClass().getSimpleName(),  // Print class name like Fridge, Ac
                    device.getType(),  // Use the implemented getType method
                    PricingCalculator.calculatePrice(device));
        }
        System.out.println("----------------------------------------------");
        System.out.printf("Total Price: $%.2f%n", totalPrice);
        System.out.println("==============================================");
    }
}
