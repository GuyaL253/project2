package com.jb.project2.service;

import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginManager {
    private final AdminServiceImpl adminImpl;
    private final CompanyServiceImpl companiesImpl;
    private final CustomerServiceImpl customersImpl;

    public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
        switch (clientType) {
            case ADMINISTRATOR:
                adminImpl.login(email, password);
                return adminImpl;

            case COMPANY:
                companiesImpl.login(email, password);
                return companiesImpl;

            case CUSTOMER:
                customersImpl.login(email, password);
                return customersImpl;

            default:
                return null;
        }
    }
}
