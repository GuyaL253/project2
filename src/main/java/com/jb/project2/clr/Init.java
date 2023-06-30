package com.jb.project2.clr;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.security.LoginManager;
import com.jb.project2.service.*;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Order(1)
public class Init implements CommandLineRunner {
    private final LoginManager loginManager;

    @Override
    public void run(String... args) throws Exception {

        try {
            System.out.println();
            Art.initDatabase();
            Art.separator();
            AdminServiceImpl adminImpl = (AdminServiceImpl) loginManager.login("admin@admin.com", "admin", ClientType.ADMINISTRATOR);

            Company company1 = Company.builder().name("Nike").email("nike@gmail.com").password("password123456").build();

            Company company2 = Company.builder().name("Adidas").email("adidas@gmail.com").password("company1234567").build();

            Company company3 = Company.builder().name("Puma").email("puma@gmail.com").password("puma2022!password").build();

            Company company4 = Company.builder().name("Under Armour").email("underarmour@gmail.com").password("UA_password123456").build();

            Company company5 = Company.builder().name("Reebok").email("reebok@gmail.com").password("Rbk@2023password").build();

            List<Company> companies = Arrays.asList(company1, company2, company3, company4, company5);
            adminImpl.addCompaniesListToDB(companies);


            Customer customer1 = Customer.builder().firstName("Cristiano").lastName("Ronaldo").email("Cristiano@gmail.com").password("password123456").build();

            Customer customer2 = Customer.builder().firstName("Lionel").lastName("Messi").email("Lionel@gmail.com").password("customer1234567").build();

            Customer customer3 = Customer.builder().firstName("Neymar").lastName("Jrr").email("Neymar@gmail.com").password("Neymar2022!password").build();

            Customer customer4 = Customer.builder().firstName("Kylian").lastName("Mbappe").email("Kylian@gmail.com").password("Mbappe_password123456").build();

            Customer customer5 = Customer.builder().firstName("Kobi").lastName("Shasha").email("kobi.shasha@gmail.com").password("Shasha@2023password").build();

            Customer customer6 = Customer.builder().firstName("Kevin").lastName("DeBruyne").email("Kevin@gmail.com").password("DeBruyne2023@password").build();

            Customer customer7 = Customer.builder().firstName("Sadio").lastName("Mane").email("Sadio@gmail.com").password("Mane1234567890!").build();

            Customer customer8 = Customer.builder().firstName("Virgil").lastName("Van Dijk").email("Virgil@gmail.com").password("VanDijk@2023password").build();

            Customer customer9 = Customer.builder().firstName("Robert").lastName("Lewandowski").email("Robert@gmail.com").password("Lewandowski@2023").build();

            Customer customer10 = Customer.builder().firstName("Jan").lastName("Oblak").email("Jan@gmail.com").password("Oblak2023!password").build();


            List<Customer> customers = Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6, customer7, customer8, customer9, customer10);
            adminImpl.addCustomersListToDB(customers);

            CompanyServiceImpl companiesImpl = (CompanyServiceImpl) loginManager.login("nike@gmail.com", "password123456", ClientType.COMPANY);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            Coupon coupon1 = Coupon.builder().companyId(1).category(Category.BALLS).title("Nike").description("Nike coupon: Get 10% off on all sports balls").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(1000.00).image("https://example.com/nike_coupon_image.jpg").build();

            Coupon coupon2 = Coupon.builder().companyId(1).category(Category.SHOES).title("Adidas").description("Adidas coupon: Buy one pair of shoes and get 50% off on the second pair").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(79.90).image("https://example.com/adidas_coupon_image.jpg").build();

            Coupon coupon3 = Coupon.builder().companyId(1).category(Category.JERSEYS).title("Puma").description("Puma coupon: Get 20% off on all sports jerseys").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(57.00).image("https://example.com/puma_coupon_image.jpg").build();

            Coupon coupon4 = Coupon.builder().companyId(1).category(Category.BALLS).title("Under Armor").description("Under Armor coupon: Buy any sports ball and get a free mini pump").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(1000.00).image("https://example.com/underarmor_coupon_image.jpg").build();

            Coupon coupon5 = Coupon.builder().companyId(2).category(Category.SHOES).title("Reebok").description("Reebok coupon: Get 15% off on all sports shoes").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(2000.00).image("https://example.com/reebok_coupon_image.jpg").build();

            Coupon coupon6 = Coupon.builder().companyId(2).category(Category.SHOES).title("Nike").description("Nike coupon: Buy two pairs of shoes and get the third pair for free").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(200.00).image("https://example.com/nike_coupon_image.jpg").build();

            Coupon coupon7 = Coupon.builder().companyId(2).category(Category.JERSEYS).title("Adidas").description("Adidas coupon: Get 30% off on all sports jerseys").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(50.00).image("https://example.com/adidas_coupon_image.jpg").build();

            Coupon coupon8 = Coupon.builder().companyId(2).category(Category.BALLS).title("Puma").description("Puma coupon: Buy any sports ball and get a free sports bag").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(2500.00).image("https://example.com/puma_coupon_image.jpg").build();

            Coupon coupon9 = Coupon.builder().companyId(3).category(Category.SHOES).title("Under Armor").description("Under Armor coupon: Get 20% off on all running shoes").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(10.00).image("https://example.com/underarmor_coupon_image.jpg").build();

            Coupon coupon10 = Coupon.builder().companyId(3).category(Category.JERSEYS).title("Reebok").description("Reebok coupon: Buy any two sports jerseys and get the third one at 50% off").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(100.00).image("https://example.com/reebok_coupon_image.jpg").build();

            Coupon coupon11 = Coupon.builder().companyId(3).category(Category.BALLS).title("Nike").description("Nike coupon: Get a free mini pump with the purchase of any sports ball").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(500.00).image("https://example.com/nike_coupon_image.jpg").build();

            Coupon coupon12 = Coupon.builder().companyId(3).category(Category.SHOES).title("Adidas").description("Adidas coupon: Get 10% off on all basketball shoes").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(5).price(100.00).image("https://example.com/adidas_coupon_image.jpg").build();

            Coupon coupon13 = Coupon.builder().companyId(4).category(Category.JERSEYS).title("Puma").description("Puma coupon: Buy two sports jerseys and get a sports water bottle for free").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(99.90).image("https://example.com/puma_coupon_image.jpg").build();

            Coupon coupon14 = Coupon.builder().companyId(4).category(Category.BALLS).title("Under Armor").description("Under Armor coupon: Buy any two sports balls and get the third one at half price").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(0).price(500.00).image("https://example.com/underarmor_coupon_image.jpg").build();

            Coupon coupon15 = Coupon.builder().companyId(4).category(Category.SHOES).title("Reebok").description("Reebok coupon: Get 20% off on all running shoes").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(5.00).image("https://example.com/reebok_coupon_image.jpg").build();

            Coupon coupon16 = Coupon.builder().companyId(4).category(Category.JERSEYS).title("Nike").description("Nike coupon: Buy two sports jerseys and get the third one for free").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(500.00).image("https://example.com/nike_coupon_image.jpg").build();

            Coupon coupon17 = Coupon.builder().companyId(5).category(Category.BALLS).title("Adidas").description("Adidas coupon: Get a free soccer ball with the purchase of any basketball").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(1500.00).image("https://example.com/adidas_coupon_image.jpg").build();

            Coupon coupon18 = Coupon.builder().companyId(5).category(Category.SHOES).title("Puma").description("Puma coupon: Get 20% off on running shoes").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(5.00).image("https://example.com/puma_coupon_image.jpg").build();

            Coupon coupon19 = Coupon.builder().companyId(5).category(Category.JERSEYS).title("Under Armor").description("Under Armor coupon: Buy any two sports jerseys and get the third one at half price").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(49.90).image("https://example.com/underarmor_coupon_image.jpg").build();

            Coupon coupon20 = Coupon.builder().companyId(5).category(Category.BALLS).title("Reebok").description("Reebok coupon: Buy a basketball and get a free basketball pump").startDate(Date.valueOf(LocalDate.now())).endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(50).price(53.00).image("https://example.com/reebok_coupon_image.jpg").build();


            List<Coupon> coupons = Arrays.asList(coupon1, coupon2, coupon3, coupon4, coupon5, coupon6, coupon7, coupon8, coupon9, coupon10, coupon11, coupon12, coupon13, coupon14, coupon15, coupon16, coupon17, coupon18, coupon19, coupon20);
            companiesImpl.addCouponsListToDB(coupons);

            List<Coupon> coupons1 = Arrays.asList(coupon1, coupon2, coupon3, coupon4);
            List<Coupon> coupons2 = Arrays.asList(coupon5, coupon6, coupon7, coupon8);
            List<Coupon> coupons3 = Arrays.asList(coupon9, coupon10, coupon11, coupon12);
            List<Coupon> coupons4 = Arrays.asList(coupon13, coupon16);
            List<Coupon> coupons5 = Arrays.asList(coupon17, coupon18, coupon19, coupon20);

            companiesImpl.addCouponsListToCompany(1, coupons1);
            companiesImpl.addCouponsListToCompany(2, coupons2);
            companiesImpl.addCouponsListToCompany(3, coupons3);
            companiesImpl.addCouponsListToCompany(4, coupons4);
            companiesImpl.addCouponsListToCompany(5, coupons5);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            CustomerServiceImpl customersImpl = (CustomerServiceImpl) loginManager.login("kobi.shasha@gmail.com", "Shasha@2023password", ClientType.CUSTOMER);

            customersImpl.purchaseCouponForBuildingDB(1, 10);
            customersImpl.purchaseCouponForBuildingDB(2, 9);
            customersImpl.purchaseCouponForBuildingDB(3, 8);
            customersImpl.purchaseCouponForBuildingDB(4, 11);
            customersImpl.purchaseCouponForBuildingDB(4, 12);
            customersImpl.purchaseCouponForBuildingDB(4, 17);
            customersImpl.purchaseCouponForBuildingDB(4, 18);
            customersImpl.purchaseCouponForBuildingDB(4, 19);
            customersImpl.purchaseCouponForBuildingDB(5, 6);
            customersImpl.purchaseCouponForBuildingDB(6, 5);
            customersImpl.purchaseCouponForBuildingDB(7, 6);
            customersImpl.purchaseCouponForBuildingDB(7, 9);
            customersImpl.purchaseCouponForBuildingDB(7, 10);
            customersImpl.purchaseCouponForBuildingDB(7, 18);
            customersImpl.purchaseCouponForBuildingDB(7, 19);
            customersImpl.purchaseCouponForBuildingDB(8, 12);
            customersImpl.purchaseCouponForBuildingDB(9, 13);
            customersImpl.purchaseCouponForBuildingDB(10, 5);

            Art.separator();
            Art.initCompanies();
            List<Company> companies2 = adminImpl.getAllCompanies();
            Art.printCompaniesDetails(companies2);
            Art.separator();
            Art.initCustomers();
            List<Customer> customers2 = adminImpl.getAllCustomers();
            Art.printCustomersDetails(customers2);
            Art.separator();
            Art.initCoupons();
            List<Coupon> couponList = adminImpl.getAllCoupons();
            Art.printCouponsDetails(couponList);
            Art.separator();
            Art.DATABASE_READY();

        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }
}
