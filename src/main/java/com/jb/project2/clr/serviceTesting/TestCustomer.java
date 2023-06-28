package com.jb.project2.clr.serviceTesting;

import com.jb.project2.beans.Category;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.CustomerServiceImpl;
import com.jb.project2.security.LoginManager;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(4)
public class TestCustomer implements CommandLineRunner {
    private final LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println();
            Art.CUSTOMERS_METHODS();
            CustomerServiceImpl customersImpl = (CustomerServiceImpl) loginManager.login("Kylian@gmail.com", "Mbappe_password123456", ClientType.CUSTOMER);

            System.out.println();
            Art.goodTest("Successful purchase of coupon number 7 by the logged-in customer:");
            System.out.println("Please notice the amount of that coupon went down by 1");
            Art.BEFORE();
            try {
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons: " + e.getMessage());
            }

            try {
                customersImpl.purchaseCoupon(7);
                System.out.println();
                Art.AFTER();
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
                System.out.println();
                Art.separator();
            } catch (Exception e) {
                Art.catchPrint("Failed to purchase coupon: " + e.getMessage());
            }

            System.out.println();
            Art.badTest("Unsuccessful coupon purchase by logged-in customer - coupon does not exists (28)");
            Art.BEFORE();
            try {
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons: " + e.getMessage());
            }

            try {
                customersImpl.purchaseCoupon(28);
                System.out.println();
                Art.AFTER();
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
                System.out.println();
                Art.separator();
            } catch (Exception e) {
                Art.catchPrint("Failed to purchase coupon: " + e.getMessage());
            }

            System.out.println();
            Art.badTest("Unsuccessful coupon purchase of coupon 14 by logged-in customer - coupon amount is 0");
            Art.BEFORE();
            try {
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons: " + e.getMessage());
            }

            try {
                customersImpl.purchaseCoupon(14);
                System.out.println();
                Art.AFTER();
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
                System.out.println();
                Art.separator();
            } catch (Exception e) {
                Art.catchPrint("Failed to purchase coupon: " + e.getMessage());
            }

            System.out.println();
            Art.badTest("Unsuccessful purchase of coupon 7 by logged-in customer - customer has already purchased this coupon");
            Art.BEFORE();
            try {
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons: " + e.getMessage());
            }

            try {
                customersImpl.purchaseCoupon(7);
                System.out.println();
                Art.AFTER();
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
                System.out.println();
                Art.separator();
            } catch (Exception e) {
                Art.catchPrint("Failed to purchase coupon: " + e.getMessage());
            }

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            Art.goodTest("Successful receive of customer coupons of logged-in customer:");
            try {
                customersImpl.getCustomerCoupons().forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons: " + e.getMessage());
            }

            System.out.println();
            Art.separator();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            Art.goodTest("Successful receive of logged-in customer coupons by the category 'SHOES':");
            try {
                customersImpl.getCustomerCouponsByCategory(Category.SHOES).forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons by category: " + e.getMessage());
            }

            System.out.println();
            Art.separator();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            Art.goodTest("Successful receive of coupons of logged-in customer, equal or under the price 50:");
            try {
                customersImpl.getCustomerCouponsByMaxPrice(50).forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve customer coupons by max price: " + e.getMessage());
            }

            System.out.println();
            Art.separator();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            Art.goodTest("Successful receive of logged-in customer details:");
            customersImpl.showCustomerDetails();
            System.out.println();
            Art.separator();

        } catch (Exception err) {
            Art.catchPrint(err.getMessage());
        }

    }
}
