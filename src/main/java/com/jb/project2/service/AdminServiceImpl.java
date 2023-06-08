package com.jb.project2.service;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ClientService implements AdminService {

    @Override
    public boolean login(String email, String password) throws CouponSystemException {
        String adminEmail = "admin@admin.com";
        String adminPassword = "admin";
        if (adminEmail.equals(email) && adminPassword.equals(password)) {
            return true;
        }
        throw new CouponSystemException(ErrMsg.ADMIN_LOGIN_ERROR);

    }

    @Override
    public void addCompany(Company company) throws CouponSystemException {
        if (company.getName().length() < 3) {
            throw new CouponSystemException(ErrMsg.COMPANY_MINIMUM_2_NOTES_LONG);
        }
        if (company.getPassword().length() < 10) {
            throw new CouponSystemException(ErrMsg.COMPANY_PASSWORD_MINIMUM_10_NOTES_LONG);
        }
        if (company.getEmail().length() < 10) {
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_MINIMUM_10_NOTES_LONG);
        }
        if (companyRepository.findByName(company.getName()) != null) {
            throw new CouponSystemException(ErrMsg.DB_DUPLICATE_COMPANY_NAME);
        }
        if (companyRepository.findByEmail(company.getEmail()) != null) {
            throw new CouponSystemException(ErrMsg.DB_DUPLICATE_COMPANY_EMAIL);
        }
        companyRepository.save(company);
    }

    @Override
    public void addCompaniesListToDB(List<Company> companies) throws CouponSystemException {
        for (Company company : companies) {
            if (company.getName().length() < 3) {
                throw new CouponSystemException(ErrMsg.COMPANY_NAME_MINIMUM_2_NOTES_LONG);
            }
            if (company.getPassword().length() < 10) {
                throw new CouponSystemException(ErrMsg.COMPANY_PASSWORD_MINIMUM_10_NOTES_LONG);
            }
            if (company.getEmail().length() < 10) {
                throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_MINIMUM_10_NOTES_LONG);
            }
            if (companyRepository.findByName(company.getName()) != null) {
                throw new CouponSystemException(ErrMsg.DB_DUPLICATE_COMPANY_NAME);
            }
            if (companyRepository.findByEmail(company.getEmail()) != null) {
                throw new CouponSystemException(ErrMsg.DB_DUPLICATE_COMPANY_EMAIL);
            }
            companyRepository.save(company);
        }
    }

    @Override
    public void updateCompany(Company company) throws CouponSystemException {
        //System.out.println(company);
        if ((companyRepository.findByCompanyIdAndName(company.getCompanyId(), company.getName())) == null) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_CANNOT_EDIT_ID_NAME);
        }
        if (company.getName().length() < 3) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_MINIMUM_2_NOTES_LONG);
        }
        if (company.getPassword().length() < 10) {
            throw new CouponSystemException(ErrMsg.COMPANY_PASSWORD_MINIMUM_10_NOTES_LONG);
        }
        if (company.getEmail().length() < 10) {
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_MINIMUM_10_NOTES_LONG);
        }
        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(int companyID) throws CouponSystemException {
        Company companyForDelete = companyRepository.findById(companyID).orElseThrow(() -> new CouponSystemException(ErrMsg.DELETE_FAILED_COMPANY_NOT_FOUND));
        companyForDelete.getCoupons().forEach(coupon -> companyRepository.deleteById(coupon.getCouponId()));
        companyRepository.delete(companyForDelete);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getOneCompany(int companyID) throws CouponSystemException {
        if (!companyRepository.existsById(companyID)) {
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND);
        }
        return companyRepository.findById(companyID);
    }

    @Override
    public void addCustomer(Customer customer) throws CouponSystemException {
        if (customer.getFirstName().length() < 3) {
            throw new CouponSystemException(ErrMsg.FIRST_NAME_MINIMUM_2_NOTES_LONG);
        }
        if (customer.getLastName().length() < 3) {
            throw new CouponSystemException(ErrMsg.LAST_NAME_MINIMUM_2_NOTES_LONG);
        }
        if (customer.getEmail().length() < 10) {
            throw new CouponSystemException(ErrMsg.EMAIL_MINIMUM_10_NOTES_LONG);
        }
        if (customer.getPassword().length() < 10) {
            throw new CouponSystemException(ErrMsg.PASSWORD_MINIMUM_10_NOTES_LONG);
        }
        if (customerRepository.findByEmail(customer.getEmail()) != null) {
            throw new CouponSystemException(ErrMsg.DB_DUPLICATE_CUSTOMER_EMAIL);
        }
        customerRepository.save(customer);
    }

    @Override
    public void addCustomersListToDB(List<Customer> customers) throws CouponSystemException {
        for (Customer customer : customers) {
            if (customer.getFirstName().length() < 3) {
                throw new CouponSystemException(ErrMsg.FIRST_NAME_MINIMUM_2_NOTES_LONG);
            }
            if (customer.getLastName().length() < 3) {
                throw new CouponSystemException(ErrMsg.LAST_NAME_MINIMUM_2_NOTES_LONG);
            }
            if (customer.getEmail().length() < 10) {
                throw new CouponSystemException(ErrMsg.EMAIL_MINIMUM_10_NOTES_LONG);
            }
            if (customer.getPassword().length() < 10) {
                throw new CouponSystemException(ErrMsg.PASSWORD_MINIMUM_10_NOTES_LONG);
            }
            if (customerRepository.findByEmail(customer.getEmail()) != null) {
                throw new CouponSystemException(ErrMsg.DB_DUPLICATE_CUSTOMER_EMAIL);
            }
            customerRepository.save(customer);
        }
    }


    @Override
    public void updateCustomer(Customer customer) throws CouponSystemException {
        if (!customerRepository.existsById(customer.getCustomerId())) {
            throw new CouponSystemException(ErrMsg.DB_UPDATE_FAILED_CUSTOMER_NOT_FOUND);
        }
        if (customer.getFirstName().length() < 3) {
            throw new CouponSystemException(ErrMsg.FIRST_NAME_MINIMUM_2_NOTES_LONG);
        }
        if (customer.getLastName().length() < 3) {
            throw new CouponSystemException(ErrMsg.LAST_NAME_MINIMUM_2_NOTES_LONG);
        }
        if (customer.getEmail().length() < 10) {
            throw new CouponSystemException(ErrMsg.EMAIL_MINIMUM_10_NOTES_LONG);
        }
        if (customer.getPassword().length() < 10) {
            throw new CouponSystemException(ErrMsg.PASSWORD_MINIMUM_10_NOTES_LONG);
        }
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        Customer customerForDelete = customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND));
        List<Coupon> coupons = customerForDelete.getCoupons();
        coupons.clear();
        customerForDelete.setCoupons(coupons);
        customerRepository.saveAndFlush(customerForDelete);
        customerRepository.delete(customerForDelete);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneCustomer(int customerID) throws CouponSystemException {
        if (!customerRepository.existsById(customerID)) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        return customerRepository.findById(customerID);
    }
}

