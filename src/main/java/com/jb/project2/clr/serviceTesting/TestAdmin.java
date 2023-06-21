package com.jb.project2.clr.serviceTesting;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.service.AdminServiceImpl;
import com.jb.project2.service.ClientType;
import com.jb.project2.security.LoginManager;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Order(2)
public class TestAdmin implements CommandLineRunner {

    private final LoginManager loginManager;
    private AdminServiceImpl adminImpl;

    @Override
    public void run(String... args) throws Exception {
        try {
            Art.sperator();
            System.out.print(Art.ADMIN_METHODS);
            adminImpl = (AdminServiceImpl) loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);

            testCompanyOperations();
            testCustomerOperations();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }

    private void testCompanyOperations() {
        try {
            System.out.println();
            Art.goodTest("Successful company add:");
            Art.BEFORE();
            List<Company> companies = adminImpl.getAllCompanies();
            Art.printCompaniesDetails(companies);
            System.out.println();
            Company addedCompany = Company.builder().name("Lenovo").email("Lenovo@gmail.com").password("455v34cc3rdrr").build();
            adminImpl.addCompany(addedCompany);
            companies = adminImpl.getAllCompanies(); // Update the companies list after adding the new company
            Art.AFTER();
            Art.printCompaniesDetails(companies);
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                Art.badTest("Unsuccessful company add - company name already exists in the DB");
                Art.BEFORE();
                Art.printCompaniesDetails(companies);
                System.out.println();
                Company company6 = Company.builder().name("Intel").email("Lenovo@gmail.com").password("455v34cc3rdrr").build();
                adminImpl.addCompany(company6);
                Art.AFTER();
                Art.printCompaniesDetails(companies);

            } catch (Exception e) {
                Art.printBad("Failed to add company: " + e.getMessage());
            }

            try {
                Art.sperator();
                Art.badTest("Unsuccessful company add - company email already exists in the DB");
                Art.BEFORE();
                Art.printCompaniesDetails(companies);
                System.out.println();
                Company company6 = Company.builder().name("SomeCompany").email("adidas@gmail.com").password("455v34cc3rdrr").build();
                adminImpl.addCompany(company6);
                Art.AFTER();
                Art.printCompaniesDetails(companies);

            } catch (Exception e) {
                System.out.println("Failed to add company: " + e.getMessage());
            }

            Art.sperator();
            Art.goodTest("Successful company update of company number 1:");
            Art.BEFORE();
            System.out.println("\u001B[34m" + adminImpl.getOneCompany(1).orElse(null) + "\u001B[0m"); // Blue color for output
            System.out.println();
            Company existingCompany = adminImpl.getOneCompany(1).orElse(null);
            if (existingCompany != null) {
                Company updatedCompany = Company.builder()
                        .companyId(existingCompany.getCompanyId())
                        .name("Nike")
                        .email("updatedCompany@gmail.com")
                        .password("password123456")
                        .coupons(existingCompany.getCoupons())
                        .build();
                adminImpl.updateCompany(updatedCompany);
                companies = adminImpl.getAllCompanies(); // Update the companies list after adding the new company
            }
            Art.AFTER();
            System.out.println();
            System.out.println("Updated Company:");
            System.out.println("\u001B[32m" + adminImpl.getOneCompany(1).orElse(null) + "\u001B[0m"); // Green color for output
            System.out.println();
            Art.sperator();


            try {
                System.out.println();
                Art.badTest("Unsuccessful company update - can't change the company's name");
                Art.BEFORE();
                System.out.println(adminImpl.getOneCompany(1));
                System.out.println();
                Company updatedCompany2 = Company.builder().companyId(1).name("UpdatedMicrosoft").email("updatedCompany@gmail.com").password("y2524234235yy").build();
                adminImpl.updateCompany(updatedCompany2);
                Art.AFTER();
                System.out.println(adminImpl.getOneCompany(1));
            } catch (Exception e) {
                System.out.println("Failed to update company: " + e.getMessage());
            }

            try {
                Art.sperator();
                Art.badTest("Unsuccessful company update - can't change the company's id");
                Art.BEFORE();
                System.out.println(adminImpl.getOneCompany(1));
                System.out.println();
                Company updatedCompany3 = Company.builder().companyId(2).name("UpdatedMicrosoft").email("updatedCompany@gmail.com").password("y2524234235yy").build();
                adminImpl.updateCompany(updatedCompany3);
                Art.AFTER();
                System.out.println(adminImpl.getOneCompany(1));
            } catch (Exception e) {
                System.out.println("Failed to update company: " + e.getMessage());
            }

            // Delete company
            Art.sperator();
            Art.goodTest("Successful company delete of company number 3:");
            System.out.println("In the database: please notice that all of the company coupons were deleted from the coupon table.");
            System.out.println("In the database: please notice that all of the clients' purchase history of that company's coupons were deleted from the customer-VS-coupons table.");
            System.out.println();
            Art.BEFORE();
            Art.printCompaniesDetails(companies);

            // Delete associated records in customers_coupons table
            adminImpl.deleteCompanyCoupons(3);

            System.out.println();
            adminImpl.deleteCompany(3);
            companies = adminImpl.getAllCompanies(); // Update the companies list after deleting the company
            Art.AFTER();
            Art.printCompaniesDetails(companies);

            System.out.println();
            Art.sperator();


            try {
                System.out.println();
                Art.badTest("Unsuccessful company delete - can't delete an un-existing company (number 7)");
                Art.BEFORE();
                Art.printCompaniesDetails(companies);
                System.out.println();
                adminImpl.deleteCompany(7);
                Art.AFTER();
                Art.printCompaniesDetails(companies);
            } catch (Exception e) {
                System.out.println("Failed to delete company: " + e.getMessage());
            }

            // Retrieve all companies
            Art.sperator();
            Art.goodTest("Successful receive of all companies in the company table:");
            Art.printCompaniesDetails(companies);
            System.out.println();
            Art.sperator();

            // Retrieve one company
            System.out.println();
            Art.goodTest("Successful receive of one existing company (company number 4):");
            System.out.println(adminImpl.getOneCompany(4));
            System.out.println();

            try {
                Art.sperator();
                Art.badTest("Unsuccessful receive of an un-existing company (number 10)");
                System.out.println(adminImpl.getOneCompany(10));
            } catch (Exception e) {
                System.out.println("Failed to retrieve company: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error in company operations: " + e.getMessage());
        }
    }

