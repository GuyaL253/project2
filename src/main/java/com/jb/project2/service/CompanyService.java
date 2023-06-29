package com.jb.project2.service;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.exceptions.CustomException;

import java.time.LocalDate;
import java.util.List;

public interface CompanyService {

    void addCoupon(Coupon coupon) throws CouponSystemException;

    void addCouponsListToDB(List<Coupon> coupons) throws CouponSystemException, CustomException;

    void addCouponsListToCompany(int companyId, List<Coupon> coupons) throws CouponSystemException, CustomException;

    void updateCoupon(Coupon coupon) throws CouponSystemException, CustomException;

    void deleteCoupon(int couponID) throws CouponSystemException;

    void deleteCouponByDate(LocalDate date);

    List<Coupon> getCompanyCoupons(int companyId);

    List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) throws CouponSystemException;

    List<Coupon> getCompanyCouponsByCategory(Category category);


}
