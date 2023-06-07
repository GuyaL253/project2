package com.jb.project2.service;



import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;


import java.util.List;
import java.util.Optional;

public interface AdminService {

    void addCompany(Company company) throws CouponSystemException;

    void addCompaniesListToDB(List<Company> companies);

    void updateCompany(Company company);

    void deleteCompany(int companyID);

    List<Company> getAllCompanies();

    Optional<Company> getOneCompany(int companyID);

    void addCustomer(Customer customer);

    void addCustomersListToDB(List<Customer> customers);

    void updateCustomer(Customer customer) ;

    void deleteCustomer(int customerID);

    List<Customer> getAllCustomers();

    Optional<Customer> getOneCustomer(int customerID);
}