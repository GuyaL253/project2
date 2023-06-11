package com.jb.project2.controller;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public interface CustomerController {


    @PostMapping("coupons/{couponId}")
    void purchaseCoupon(@PathVariable int couponId) throws CouponSystemException, CustomException;

    @GetMapping("coupons")
    List<Coupon> getCustomerCoupons();

    @GetMapping("coupons/category/{category}")
    List<Coupon> getCustomerCouponsByCategory(@PathVariable Category category);

    @GetMapping("coupons/price/{maxPrice}")
    List<Coupon> getCustomerCouponsByMaxPrice(@PathVariable double maxPrice) throws CouponSystemException;

    @GetMapping("details")
    Customer showCustomerDetails();
}
