package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an operation:");
            System.out.println("1. Create a new customer");
            System.out.println("2. Get all customers");
            System.out.println("3. Get a customer by ID");
            System.out.println("4. Update a customer");
            System.out.println("5. Delete a customer");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Create a new customer
                    Customer newCustomer = new Customer();
                    System.out.print("Enter first name: ");
                    newCustomer.setFirstName(scanner.nextLine());
                    System.out.print("Enter last name: ");
                    newCustomer.setLastName(scanner.nextLine());
                    System.out.print("Enter email: ");
                    newCustomer.setEmail(scanner.nextLine());
                    System.out.print("Enter phone number: ");
                    newCustomer.setPhoneNumber(scanner.nextLine());
                    System.out.print("Enter address: ");
                    newCustomer.setAddress(scanner.nextLine());
                    System.out.print("Enter city: ");
                    newCustomer.setCity(scanner.nextLine());
                    System.out.print("Enter state: ");
                    newCustomer.setState(scanner.nextLine());
                    System.out.print("Enter zip code: ");
                    newCustomer.setZipCode(scanner.nextLine());
                    customerDAO.saveCustomer(newCustomer);
                    System.out.println("Customer created successfully!");
                    break;

                case 2:
                    // Get all customers
                    List<Customer> customers = customerDAO.getCustomers();
                    System.out.println("List of customers:");
                    for (Customer customer : customers) {
                        System.out.println(customer);
                    }
                    break;

                case 3:
                    // Get a customer by ID
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    Customer customer = customerDAO.getCustomerById(customerId);
                    if (customer != null) {
                        System.out.println("Customer details: " + customer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    // Update a customer
                    System.out.print("Enter customer ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Customer existingCustomer = customerDAO.getCustomerById(updateId);
                    if (existingCustomer != null) {
                        System.out.print("Enter new first name (current: " + existingCustomer.getFirstName() + "): ");
                        existingCustomer.setFirstName(scanner.nextLine());
                        System.out.print("Enter new last name (current: " + existingCustomer.getLastName() + "): ");
                        existingCustomer.setLastName(scanner.nextLine());
                        System.out.print("Enter new email (current: " + existingCustomer.getEmail() + "): ");
                        existingCustomer.setEmail(scanner.nextLine());
                        System.out.print("Enter new phone number (current: " + existingCustomer.getPhoneNumber() + "): ");
                        existingCustomer.setPhoneNumber(scanner.nextLine());
                        System.out.print("Enter new address (current: " + existingCustomer.getAddress() + "): ");
                        existingCustomer.setAddress(scanner.nextLine());
                        System.out.print("Enter new city (current: " + existingCustomer.getCity() + "): ");
                        existingCustomer.setCity(scanner.nextLine());
                        System.out.print("Enter new state (current: " + existingCustomer.getState() + "): ");
                        existingCustomer.setState(scanner.nextLine());
                        System.out.print("Enter new zip code (current: " + existingCustomer.getZipCode() + "): ");
                        existingCustomer.setZipCode(scanner.nextLine());
                        customerDAO.updateCustomer(existingCustomer);
                        System.out.println("Customer updated successfully!");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    // Delete a customer
                    System.out.print("Enter customer ID to delete: ");
                    int deleteId = scanner.nextInt();
                    customerDAO.deleteCustomer(deleteId);
                    System.out.println("Customer deleted successfully!");
                    break;

                case 6:
                    // Exit the program
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
