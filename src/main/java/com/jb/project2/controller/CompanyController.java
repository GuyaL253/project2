package com.jb.project2.controller;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/company")
public interface CompanyController {

    @PostMapping("coupons")
    void addCoupon(@RequestBody Coupon coupon) throws CouponSystemException;

    @PutMapping("coupons/{couponId}")
    void updateCoupon(@RequestBody Coupon coupon) throws CouponSystemException, CustomException;

    @DeleteMapping("coupons/{couponId}")
    void deleteCoupon(@PathVariable int couponId) throws CouponSystemException;

    @GetMapping("coupons")
    List<Coupon> getAllCoupons();

    @GetMapping("coupons/{couponId}")
    Optional<Coupon> getOneCoupon(@PathVariable int couponId) throws CouponSystemException;

    @GetMapping("coupons/category/{category}")
    List<Coupon> getCompanyCouponsByCategory(@PathVariable Category category);

    @GetMapping("coupons/max-price/{maxPrice}")
    List<Coupon> getCompanyCouponsByMaxPrice(@PathVariable double maxPrice) throws CouponSystemException;

    @GetMapping("details")
    Company getCompanyDetails() throws CouponSystemException;
}
