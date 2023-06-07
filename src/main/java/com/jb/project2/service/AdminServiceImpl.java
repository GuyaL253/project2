package com.jb.project2.service;

import com.jb.project2.beans.Company;
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
            throw new CouponSystemException(ErrMsg.NAME_OF_COMPANY_ERROR);
        }
        if (company.getPassword().length() < 10) {
            throw new CouponSystemException(ErrMsg.PASSWORD_OF_COMPANY_ERROR);
        }
//        if (company.getEmail().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'addCompany'", "The email of the company must be at least 10 notes long." +
//                    " \nAdding failed.");
//        }
//        if (companiesRepo.findByName(company.getName()) != null) {
//            throw new UserErrorException("'AdminImpl'", "'addCompany'", "There's already a company with that name in the DB." +
//                    " \nAdding failed.");
//        }
//        if (companiesRepo.findByEmail(company.getEmail()) != null) {
//            throw new UserErrorException("'AdminImpl'", "'addCompany'", "There's already a company with that email in the DB." +
//                    " \nAdding failed.");
//        }
//        companyRepository.save(company);
    }

    @Override
    public void addCompaniesListToDB(List<Company> companies) {
//        for (Company company : companies) {
//            if (company.getName().length() < 3) {
//                throw new UserErrorException("'AdminImpl'", "'addCompaniesListToDB'", "The name of the company must be at least 2 notes long." +
//                        " \nAdding failed.");
//            }
//            if (company.getPassword().length() < 10) {
//                throw new UserErrorException("'AdminImpl'", "'addCompaniesListToDB'", "The password of the company must be at least 10 notes long." +
//                        " \nAdding failed.");
//            }
//            if (company.getEmail().length() < 10) {
//                throw new UserErrorException("'AdminImpl'", "'addCompaniesListToDB'", "The email of the company must be at least 10 notes long." +
//                        " \nAdding failed.");
//            }
//            if (companiesRepo.findByName(company.getName()) != null) {
//                throw new UserErrorException("'AdminImpl'", "'addCompaniesListToDB'", "There's already a company with the name '"
//                        + company.getName() + "' in the DB.");
//            }
//            if (companiesRepo.findByEmail(company.getEmail()) != null) {
//                throw new UserErrorException("'AdminImpl'", "'addCompaniesListToDB'", "There's already a company with the email '"
//                        + company.getName() + "' in the DB.");
//            }
//            companyRepository.save(company);
//        }
    }

    @Override
    public void updateCompany(Company company) {
//        //System.out.println(company);
//        if ((companiesRepo.findByCompanyIdAndName(company.getCompanyId(), company.getName())) == null) {
//            throw new UserErrorException("'AdminImpl'", "'updateCompany'", "You can't edit the company's id and name. Updating failed.");
//        }
//        if (company.getName().length() < 3) {
//            throw new UserErrorException("'AdminImpl'", "'updateCompany'", "The name must be at least 2 notes long." +
//                    " \nUpdating failed.");
//        }
//        if (company.getPassword().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'updateCompany'", "The password must be at least 10 notes long." +
//                    " \nUpdating failed.");
//        }
//        if (company.getEmail().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'updateCompany'", "The email must be at least 10 notes long." +
//                    " \nUpdating failed.");
//        }
//        companyRepository.save(company);
    }

    @Override
    public void deleteCompany(int companyID) {
//        Company companyForDelete = companiesRepo.findById(companyID).orElseThrow(() -> new UserErrorException("'AdminImpl'", "'deleteCompany'",
//                "The company you are trying to delete does not exist in the DB. Delete failed."));
//        companyForDelete.getCoupons().forEach(coupon -> couponsRepo.deleteByCouponId(coupon.getCouponId()));
//        companiesRepo.delete(companyForDelete);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> getOneCompany(int companyID) {
//        if (!companyRepository.existsById(companyID)) {
//            throw new UserErrorException("'AdminImpl'", "'getOneCompany'", "There is no company with this id.");
//        }
        return companyRepository.findById(companyID);
    }

    @Override
    public void addCustomer(Customer customer) {
//        if (customer.getFirstName().length() < 3) {
//            throw new UserErrorException("'AdminImpl'", "'addCustomer'", "The first name must be at least 2 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customer.getLastName().length() < 3) {
//            throw new UserErrorException("'AdminImpl'", "'addCustomer'", "The last name must be at least 2 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customer.getEmail().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'addCustomer'", "The email must be at least 10 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customer.getPassword().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'addCustomer'", "The password must be at least 10 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customersRepo.findByEmail(customer.getEmail()) != null) {
//            throw new UserErrorException("'AdminImpl'", "'addCustomer'", "There's already a customer with that email in the DB. Adding failed.");
//        }
//        customersRepo.save(customer);
    }

    @Override
    public void addCustomersListToDB(List<Customer> customers) {
//        for (Customer customer : customers) {
//            if (customer.getFirstName().length() < 3) {
//                throw new UserErrorException("'AdminImpl'", "'addCustomersListToDB'", "The first name must be at least 2 notes long." +
//                        " \nAdding failed.");
//            }
//            if (customer.getLastName().length() < 3) {
//                throw new UserErrorException("'AdminImpl'", "'addCustomersListToDB'", "The last name must be at least 2 notes long." +
//                        " \nAdding failed.");
//            }
//            if (customer.getEmail().length() < 10) {
//                throw new UserErrorException("'AdminImpl'", "'addCustomersListToDB'", "The email must be at least 10 notes long." +
//                        " \nAdding failed.");
//            }
//            if (customer.getPassword().length() < 10) {
//                throw new UserErrorException("'AdminImpl'", "'addCustomersListToDB'", "The password must be at least 10 notes long." +
//                        " \nAdding failed.");
//            }
//            if (customersRepo.findByEmail(customer.getEmail()) != null) {
//                throw new UserErrorException("'AdminImpl'", "'addCustomersListToDB'", "There's already a customer with the email." + customer.getEmail() + " in the DB. Adding was not done.");
//            }
//            customersRepo.save(customer);
        }


    @Override
    public void updateCustomer(Customer customer) {
//        if (!customersRepo.existsById(customer.getCustomerId())) {
//            throw new UserErrorException("'AdminImpl'", "'updateCustomer'", "There is no customer with this id in the DB. Updating failed.");
//        }
//        if (customer.getFirstName().length() < 3) {
//            throw new UserErrorException("'AdminImpl'", "'updateCustomer'", "The first name must be at least 2 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customer.getLastName().length() < 3) {
//            throw new UserErrorException("'AdminImpl'", "'updateCustomer'", "The last name must be at least 2 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customer.getEmail().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'updateCustomer'", "The email must be at least 10 notes long." +
//                    " \nAdding failed.");
//        }
//        if (customer.getPassword().length() < 10) {
//            throw new UserErrorException("'AdminImpl'", "'updateCustomer'", "The password must be at least 10 notes long." +
//                    " \nAdding failed.");
//        }
//        customersRepo.save(customer);
    }

    @Override
    public void deleteCustomer(int customerID) {
//        Customer customerForDelete = customersRepo.findById(customerId).orElseThrow(() -> new UserErrorException("'AdminImpl'", "'deleteCustomer'", "There is no company with that id."));
//        List<Coupon> coupons = customerForDelete.getCoupons();
//        coupons.clear();
//        customerForDelete.setCoupons(coupons);
//        customersRepo.saveAndFlush(customerForDelete);
//        customersRepo.delete(customerForDelete);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getOneCustomer(int customerID) {
//        if (!customerRepository.existsById(customerID)) {
//            throw new UserErrorException("'AdminImpl'", "'getOneCustomer'", "There is no customer with this id.");
//        }
        return customerRepository.findById(customerID);
//    }
    }


}
