package com.jb.project2.service;


import com.jb.project2.dto.LoginReqDto;
import com.jb.project2.dto.LoginResDto;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
@RequiredArgsConstructor
public class LoginManager {
    @Autowired
    private CompanyServiceImpl companyService;
    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private AdminServiceImpl adminService;

    public LoginResDto login(LoginReqDto loginReqDto) throws SQLException, CouponSystemException {
        ClientService clientService = null;
        switch (loginReqDto.getClientType().ordinal()) {
            case 0 -> {
                System.out.println("AdminService is being used.");
                clientService = adminService;
            }
            case 1 -> {
                System.out.println("CompanyService is being used.");
                clientService = companyService;
            }
            case 2 -> {
                System.out.println("CustomerService is being used.");
                clientService = customerService;
            }
        }
        if (clientService == null) {
            throw new CouponSystemException(ErrMsg.LOGIN_FAILED);
        }

        return clientService.login(loginReqDto.getEmail(), loginReqDto.getPassword());
    }


    public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
        switch (clientType) {
            case ADMINISTRATOR:
                adminService.login(email, password);
                return adminService;

            case COMPANY:
                companyService.login(email, password);
                return companyService;

            case CUSTOMER:
                customerService.login(email, password);
                return customerService;

            default:
                return null;
        }
    }

}