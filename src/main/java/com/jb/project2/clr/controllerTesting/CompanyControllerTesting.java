//package com.jb.project2.clr.controllerTesting;
//
//
//import com.jb.project2.beans.Category;
//import com.jb.project2.beans.Company;
//import com.jb.project2.beans.Coupon;
//import com.jb.project2.utills.Art;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import java.sql.Date;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//
//@Component
//@Order(6)
//public class CompanyControllerTesting implements CommandLineRunner {
//    @Autowired
//    protected RestTemplate restTemplate;
//    @Value("${company_url}")
//    private String url;
//    private final Coupon coupon = Coupon.builder()
//            .amount(230)
//            .category(Category.BALLS)
//            .description("this is the description")
//            .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
//            .image("http://blablabla.jpg")
//            .price(120)
//            .startDate(Date.valueOf(LocalDate.now().minusDays(6)))
//            .title("restTemplate new").build();
//    private final Coupon couponToUpdate = Coupon.builder()
//            .amount(230)
//            .category(Category.BALLS)
//            .description("this is the description")
//            .endDate(Date.valueOf(LocalDate.now().plusDays(7)))
//            .image("http://blablabla.jpg")
//            .price(120)
//            .startDate(Date.valueOf(LocalDate.now().minusDays(6)))
//            .title("restTemplate update").build();
//
//    @Override
//    public void run(String... args) throws Exception {
//        Art.controlDescription("\t\ttesting companyController\n");
//        int companyId = 1;
////        getCompanyCoupons(companyId);
//        addCoupon(companyId, coupon);
////        int couponId = 1;
////        updateCoupon(companyId, 2, couponToUpdate);
////        deleteCoupon(companyId, couponId);
////        getCompanyCoupons(companyId, Category.JERSEYS);
////        getCompanyCoupons(companyId, 170.5);
////        getCompanyDetails(companyId);
//        Art.controlDescription("\t\ttesting companyController ended\n");
//    }
//
//    private void addCoupon(int companyId, Coupon coupon) {
//        HttpEntity<Coupon> add = new HttpEntity<>(coupon);
//        try {
//            ResponseEntity<Coupon> res = restTemplate.exchange(url + companyId + "/coupons", HttpMethod.POST, add, Coupon.class);
//            Art.controlDescription("|--->\tcompany addCoupon success. response status is: " + (res.getStatusCodeValue()));
//            getCompanyCoupons(companyId);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tcompany addCoupon fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void updateCoupon(int companyId, int couponId, Coupon coupon) {
//        coupon.setCouponId(couponId);
//        try {
//            HttpEntity<Coupon> update = new HttpEntity<>(coupon);
//            ResponseEntity<Coupon> res = restTemplate.exchange(url + companyId + "/coupon/" + couponId, HttpMethod.PUT, update, Coupon.class);
//            Art.controlDescription("|--->\tcompany updateCoupon success. response status is: " + (res.getStatusCodeValue()));
//            getCompanyCoupons(companyId);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tcompany updateCompany fail");
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private void deleteCoupon(int companyId, int couponId) {
//        try {
//            ResponseEntity<Coupon> res = restTemplate.exchange(url + companyId + "/coupon/" + couponId, HttpMethod.DELETE, null, Coupon.class);
//            Art.controlDescription("|--->\tcompany deleteCoupon success. response status is: " + (res.getStatusCodeValue()));
//            getCompanyCoupons(companyId);
//        } catch (Exception e) {
//            Art.controlDescription("|--->\tcompany deleteCoupon fail");
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    private void getCompanyCoupons(int companyId) {
//        ResponseEntity<List<Coupon>> res = restTemplate.exchange(url + companyId + "/coupons", HttpMethod.GET, null, new ParameterizedTypeReference<List<Coupon>>() {
//        });
//        Art.controlDescription("|--->\tcompany getCompanyCoupons. response status is: " + (res.getStatusCodeValue()));
//        Objects.requireNonNull(res.getBody()).forEach(System.out::println);
//    }
//
//    private void getCompanyCoupons(int companyId, Category category) {
//        ResponseEntity<List<Coupon>> res = restTemplate.exchange(url + companyId + "/coupons/byCategory?category=" + category, HttpMethod.GET, null, new ParameterizedTypeReference<List<Coupon>>() {
//        });
//        Art.controlDescription("|--->\tcompany getCompanyCoupons by category. response status is: " + (res.getStatusCodeValue()));
//        Objects.requireNonNull(res.getBody()).forEach(System.out::println);
//    }
//
//    private void getCompanyCoupons(int companyId, double maxPrice) {
//        ResponseEntity<List<Coupon>> res = restTemplate.exchange(url + companyId + "/coupons/byMaxPrice?maxPrice=" + maxPrice, HttpMethod.GET, null, new ParameterizedTypeReference<List<Coupon>>() {
//        });
//        Art.controlDescription("|--->\tcompany getCompanyCoupons by maxPrice. response status is: " + (res.getStatusCodeValue()));
//        Objects.requireNonNull(res.getBody()).forEach(System.out::println);
//    }
//
//    private void getCompanyDetails(int companyId) {
//        ResponseEntity<Company> res = restTemplate.exchange(url + companyId + "/details", HttpMethod.GET, null, new ParameterizedTypeReference<Company>() {
//        });
//        Art.controlDescription("|--->\tcompany getCompanyCoupons by maxPrice. response status is: " + (res.getStatusCodeValue()));
//        System.out.println(res.getBody());
//    }
//}