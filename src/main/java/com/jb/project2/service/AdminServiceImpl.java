package com.jb.project2.service;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.dto.LoginResDto;
import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.exceptions.ErrMsg;
import com.jb.project2.security.LoginInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ClientService implements AdminService {

    @Override
    public LoginResDto login(String email, String password) throws CouponSystemException {
        boolean res = Objects.equals(email, "admin@admin.com") && Objects.equals(password, "admin");
        if (res) {
            int adminId = 0;
            tokenService.addClient(adminId, ClientType.ADMINISTRATOR);
            LoginInfo loginInfo = LoginInfo.builder()
                    .id(adminId)
                    .clientType(ClientType.ADMINISTRATOR)
                    .time(LocalDateTime.now())
                    .build();
            UUID token = tokenService.getToken(loginInfo);
            return LoginResDto.builder()
                    .id(adminId)
                    .token(token)
                    .clientType(ClientType.ADMINISTRATOR)
                    .build();
        }
        throw new CouponSystemException(ErrMsg.LOGIN_FAILED);
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
    public void updateCompany(int companyId, Company company) throws CouponSystemException {
        if (companyId != company.getCompanyId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_CANNOT_EDIT_ID);
        }
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
        Optional<Company> existingCompanyOptional = companyRepository.findById(companyId);
        if (existingCompanyOptional.isEmpty()) {
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND);
        }
        Company existingCompany = existingCompanyOptional.get();
        List<Coupon> existingCoupons = existingCompany.getCoupons();
        company.setCoupons(existingCoupons);
        companyRepository.save(company);
    }


    @Override
    public void deleteCompany(int companyID) throws CouponSystemException {
        Company companyForDelete = companyRepository.findById(companyID).orElseThrow(() ->
                new CouponSystemException(ErrMsg.DELETE_FAILED_COMPANY_NOT_FOUND));
        companyForDelete.getCoupons().forEach(coupon -> couponRepository.deleteByCouponId(coupon.getCouponId()));
        companyForDelete.getCoupons().forEach(coupon -> companyRepository.deleteById(coupon.getCouponId()));
        companyRepository.delete(companyForDelete);
    }

    @Override
    public void deleteCompanyCoupons(int companyId) throws CouponSystemException {
        couponRepository.deleteByCompanyId(companyId);
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
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        if (!customerRepository.existsById(customerId)) {
            throw new CouponSystemException(ErrMsg.DB_UPDATE_FAILED_CUSTOMER_NOT_FOUND);
        }
        if (customerId != customer.getCustomerId()) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_ID_CHANGE_NOT_ALLOWED);
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

        Optional<Customer> existingCustomerOptional = customerRepository.findById(customerId);
        if (existingCustomerOptional.isEmpty()) {
            throw new CouponSystemException(ErrMsg.DB_UPDATE_FAILED_CUSTOMER_NOT_FOUND);
        }
        Customer existingCustomer = existingCustomerOptional.get();

        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPassword(customer.getPassword());

        customerRepository.save(existingCustomer);
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
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneCustomer(int customerID) throws CouponSystemException {
        if (!customerRepository.existsById(customerID)) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_NOT_FOUND);
        }
        return customerRepository.findById(customerID);
    }

}

