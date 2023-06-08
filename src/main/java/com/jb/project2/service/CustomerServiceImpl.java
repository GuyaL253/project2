package com.jb.project2.service;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import com.jb.project2.exeptions.ErrMsg;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class CustomerServiceImpl extends ClientService implements CustomerService {
    private static Customer customerLoggedIn;

    @Override
    public boolean login(String email, String password) throws CouponSystemException {
        customerLoggedIn = customerRepository.findByEmailAndPassword(email, password);
        if (customerLoggedIn == null) {
            throw new CouponSystemException(ErrMsg.LOGIN_FAILED_INVALID_DETAILS);
        }
        return true;
    }

    @Override
    public void purchaseCoupon(int couponID) throws CouponSystemException, CustomException {
        Coupon coupon = couponRepository.findById(couponID).orElseThrow(() -> new CustomException("There is no coupon with the id: " + couponID));
        if (customerLoggedIn.getCoupons().contains(coupon)) {
            throw new CouponSystemException(ErrMsg.COUPON_ALREADY_PURCHASED);
        }
        if (coupon.getAmount() == 0) {
            throw new CouponSystemException(ErrMsg.OUT_OF_STOCK);
        }
        if (coupon.getEndDate().before(new Date(2023,06,07))) {
            throw new CouponSystemException(ErrMsg.COUPON_EXPIRED);
        }
        coupon.setAmount(coupon.getAmount() - 1);
        couponRepository.save(coupon);
        customerLoggedIn.getCoupons().add(coupon);
        customerRepository.save(customerLoggedIn);
    }

    @Override
    public List<Coupon> getCustomerCoupons() {
        return customerLoggedIn.getCoupons();
    }

    @Override
    public List<Coupon> getCustomerCouponsByCategory(Category category) {
        return customerLoggedIn.getCoupons().stream().filter(coupon -> coupon.getCategory() == category).collect(Collectors.toList());
    }

    @Override
    public List<Coupon> getCustomerCouponsByMaxPrice(double maxPrice) throws CouponSystemException {
        if (maxPrice < 0) {
            throw new CouponSystemException(ErrMsg.INVALID_MAX_PRICE);
        }
        return customerLoggedIn.getCoupons().stream().filter(coupon -> coupon.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    @Override
    public void showCustomerDetails() {
        System.out.println(customerLoggedIn);
    }

    @Override
    public void purchaseCouponForBuildingDB(int customerID, int couponID) throws CouponSystemException, CustomException {
        Coupon coupon = couponRepository.findById(couponID).orElseThrow(() -> new CustomException("There is no coupon with the id: " + couponID));
        Customer customer = customerRepository.findById(customerID).orElseThrow(() -> new CustomException("There is no customer with the id: " + customerID));
        if (customer.getCoupons().contains(coupon)) {
            throw new CustomException("Coupon number " + couponID + " was already purchased by this customer." +
                    " A customer can not have more then one of the same coupon.");
        }
        if (coupon.getAmount() == 0) {
            throw new CustomException("Sorry, coupon number " + couponID +
                    " ran-out in our stock. No purchase was done.");
        }
        if (coupon.getEndDate().before(new Date(2023,06,07))) {
            throw new CouponSystemException(ErrMsg.COUPON_EXPIRED);
        }
        coupon.setAmount(coupon.getAmount() - 1);
        couponRepository.save(coupon);
        customer.getCoupons().add(coupon);
        customerRepository.save(customer);
    }
}
