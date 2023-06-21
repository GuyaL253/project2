package com.jb.project2.service;



import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;


import java.util.List;
import java.util.Optional;

public interface AdminService {

    void addCompany(Company company) throws CouponSystemException;

    void addCompaniesListToDB(List<Company> companies) throws CouponSystemException;

    void updateCompany(Company company) throws CouponSystemException;

    void deleteCompany(int companyID) throws CouponSystemException;
    void deleteCompanyCoupons(int companyId) throws CouponSystemException;

    List<Company> getAllCompanies();

    Optional<Company> getOneCompany(int companyID) throws CouponSystemException;

    void addCustomer(Customer customer) throws CouponSystemException;

    void addCustomersListToDB(List<Customer> customers) throws CouponSystemException;

    void updateCustomer(Customer customer) throws CouponSystemException;

    void deleteCustomer(int customerID) throws CouponSystemException;

    List<Customer> getAllCustomers();

    Optional<Customer> getOneCustomer(int customerID) throws CouponSystemException;
}