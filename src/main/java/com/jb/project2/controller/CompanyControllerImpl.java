package com.jb.project2.controller;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import com.jb.project2.exeptions.ErrMsg;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.CompanyServiceImpl;
import com.jb.project2.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/company")
public class CompanyControllerImpl {
    @Autowired
    private final CompanyServiceImpl companyService;
    @Autowired
    private TokenService tokenService;

    @Autowired
    public CompanyControllerImpl(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    private void validateToken(UUID token) throws CouponSystemException {
        if (!tokenService.isValid(token, ClientType.COMPANY)) {
            throw new CouponSystemException(ErrMsg.RESTRICTED_AREA);
        }
    }

    @PostMapping("coupons")
    public void addCoupon(@RequestBody Coupon coupon, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        companyService.addCoupon(coupon);
    }

    @PutMapping("coupons/{couponId}")
    public void updateCoupon(@RequestBody Coupon coupon, @RequestHeader("Authorization") UUID token) throws CouponSystemException, CustomException {
        validateToken(token);
        companyService.updateCoupon(coupon);
    }

    @DeleteMapping("coupons/{couponId}")
    public void deleteCoupon(@PathVariable int couponId, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        companyService.deleteCoupon(couponId);
    }

    @GetMapping("coupons")
    public List<Coupon> getAllCoupons(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return companyService.getCompanyCoupons();
    }

    @GetMapping("coupons/{couponId}")
    public Optional<Coupon> getOneCoupon(@PathVariable int couponId, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return Optional.ofNullable(companyService.getOneCoupon(couponId));
    }

    @GetMapping("coupons/category/{category}")
    public List<Coupon> getCompanyCouponsByCategory(@PathVariable Category category, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return companyService.getCompanyCouponsByCategory(category);
    }

    @GetMapping("coupons/max-price/{maxPrice}")
    public List<Coupon> getCompanyCouponsByMaxPrice(@PathVariable double maxPrice, @RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return companyService.getCompanyCouponsByMaxPrice(maxPrice);
    }

    @GetMapping("details")
    public Company getCompanyDetails(@RequestHeader("Authorization") UUID token) throws CouponSystemException {
        validateToken(token);
        return companyService.getCompanyDetails();
    }
}
