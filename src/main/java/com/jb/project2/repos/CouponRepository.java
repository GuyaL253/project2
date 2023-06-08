package com.jb.project2.repos;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {
    Coupon findByCompanyIdAndTitle(int companyId, String title);
    Coupon findByCompanyIdAndCouponId(int companyId, int couponId);
    List<Coupon> findAllByCompanyIdAndCategory(int companyId ,Category category);
    List<Coupon> findAllByCompanyId(int companyId);
    List<Coupon> findByEndDateBefore(Date date);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM customer_coupons WHERE coupons_coupon_id=:couponId", nativeQuery = true)
    void deleteByCouponId(int couponId);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM company_coupons WHERE coupons_coupon_id=:couponId", nativeQuery = true)
    void deleteByCouponsId(int couponId);
}