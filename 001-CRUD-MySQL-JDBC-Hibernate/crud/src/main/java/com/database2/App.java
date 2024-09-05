package com.database2;

public class App {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();

        // Create a new customer
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john.doe@example.com");
        customer.setPhoneNumber("1234567890");
        customer.setAddress("123 Elm Street");
        customer.setCity("Somewhere");
        customer.setState("CA");
        customer.setZipCode("90210");

        customerDAO.saveCustomer(customer);

        // Get all customers
        System.out.println("Customers:");
        for (Customer c : customerDAO.getCustomers()) {
            System.out.println(c.getFirstName() + " " + c.getLastName());
        }

        // Update a customer
        customer.setFirstName("Jane");
        customerDAO.updateCustomer(customer);

        // Delete a customer
        customerDAO.deleteCustomer(customer.getCustomerId());
    }
}
