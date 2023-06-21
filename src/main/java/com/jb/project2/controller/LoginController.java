package com.jb.project2.controller;

import com.jb.project2.dto.LoginReqDto;
import com.jb.project2.dto.LoginResDto;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.security.LoginManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("api")
public class LoginController {
    @Autowired
    private LoginManager loginManager;

    @PostMapping("login")
    public LoginResDto login(@RequestBody LoginReqDto loginDetails) throws CouponSystemException, SQLException {
        return loginManager.login(loginDetails);
    }
}

//04:48
