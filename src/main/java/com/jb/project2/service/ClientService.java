package com.jb.project2.service;


import com.jb.project2.dto.LoginResDto;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.repos.CompanyRepository;
import com.jb.project2.repos.CouponRepository;
import com.jb.project2.repos.CustomerRepository;
import com.jb.project2.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected TokenService tokenService;

    public abstract LoginResDto login(String email, String password) throws CouponSystemException;

}
