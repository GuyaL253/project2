package com.jb.project2.clr;


import com.jb.project2.beans.Category;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.CustomerServiceImpl;
import com.jb.project2.service.LoginManager;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
            CustomerServiceImpl customersImpl = (CustomerServiceImpl) loginManager.login("kobi.shasha@gmail.com", "Shasha@2023password", ClientType.CUSTOMER);

            System.out.println();
            System.out.println("Successful purchase of coupon number 7 by the logged-in customer:");
            System.out.println("Please notice the amount of that coupon went down by 1");
            System.out.println("Before:");
            customersImpl.getCustomerCoupons().forEach(System.out::println);
            customersImpl.purchaseCoupon(7);
            System.out.println();
            System.out.println("After:");
            customersImpl.getCustomerCoupons().forEach(System.out::println);
            System.out.println();
            Art.sperator();

//            System.out.println();
//            System.out.println("Unsuccessful coupon purchase by logged-in customer - coupon does not exists");
//            System.out.println("Before:");
//            customersImpl.getCustomerCoupons().forEach(System.out::println);
//            customersImpl.purchaseCoupon(28);
//            System.out.println();
//            System.out.println("After:");
//            customersImpl.getCustomerCoupons().forEach(System.out::println);

//            System.out.println();
//            System.out.println("Unsuccessful coupon purchase of coupon 14 by logged-in customer - coupon amount is 0");
//            System.out.println("Before:");
//            customersImpl.getCustomerCoupons().forEach(System.out::println);
//            customersImpl.purchaseCoupon(14);
//            System.out.println();
//            System.out.println("After:");
//            customersImpl.getCustomerCoupons().forEach(System.out::println);



//            System.out.println();
//            System.out.println("Unsuccessful purchase of coupon 6 by logged-in customer - customer has already purchased this coupon");
//            System.out.println("Before:");
//            customersImpl.getCustomerCoupons().forEach(System.out::println);
//            customersImpl.purchaseCoupon(6);
//            System.out.println();
//            System.out.println("After:");
//            customersImpl.getCustomerCoupons().forEach(System.out::println);

            ///////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            System.out.println("Successful receive of customer coupons of logged-in customer:");
            customersImpl.getCustomerCoupons().forEach(System.out::println);
            System.out.println();
            Art.sperator();


            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            System.out.println("Successful receive of logged-in customer coupons by the category 'SHOES':");
            customersImpl.getCustomerCouponsByCategory(Category.SHOES).forEach(System.out::println);
            System.out.println();
            Art.sperator();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            System.out.println("Successful receive of coupons of logged-in customer, equal or under the price 50:");
            customersImpl.getCustomerCouponsByMaxPrice(50).forEach(System.out::println);
            System.out.println();
            Art.sperator();

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            System.out.println("Successful receive of logged-in customer details:");
            customersImpl.showCustomerDetails();
            System.out.println();
            Art.sperator();

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

    }
}