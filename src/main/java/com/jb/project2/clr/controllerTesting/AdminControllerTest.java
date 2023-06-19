//package com.jb.project2.clr.controllerTesting;
//
//
//import com.jb.project2.beans.Company;
//import com.jb.project2.beans.Customer;
//import com.jb.project2.dto.LoginReqDto;
//import com.jb.project2.exeptions.CouponSystemException;
//import com.jb.project2.exeptions.ErrMsg;
//import com.jb.project2.service.ClientType;
//import com.jb.project2.utills.Art;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.*;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.HttpClientErrorException;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.UUID;
//
//@Component
//@Order(5)
//public class AdminControllerTest implements CommandLineRunner {
//    @Autowired
//    protected RestTemplate restTemplate;
//    @Value("${url}")
//    private String url;
//    private final Company company = Company.builder()
//            .email("email@myaddress.com")
//            .name("new controller company")
//            .password("123123456789")
//            .build();
//    private final Company companyToUpdate = Company.builder()
//            .email("email@myaddress.com")
//            .name("new name")
//            .password("12345678910")
//            .build();
//    private final Customer customer = Customer.builder()
//            .firstName("new")
//            .lastName("customer")
//            .email("email@address.com")
//            .password("123456789")
//            .build();
//    private final Customer customerToUpdate = Customer.builder()
//            .firstName("new")
//            .lastName("customer")
//            .email("email@address.com")
//            .password("12345678910")
//            .build();
//    private final LoginReqDto loginAdminDto = LoginReqDto.builder()
//            .email("admin@admin.com")
//            .password("admin")
//            .clientType(ClientType.ADMINISTRATOR)
//            .build();
//    private final LoginReqDto loginCompanyDto = LoginReqDto.builder()
//            .email("northwind@gmail.com")
//            .password("northwin4chd123")
//            .clientType(ClientType.COMPANY)
//            .build();
//    private final LoginReqDto loginCustomerDto = LoginReqDto.builder()
//            .email("charliedavis@gmail.com")
//            .password("charli4che123")
//            .clientType(ClientType.CUSTOMER)
//            .build();
//    private final LoginReqDto loginFailDto = LoginReqDto.builder()
//            .email("admin@wrong.com")
//            .password("adfmtc35cehin")
//            .clientType(ClientType.ADMINISTRATOR)
//            .build();
//
//    @Override
//    public void run(String... args) throws Exception {
//        Art.controlDescription("\t\ttesting adminController\n");
////        getAllCompanies(UUID.randomUUID());
//        addCompany(company, UUID.randomUUID());
////        addCompany(company, UUID.randomUUID());
////        updateCompany(1000, companyToUpdate, UUID.randomUUID());
////        updateCompany(10, companyToUpdate, UUID.randomUUID());
////        updateCompany(11, companyToUpdate, UUID.randomUUID());
////        deleteCompany(7, UUID.randomUUID());
////        deleteCompany(7, UUID.randomUUID());
////        getOneCompany(8, UUID.randomUUID());
////        getAllCustomers(UUID.randomUUID());
////        addCustomer(customer, UUID.randomUUID());
////        addCustomer(customer, UUID.randomUUID());
////        updateCustomer(1000, customerToUpdate, UUID.randomUUID());
////        updateCustomer(10, customerToUpdate, UUID.randomUUID());
////        deleteCustomer(7, UUID.randomUUID());
////        deleteCustomer(7, UUID.randomUUID());
////        getOneCustomer(8, UUID.randomUUID());
//        login(loginAdminDto);
//        login(loginCompanyDto);
//        login(loginCustomerDto);
//        login(loginFailDto);
//        Art.controlDescription("\t\ttesting adminController ended\n");
//    }
//
//    // companies functions
//    private void addCompany(Company company, UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<Company> add = new HttpEntity<>(company, headers);
//
//        try {
//            ResponseEntity<Company> res = restTemplate.exchange(url + "/companies", HttpMethod.POST, add, Company.class);
//            Art.controlDescription("|--->\tadmin addCompany success. response status is: " + (res.getStatusCodeValue()));
//            getAllCompanies(token);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin addCompany fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    private void updateCompany(int companyId, Company company, UUID token) {
//        company.setCompanyId(companyId);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<Company> update = new HttpEntity<>(company, headers);
//        try {
//            ResponseEntity<Company> res = restTemplate.exchange(url + "/companies/" + companyId, HttpMethod.PUT, update, Company.class);
//            Art.controlDescription("|--->\tadmin updateCompany success. response status is: " + (res.getStatusCodeValue()));
//            getAllCompanies(token);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin updateCompany fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void deleteCompany(int companyId, UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//        try {
//            ResponseEntity<Company> res = restTemplate.exchange(url + "/companies/" + companyId, HttpMethod.DELETE, entity, Company.class);
//            Art.controlDescription("|--->\tadmin deleteCompany success. response status is: " + (res.getStatusCodeValue()));
//            getAllCompanies(token);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin deleteCompany fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    private void getAllCompanies(UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        try {
//            ResponseEntity<List<Company>> res =
//                    restTemplate.exchange(url + "/companies", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Company>>() {
//                    });
//            Art.controlDescription("|--->\tadmin getAllCompanies success. response status is: " + (res.getStatusCodeValue()));
//            Art.controlDescription("|--->\tadmin getAllCompanies. response status is: " + (res.getStatusCodeValue()));
//            Objects.requireNonNull(res.getBody()).forEach(System.out::println);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin getAllCompanies fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void getOneCompany(int companyId, UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        try {
//            ResponseEntity<Company> res = restTemplate.exchange(url + "/companies/" + companyId, HttpMethod.GET, entity, Company.class);
//            Art.controlDescription("|--->\tadmin getOneCompany success. response status is: " + (res.getStatusCodeValue()));
//            System.out.println(res.getBody());
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin getOneCompany fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    // customers functions
//    private void addCustomer(Customer customer, UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<Customer> add = new HttpEntity<>(customer, headers);
//        try {
//            ResponseEntity<Customer> res = restTemplate.exchange(url + "/customers", HttpMethod.POST, add, Customer.class);
//            Art.controlDescription("|--->\tadmin addCustomer success. response status is: " + (res.getStatusCodeValue()));
//            getAllCustomers(token);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin addCustomer fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//    private void updateCustomer(int customerId, Customer customer, UUID token) {
//        customer.setCustomerId(customerId);
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", token.toString());
//            HttpEntity<Customer> update = new HttpEntity<>(customer, headers);
//            ResponseEntity<Customer> res = restTemplate.exchange(url + "/customers/" + customerId, HttpMethod.PUT, update, Customer.class);
//            Art.controlDescription("|--->\tadmin updateCustomer success. response status is: " + (res.getStatusCodeValue()));
//            getAllCustomers(token);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin updateCustomer fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void deleteCustomer(int customerId, UUID token) {
//        try {
//            HttpHeaders headers = new HttpHeaders();
//            headers.set("Authorization", token.toString());
//            HttpEntity<Customer> delete = new HttpEntity<>(null, headers);
//            ResponseEntity<Customer> res = restTemplate.exchange(url + "/customers/" + customerId, HttpMethod.DELETE, delete, Customer.class);
//            Art.controlDescription("|--->\tadmin deleteCustomer success. response status is: " + (res.getStatusCodeValue()));
//            getAllCustomers(token);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin deleteCustomer fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void getAllCustomers(UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        try {
//            ResponseEntity<List<Customer>> res =
//                    restTemplate.exchange(url + "/customers", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Customer>>() {
//                    });
//            Art.controlDescription("|--->\tadmin getAllCustomers. response status is: " + (res.getStatusCodeValue()));
//            Objects.requireNonNull(res.getBody()).forEach(System.out::println);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin getAllCustomers fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void getOneCustomer(int customerId, UUID token) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", token.toString());
//        HttpEntity<String> entity = new HttpEntity<>(null, headers);
//
//        try {
//            ResponseEntity<Customer> res = restTemplate.exchange(url + "/customers/" + customerId, HttpMethod.GET, entity, new ParameterizedTypeReference<Customer>() {
//            });
//            Art.controlDescription("|--->\tadmin getOneCustomer success. response status is: " + (res.getStatusCodeValue()));
//            System.out.println(res.getBody());
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tadmin getOneCustomer fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void login(LoginReqDto loginReqDto) {
//        HttpEntity<LoginReqDto> add = new HttpEntity<>(loginReqDto);
//        try {
//            ResponseEntity<UUID> res = restTemplate.exchange(url + "/login", HttpMethod.POST, add, UUID.class);
//            Art.controlDescription("|--->\tlogin success. response status is: " + (res.getStatusCodeValue()));
//        } catch (HttpClientErrorException e) {
//            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
//                try {
//                    throw new CouponSystemException(ErrMsg.LOGIN_FAILED);
//                } catch (CouponSystemException ex) {
//                    Art.controlDescription("|--->\tlogin fail: "+ ex.getMessage()); // Print exception message here
//                }
//            }
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tlogin fail: " + e.getMessage()); // Print exception message here
//        }
//    }
//
//
//}