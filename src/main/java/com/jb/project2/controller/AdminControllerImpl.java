package com.jb.project2.controller;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.service.AdminService;
import com.jb.project2.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public class AdminControllerImpl implements AdminController {

    private final AdminServiceImpl adminService;

    @Autowired
    public AdminControllerImpl(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @Override
    @PostMapping("companies")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) throws CouponSystemException {
        adminService.addCompany(company);
        return company;
    }

    @Override
    @PutMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompany(@RequestBody Company company) throws CouponSystemException {
        adminService.updateCompany(company);
    }

    @Override
    @DeleteMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int companyId) throws CouponSystemException {
        adminService.deleteCompany(companyId);
    }

    @Override
    @GetMapping("companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @Override
    @GetMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Company> getOneCompany(@PathVariable int companyId) throws CouponSystemException {
        return adminService.getOneCompany(companyId);
    }

    @Override
    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) throws CouponSystemException {
        adminService.addCustomer(customer);
    }

    @Override
    @PutMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) throws CouponSystemException {
        adminService.updateCustomer(customer);
    }

    @Override
    @DeleteMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int customerId) throws CouponSystemException {
        adminService.deleteCustomer(customerId);
    }

    @Override
    @GetMapping("customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @Override
    @GetMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getOneCustomer(@PathVariable int customerId) throws CouponSystemException {
        return adminService.getOneCustomer(customerId);
    }
}
