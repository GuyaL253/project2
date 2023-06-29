package com.jb.project2.service;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.exceptions.CustomException;

import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int couponID) throws CouponSystemException, CustomException;

    void purchaseCouponForBuildingDB(int customerID, int couponID) throws CouponSystemException, CustomException;

    List<Coupon> getCustomerCoupons() throws CouponSystemException;

    List<Coupon> getCustomerCouponsByCategory(Category category) throws CouponSystemException;

    List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) throws CouponSystemException;

    void showCustomerDetails() throws CouponSystemException;


}
