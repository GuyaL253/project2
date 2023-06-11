package com.jb.project2.controller;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import com.jb.project2.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerControllerImpl implements CustomerController {

    private final CustomerServiceImpl customerService;

    @Autowired
    public CustomerControllerImpl(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @Override
    @PostMapping("coupons/{couponId}")
    @ResponseStatus(HttpStatus.OK)
    public void purchaseCoupon(@PathVariable int couponId) throws CouponSystemException, CustomException {
        customerService.purchaseCoupon(couponId);
    }

    @Override
    @GetMapping("coupons")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCoupons() {
        return customerService.getCustomerCoupons();
    }

    @Override
    @GetMapping("coupons/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCouponsByCategory(@PathVariable Category category) {
        return customerService.getCustomerCouponsByCategory(category);
    }

    @Override
    @GetMapping("coupons/price/{maxPrice}")
    @ResponseStatus(HttpStatus.OK)
    public List<Coupon> getCustomerCouponsByMaxPrice(@PathVariable double maxPrice) throws CouponSystemException {
        return customerService.getCustomerCouponsByMaxPrice(maxPrice);
    }

    @Override
    @GetMapping("details")
    @ResponseStatus(HttpStatus.OK)
    public Customer showCustomerDetails() {
        return customerService.getCustomerLoggedIn();
    }

}
