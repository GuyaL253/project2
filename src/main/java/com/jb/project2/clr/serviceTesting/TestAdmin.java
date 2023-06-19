package com.jb.project2.clr.serviceTesting;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.service.AdminServiceImpl;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.LoginManager;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
            System.out.println();
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
            System.out.println("Successful company add:");
            System.out.println("Before:");
            adminImpl.getAllCompanies().forEach(System.out::println);
            System.out.println();
            Company addedCompany = Company.builder().name("Lenovo").email("Lenovo@gmail.com").password("455v34cc3rdrr").build();
            adminImpl.addCompany(addedCompany);
            System.out.println("After:");
            adminImpl.getAllCompanies().forEach(System.out::println);
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful company add - company name already exists in the DB");
                System.out.println("Before:");
                adminImpl.getAllCompanies().forEach(System.out::println);
                System.out.println();
                Company company6 = Company.builder().name("Intel").email("Lenovo@gmail.com").password("455v34cc3rdrr").build();
                adminImpl.addCompany(company6);
                System.out.println("After:");
                adminImpl.getAllCompanies().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Failed to add company: " + e.getMessage());
            }

            try {
                System.out.println();
                System.out.println("Unsuccessful company add - company email already exists in the DB");
                System.out.println("Before:");
                adminImpl.getAllCompanies().forEach(System.out::println);
                System.out.println();
                Company company6 = Company.builder().name("SomeCompany").email("adidas@gmail.com").password("455v34cc3rdrr").build();
                adminImpl.addCompany(company6);
                System.out.println("After:");
                adminImpl.getAllCompanies().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Failed to add company: " + e.getMessage());
            }

            // Update company
            System.out.println();
            System.out.println("Successful company update of company number 1:");
            System.out.println("Before:");
            System.out.println(adminImpl.getOneCompany(1));
            System.out.println();
            Company updatedCompany = Company.builder().companyId(1).name("Nike").email("updatedCompany@gmail.com").password("password123456").build();
            adminImpl.updateCompany(updatedCompany);
            System.out.println("After:");
            System.out.println(adminImpl.getOneCompany(1));
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful company update - can't change the company's name");
                System.out.println("Before:");
                System.out.println(adminImpl.getOneCompany(1));
                System.out.println();
                Company updatedCompany2 = Company.builder().companyId(1).name("UpdatedMicrosoft").email("updatedCompany@gmail.com").password("y2524234235yy").build();
                adminImpl.updateCompany(updatedCompany2);
                System.out.println("After:");
                System.out.println(adminImpl.getOneCompany(1));
            } catch (Exception e) {
                System.out.println("Failed to update company: " + e.getMessage());
            }

            try {
                System.out.println();
                System.out.println("Unsuccessful company update - can't change the company's id");
                System.out.println("Before:");
                System.out.println(adminImpl.getOneCompany(1));
                System.out.println();
                Company updatedCompany3 = Company.builder().companyId(2).name("UpdatedMicrosoft").email("updatedCompany@gmail.com").password("y2524234235yy").build();
                adminImpl.updateCompany(updatedCompany3);
                System.out.println("After:");
                System.out.println(adminImpl.getOneCompany(1));
            } catch (Exception e) {
                System.out.println("Failed to update company: " + e.getMessage());
            }

            // Delete company
            System.out.println();
            System.out.println("Successful company delete of company number 3:");
            System.out.println("In the database: please notice that all of the company coupons were deleted from the coupon table.");
            System.out.println("In the database: please notice that all of the clients purchase history of that company coupons were deleted from the customer-VS-coupons table.");
            System.out.println();
            System.out.println("Before:");
            adminImpl.getAllCompanies().forEach(System.out::println);
            System.out.println();
            adminImpl.deleteCompany(3);
            System.out.println("After:");
            adminImpl.getAllCompanies().forEach(System.out::println);
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful company delete - can't delete an un-existing company (number 7)");
                System.out.println("Before:");
                adminImpl.getAllCompanies().forEach(System.out::println);
                System.out.println();
                adminImpl.deleteCompany(7);
                System.out.println("After:");
                adminImpl.getAllCompanies().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Failed to delete company: " + e.getMessage());
            }

            // Retrieve all companies
            System.out.println();
            System.out.println("Successful receive of all companies in the company table:");
            adminImpl.getAllCompanies().forEach(System.out::println);
            System.out.println();
            Art.sperator();

            // Retrieve one company
            System.out.println();
            System.out.println("Successful receive of one existing company (company number 4):");
            System.out.println(adminImpl.getOneCompany(4));
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful receive of an un-existing company (number 10)");
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
            System.out.println();
            System.out.println("Successful customer add:");
            System.out.println("Before:");
            adminImpl.getAllCustomers().forEach(System.out::println);
            System.out.println();
            Customer customerAdded = Customer.builder().firstName("Guy").lastName("Almog").email("guy@gmail.com").password("j8fer4eff7j6").build();
            adminImpl.addCustomer(customerAdded);
            System.out.println("After:");
            adminImpl.getAllCustomers().forEach(System.out::println);
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful customer add - can't add a customer with an email that already exists in the DB");
                System.out.println("Before:");
                adminImpl.getAllCustomers().forEach(System.out::println);
                System.out.println();
                Customer customerAdded2 = Customer.builder().firstName("John").lastName("Doe").email("avi@gmail.com").password("j87jf4redefe6").build();
                adminImpl.addCustomer(customerAdded2);
                System.out.println("After:");
                adminImpl.getAllCustomers().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Failed to add customer: " + e.getMessage());
            }

            // Update customer
            System.out.println();
            System.out.println("Successful customer update of customer number 1:");
            System.out.println("Before:");
            System.out.println(adminImpl.getOneCustomer(1));
            System.out.println();
            Customer updatedCustomer = Customer.builder().customerId(1).firstName("UpdatedFirstName").lastName("UpdatedLastName").email("updatedCustomer@gmail.com").password("password123456").build();
            adminImpl.updateCustomer(updatedCustomer);
            System.out.println("After:");
            System.out.println(adminImpl.getOneCustomer(1));
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful customer update - can't change the customer's id");
                System.out.println("Before:");
                System.out.println(adminImpl.getOneCustomer(1));
                System.out.println();
                Customer updatedCustomer2 = Customer.builder().customerId(2).firstName("UpdatedFirstName").lastName("UpdatedLastName").email("updatedCustomer@gmail.com").password("password123456").build();
                adminImpl.updateCustomer(updatedCustomer2);
                System.out.println("After:");
                System.out.println(adminImpl.getOneCustomer(1));
            } catch (Exception e) {
                System.out.println("Failed to update customer: " + e.getMessage());
            }

            // Delete customer
            System.out.println();
            System.out.println("Successful customer delete of customer number 5:");
            System.out.println("In the database: please notice that all of the customer's purchase history of coupons were deleted from the customer-VS-coupons table.");
            System.out.println();
            System.out.println("Before:");
            adminImpl.getAllCustomers().forEach(System.out::println);
            System.out.println();
            adminImpl.deleteCustomer(5);
            System.out.println("After:");
            adminImpl.getAllCustomers().forEach(System.out::println);
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful customer delete - can't delete an un-existing customer (number 10)");
                System.out.println("Before:");
                adminImpl.getAllCustomers().forEach(System.out::println);
                System.out.println();
                adminImpl.deleteCustomer(10);
                System.out.println("After:");
                adminImpl.getAllCustomers().forEach(System.out::println);
            } catch (Exception e) {
                System.out.println("Failed to delete customer: " + e.getMessage());
            }

            // Retrieve all customers
            System.out.println();
            System.out.println("Successful receive of all customers in the customer table:");
            adminImpl.getAllCustomers().forEach(System.out::println);
            System.out.println();
            Art.sperator();

            // Retrieve one customer
            System.out.println();
            System.out.println("Successful receive of one existing customer (customer number 3):");
            System.out.println(adminImpl.getOneCustomer(3));
            System.out.println();
            Art.sperator();

            try {
                System.out.println();
                System.out.println("Unsuccessful receive of an un-existing customer (number 10)");
                System.out.println(adminImpl.getOneCustomer(10));
            } catch (Exception e) {
                System.out.println("Failed to retrieve customer: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error in customer operations: " + e.getMessage());
        }
    }
}