    private void testCustomerOperations() {
        try {
            List<Customer> customers = adminImpl.getAllCustomers();
            System.out.println();
            Art.goodTest("Successful customer add:");
            Art.BEFORE();
            Art.printCustomersDetails(customers);
            System.out.println();
            Customer customerAdded = Customer.builder().firstName("Guy").lastName("Almog").email("guy@gmail.com").password("j8fer4eff7j6").build();
            adminImpl.addCustomer(customerAdded);
            customers = adminImpl.getAllCustomers(); // Update the customers list after adding the new customer
            Art.AFTER();
            Art.printCustomersDetails(customers);
            System.out.println();


            try {
                Art.sperator();
                Art.badTest("Unsuccessful customer add - can't add a customer with an email that already exists in the DB");
                Art.BEFORE();
                Art.printCustomersDetails(customers);
                System.out.println();
                Customer customerAdded2 = Customer.builder().firstName("John").lastName("Doe").email("guy@gmail.com").password("j87jf4redefe6").build();
                adminImpl.addCustomer(customerAdded2);
                Art.AFTER();
                Art.printCustomersDetails(customers);
            } catch (Exception e) {
                System.out.println("Failed to add customer: " + e.getMessage());
            }

            // Update customer
            Art.sperator();
            Art.goodTest("Successful customer update of customer number 1:");
            Art.BEFORE();
            System.out.println(adminImpl.getOneCustomer(1));
            System.out.println();
            Customer updatedCustomer = Customer.builder().customerId(1).firstName("UpdatedFirstName").lastName("UpdatedLastName").email("updatedCustomer@gmail.com").password("password123456").build();
            adminImpl.updateCustomer(updatedCustomer);
            Art.AFTER();
            System.out.println(adminImpl.getOneCustomer(1));
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                Art.badTest("Unsuccessful customer update - can't change the customer's id");
                Art.BEFORE();
                System.out.println(adminImpl.getOneCustomer(2));
                System.out.println();
                Customer updatedCustomer2 = Customer.builder().customerId(1).firstName("UpdatedFirstName").lastName("UpdatedLastName").email("updatedCustomer@gmail.com").password("password123456").build();
                adminImpl.updateCustomer(updatedCustomer2);
                Art.AFTER();
                System.out.println(adminImpl.getOneCustomer(2));
            } catch (Exception e) {
                System.out.println("Failed to update customer: " + e.getMessage());
//                todo semek aars
            }


            // Delete customer
            Art.sperator();
            Art.goodTest("Successful customer delete of customer number 5:");
            System.out.println("In the database: please notice that all of the customer's purchase history of coupons were deleted from the customer-VS-coupons table.");
            System.out.println();
            Art.BEFORE();
            Art.printCustomersDetails(customers);
            System.out.println();
            adminImpl.deleteCustomer(5);
            Art.AFTER();
            customers = adminImpl.getAllCustomers(); // Update the customers list after adding the new customer
            Art.printCustomersDetails(customers);
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                Art.badTest("Unsuccessful customer delete - can't delete an un-existing customer (number 40)");
                Art.BEFORE();
                Art.printCustomersDetails(customers);
                System.out.println();
                adminImpl.deleteCustomer(40);
                Art.AFTER();
                Art.printCustomersDetails(customers);
            } catch (Exception e) {
                System.out.println("Failed to delete customer: " + e.getMessage());
            }

            // Retrieve all customers
            System.out.println();
            Art.goodTest("Successful receive of all customers in the customer table:");
            Art.printCustomersDetails(customers);
            System.out.println();
            Art.sperator();

            // Retrieve one customer
            System.out.println();
            Art.goodTest("Successful receive of one existing customer (customer number 3):");
            System.out.println(adminImpl.getOneCustomer(3));
            System.out.println();

            try {
                Art.sperator();
                Art.badTest("Unsuccessful receive of an un-existing customer (number 159)");
                System.out.println(adminImpl.getOneCustomer(159));
            } catch (Exception e) {
                System.out.println("Failed to retrieve customer: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error in customer operations: " + e.getMessage());
        }
    }
}
