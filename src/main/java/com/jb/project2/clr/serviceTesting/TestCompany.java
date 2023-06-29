package com.jb.project2.clr.serviceTesting;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.service.ClientType;
import com.jb.project2.service.CompanyServiceImpl;
import com.jb.project2.security.LoginManager;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
@Order(3)
public class TestCompany implements CommandLineRunner {
    @Autowired
    private final LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {
        try {
            Art.CompaniesMethods();
            CompanyServiceImpl companiesImpl = (CompanyServiceImpl) loginManager.login("adidas@gmail.com", "company1234567", ClientType.COMPANY);

            System.out.println();
            Art.goodTest("Successful coupon add for the logged-in company:");
            System.out.println();
            Art.before();
            try {
                companiesImpl.getCompanyCoupons(companiesImpl.getCompanyLoggedIn().getCompanyId()).forEach(Art::printCouponDetails);
            } catch (Exception e) {
                Art.catchPrint("Failed to retrieve company coupons: " + e.getMessage());
            }

            Coupon couponAdded = Coupon.builder().companyId(companiesImpl.getCompanyLoggedIn().getCompanyId()).category(Category.JERSEYS).title("Added coupon").description("Premium jerseys for just 1,000 NIS - Limited time offer!").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(1000.00).image("Image").build();
            try {
                companiesImpl.addCoupon(couponAdded);
                Art.after();
                companiesImpl.getCompanyCoupons(companiesImpl.getCompanyLoggedIn().getCompanyId()).forEach(Art::printCouponDetails);
                System.out.println();
                System.out.println();
                Art.separator();
            } catch (Exception e) {
                System.out.println("Failed to add coupon: " + e.getMessage());
            }

            Art.goodTest("Successful coupon update for coupon number 8");
            System.out.println();
            Art.before();
            try {
                Art.printCouponDetails(companiesImpl.getOneCoupon(8));
                Coupon couponUpdated = Coupon.builder().couponId(8).companyId(companiesImpl.getCompanyLoggedIn().getCompanyId()).category(Category.BALLS).title("Updated coupon").description("Updated coupon description").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(100).price(50.00).image("Updated image").build();
                companiesImpl.updateCoupon(couponUpdated);
                Art.after();
                Art.printCouponDetails(companiesImpl.getOneCoupon(8));
                System.out.println();
                Art.separator();
            } catch (Exception e) {
                Art.catchPrint("Failed to update coupon: " + e.getMessage());
            }

            Art.goodTest("Successful coupon delete for coupon number 5");
            System.out.println();
            Art.before();
            try {
                companiesImpl.getCompanyCoupons(companiesImpl.getCompanyLoggedIn().getCompanyId()).forEach(Art::printCouponDetails);
                companiesImpl.deleteCoupon(5);
                Art.after();
                try {
                    companiesImpl.getCompanyCoupons(companiesImpl.getCompanyLoggedIn().getCompanyId()).forEach(Art::printCouponDetails);
                    System.out.println();
                    Art.separator();
                } catch (Exception e) {
                    Art.catchPrint("Failed to retrieve updated company coupons: " + e.getMessage());
                }
            } catch (Exception e) {
                Art.catchPrint("Failed to delete coupon: " + e.getMessage());
            }
        } catch (Exception e) {
            Art.catchPrint("An error occurred: " + e.getMessage());
        }
    }
}
