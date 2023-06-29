package com.jb.project2.controller;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.exceptions.CustomException;
import com.jb.project2.exceptions.ErrMsg;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.CustomerServiceImpl;
import com.jb.project2.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/customer")
public class CustomerControllerImpl {

    @Autowired
    private final CustomerServiceImpl customerService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    public CustomerControllerImpl(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    private void validateToken(UUID token) throws CouponSystemException {
        if (!tokenService.isValid(token, ClientType.CUSTOMER)) {
            throw new CouponSystemException(ErrMsg.RESTRICTED_AREA);
        }
    }

    @PostMapping("coupons/{couponId}")
    @ResponseStatus(HttpStatus.OK)
    public void purchaseCoupon(@PathVariable int couponId, @RequestHeader("Authorization") UUID token) throws CouponSystemException, CustomException {
        validateToken(token);
        customerService.purchaseCoupon(couponId);
    }

    @GetMapping("coupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCoupons(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return customerService.getCustomerCoupons();
    }

    @GetMapping("coupons/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCouponsByCategory(@PathVariable Category category, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return customerService.getCustomerCouponsByCategory(category);
    }

    @GetMapping("coupons/price/{maxPrice}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCouponsByMaxPrice(@PathVariable double maxPrice, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("details")
    @ResponseStatus(HttpStatus.OK)
    public Customer showCustomerDetails(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return customerService.getCustomerLoggedIn();
    }
}
