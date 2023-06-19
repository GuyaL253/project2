package com.jb.project2.controller;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.ErrMsg;
import com.jb.project2.service.AdminServiceImpl;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.LoginManager;
import com.jb.project2.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/admin")
public class AdminControllerImpl {

    @Autowired
    private LoginManager loginManager;
    @Autowired
    private final AdminServiceImpl adminService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    public AdminControllerImpl(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }


    private void validateToken(UUID token) throws CouponSystemException {
        if (!tokenService.isValid(token, ClientType.ADMINISTRATOR)) {
            throw new CouponSystemException(ErrMsg.RESTRICTED_AREA);
        }
    }

    @PostMapping("companies")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        adminService.addCompany(company);
        return company;
    }

    @PutMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCompany(@PathVariable int companyId, @RequestBody Company company, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        adminService.updateCompany(company);
    }

    @DeleteMapping("companies/{companyId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int companyId, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        adminService.deleteCompany(companyId);
    }

    @GetMapping("companies")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> getAllCompanies(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return adminService.getAllCompanies();
    }

    @GetMapping("companies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Company> getOneCompany(@PathVariable("id") int companyId, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return adminService.getOneCompany(companyId);
    }

    @PostMapping("customers")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        adminService.addCustomer(customer);
    }

    @PutMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer customer, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        adminService.updateCustomer(customer);
    }

    @DeleteMapping("customers/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int customerId, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        adminService.deleteCustomer(customerId);
    }

    @GetMapping("customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return adminService.getAllCustomers();
    }

    @GetMapping("customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getOneCustomer(@PathVariable("id") int customerId, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return adminService.getOneCustomer(customerId);
    }

}
