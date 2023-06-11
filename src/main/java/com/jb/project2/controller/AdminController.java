package com.jb.project2.controller;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public interface AdminController {

    @PostMapping("companies")
    Company addCompany(@RequestBody Company company) throws CouponSystemException;

    @PutMapping("companies/{companyId}")
    void updateCompany(@RequestBody Company company) throws CouponSystemException;

    @DeleteMapping("companies/{companyId}")
    void deleteCompany(@PathVariable int companyId) throws CouponSystemException;

    @GetMapping("companies")
    List<Company> getAllCompanies();

    @GetMapping("companies/{companyId}")
    Optional<Company> getOneCompany(@PathVariable int companyId) throws CouponSystemException;

    @PostMapping("customers")
    void addCustomer(@RequestBody Customer customer) throws CouponSystemException;

    @PutMapping("customers/{customerId}")
    void updateCustomer(@RequestBody Customer customer) throws CouponSystemException;

    @DeleteMapping("customers/{customerId}")
    void deleteCustomer(@PathVariable int customerId) throws CouponSystemException;

    @GetMapping("customers")
    List<Customer> getAllCustomers();

    @GetMapping("customers/{customerId}")
    Optional<Customer> getOneCustomer(@PathVariable int customerId) throws CouponSystemException;
}
