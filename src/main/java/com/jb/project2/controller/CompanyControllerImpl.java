package com.jb.project2.controller;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import com.jb.project2.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/company")
public class CompanyControllerImpl implements CompanyController {

    private final CompanyServiceImpl companyService;

    @Autowired
    public CompanyControllerImpl(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @PostMapping("coupons")
    @Override
    public void addCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
        companyService.addCoupon(coupon);
    }

    @PutMapping("coupons/{couponId}")
    @Override
    public void updateCoupon(@RequestBody Coupon coupon) throws CouponSystemException, CustomException {
        companyService.updateCoupon(coupon);
    }

    @DeleteMapping("coupons/{couponId}")
    @Override
    public void deleteCoupon(@PathVariable int couponId) throws CouponSystemException {
        companyService.deleteCoupon(couponId);
    }

    @GetMapping("coupons")
    @Override
    public List<Coupon> getAllCoupons() {
        return companyService.getCompanyCoupons();
    }

    @GetMapping("coupons/{couponId}")
    @Override
    public Optional<Coupon> getOneCoupon(@PathVariable int couponId) throws CouponSystemException {
        return Optional.ofNullable(companyService.getOneCoupon(couponId));
    }

    @GetMapping("coupons/category/{category}")
    @Override
    public List<Coupon> getCompanyCouponsByCategory(@PathVariable Category category) {
        return companyService.getCompanyCouponsByCategory(category);
    }

    @GetMapping("coupons/max-price/{maxPrice}")
    @Override
    public List<Coupon> getCompanyCouponsByMaxPrice(@PathVariable double maxPrice) throws CouponSystemException {
        return companyService.getCompanyCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("details")
    @Override
    public Company getCompanyDetails() throws CouponSystemException {
        return companyService.getCompanyDetails();
    }
}
