//package com.jb.project2.clr.serviceTesting;
//
//import com.jb.project2.beans.Category;
//import com.jb.project2.beans.Coupon;
//import com.jb.project2.service.ClientType;
//import com.jb.project2.service.CompanyServiceImpl;
//import com.jb.project2.security.LoginManager;
//import com.jb.project2.utills.Art;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//@Component
//@RequiredArgsConstructor
//@Order(3)
//public class TestCompany implements CommandLineRunner {
//    @Autowired
//    private final LoginManager loginManager;
//
//    @Override
//    public void run(String... args) throws Exception {
//        try {
//            Art.COMPANIES_METHODS();
//            CompanyServiceImpl companiesImpl = (CompanyServiceImpl) loginManager.login("adidas@gmail.com", "company1234567", ClientType.COMPANY);
//
//            System.out.println();
//            Art.goodTest("Successful coupon add for the logged-in company:");
//            System.out.println();
//            Art.BEFORE();
//            try {
//                companiesImpl.getCompanyCoupons().forEach(System.out::println);
//            } catch (Exception e) {
//                System.out.println("Failed to retrieve company coupons: " + e.getMessage());
//            }
//
//            Coupon couponAdded = Coupon.builder().companyId(companiesImpl.getCompanyLoggedIn().getCompanyId()).category(Category.JERSEYS).title("Added coupon").description("Premium jerseys for just 1,000 NIS - Limited time offer!").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(1000.00).image("Image").build();
//            try {
//                companiesImpl.addCoupon(couponAdded);
//                Art.AFTER();
//                companiesImpl.getCompanyCoupons().forEach(System.out::println);
//                System.out.println();
//                System.out.println();
//                Art.sperator();
//            } catch (Exception e) {
//                System.out.println("Failed to add coupon: " + e.getMessage());
//            }
//
//            // Update coupon
//            Art.goodTest("Successful coupon update for coupon number 8");
//            System.out.println();
//            Art.BEFORE();
//            try {
//                System.out.println(companiesImpl.getOneCoupon(8));
//                System.out.println("a");
//                Coupon couponUpdated = Coupon.builder().couponId(8).companyId(companiesImpl.getCompanyLoggedIn().getCompanyId()).category(Category.BALLS).title("Updated coupon").description("Updated coupon description").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(100).price(50.00).image("Updated image").build();
//                companiesImpl.updateCoupon(couponUpdated);
//                Art.AFTER();
//                System.out.println(companiesImpl.getOneCoupon(8));
//                System.out.println();
//                Art.sperator();
//            } catch (Exception e) {
//                System.out.println("Failed to update coupon: " + e.getMessage());
//            }
//
//            // Delete coupon
//            Art.goodTest("Successful coupon delete for coupon number 5");
//            System.out.println();
//            Art.BEFORE();
//            try {
//                companiesImpl.getCompanyCoupons().forEach(System.out::println);
//                companiesImpl.deleteCoupon(5);
//                Art.AFTER();
//                companiesImpl.getCompanyCoupons().forEach(System.out::println);
//                System.out.println();
//                Art.sperator();
//            } catch (Exception e) {
//                System.out.println("Failed to delete coupon: " + e.getMessage());
//            }
//
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//    }
//}
