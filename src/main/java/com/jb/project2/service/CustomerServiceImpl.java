package com.jb.project2.service;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;
import com.jb.project2.dto.LoginResDto;
import com.jb.project2.exceptions.CouponSystemException;
import com.jb.project2.exceptions.CustomException;
import com.jb.project2.exceptions.ErrMsg;
import com.jb.project2.security.LoginInfo;
import com.jb.project2.utills.Art;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class CustomerServiceImpl extends ClientService implements CustomerService {

    private static Date currentDate = Date.valueOf(LocalDate.now());

    private static Customer customerLoggedIn;

    @Override
    public LoginResDto login(String email, String password) throws CouponSystemException {
        if (customerRepository.existsByEmailAndPassword(email, password)) {
            Customer loggedInCustomer = customerRepository.findFirstByEmailAndPassword(email, password);
            int customerId = loggedInCustomer.getCustomerId();
            tokenService.addClient(customerId, ClientType.CUSTOMER);
            LoginInfo loginInfo = LoginInfo.builder()
                    .id(customerId)
                    .clientType(ClientType.CUSTOMER)
                    .time(LocalDateTime.now())
                    .build();
            UUID token = tokenService.getToken(loginInfo);

            customerLoggedIn = loggedInCustomer;

            return LoginResDto.builder()
                    .id(customerId)
                    .token(token)
                    .clientType(ClientType.CUSTOMER)
                    .build();
        }
        throw new CouponSystemException(ErrMsg.LOGIN_FAILED);
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
        if (coupon.getEndDate().before(currentDate)) {
            throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': The end-date must be in a future date." +
                    "\nAdding failed.");
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
        Art.printCustomerDetails(customerLoggedIn);
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
        if (coupon.getEndDate().before(currentDate)) {
            throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': The end-date must be in a future date." +
                    "\nAdding failed.");
        }

        coupon.setAmount(coupon.getAmount() - 1);
        couponRepository.save(coupon);
        customer.getCoupons().add(coupon);
        customerRepository.save(customer);
    }

    public Customer getCustomerLoggedIn() {
        return customerLoggedIn;
    }

}

