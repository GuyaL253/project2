package com.jb.project2.service;

import com.jb.project2.beans.Category;
import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.dto.LoginResDto;
import com.jb.project2.exeptions.CouponSystemException;
import com.jb.project2.exeptions.CustomException;
import com.jb.project2.exeptions.ErrMsg;
import com.jb.project2.security.LoginInfo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
public class CompanyServiceImpl extends ClientService implements CompanyService {

    private static Date currentDate = Date.valueOf(LocalDate.now());
    private static Company companyLoggedIn;

    @Override
    public LoginResDto login(String email, String password) throws CouponSystemException {
        if (companyRepository.existsByEmailAndPassword(email, password)) {
            Company loggedInCompany = companyRepository.findFirstByEmailAndPassword(email, password);
            int companyId = loggedInCompany.getCompanyId();
            tokenService.addClient(companyId, ClientType.COMPANY);
            LoginInfo loginInfo = LoginInfo.builder()
                    .id(companyId)
                    .clientType(ClientType.COMPANY)
                    .time(LocalDateTime.now())
                    .build();
            UUID token = tokenService.getToken(loginInfo);

            // Set the companyLoggedIn variable with the logged-in company
            companyLoggedIn = loggedInCompany;

            return LoginResDto.builder()
                    .id(companyId)
                    .token(token)
                    .clientType(ClientType.COMPANY)
                    .build();
        }
        throw new CouponSystemException(ErrMsg.LOGIN_FAILED);
    }


    @Override
    public void addCoupon(Coupon coupon) throws CouponSystemException {
        if (couponRepository.findByCompanyIdAndTitle(coupon.getCompanyId(), coupon.getTitle()) != null) {
            throw new CouponSystemException(ErrMsg.DUPLICATE_COUPON_TITLE);
        }
        if (coupon.getCompanyId() != companyLoggedIn.getCompanyId()) {
            throw new CouponSystemException(ErrMsg.ADDING_FAILED_INVALID_COMPANY_ID);
        }
        if (coupon.getDescription().equals("")) {
            throw new CouponSystemException(ErrMsg.ADDING_FAILED_DESCRIPTION_TOO_SHORT);
        }
        if (coupon.getImage().equals("")) {
            throw new CouponSystemException(ErrMsg.ADDING_FAILED_MISSING_IMAGE_LINK);
        }
//        if (coupon.getEndDate().before(new Date(2023,06,07))) {
//            throw new CouponSystemException(ErrMsg.ADDING_FAILED_INVALID_END_DATE);
//        }
        if (coupon.getPrice() < 0) {
            throw new CouponSystemException(ErrMsg.ADDING_FAILED_INVALID_PRICE);
        }

        couponRepository.save(coupon);
        List<Coupon> coupons = companyLoggedIn.getCoupons();
        coupons.add(coupon);
        companyLoggedIn.setCoupons(coupons);
        companyRepository.save(companyLoggedIn);
    }

    public void addCouponsListToDB(List<Coupon> coupons) throws CouponSystemException, CustomException {
        for (Coupon coupon : coupons) {
            if (couponRepository.findByCompanyIdAndTitle(coupon.getCompanyId(), coupon.getTitle()) != null) {
                throw new CustomException("The title '" + coupon.getTitle() + "' you are trying to add already exists for this company." +
                        " You can not have two coupons with the same title.");
            }
            if (coupon.getTitle().equals("")) {
                throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': title field can't be empty." +
                        " \nAdding failed.");
            }
            if (coupon.getDescription().equals("")) {
                throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': description field can't be empty." +
                        " \nAdding failed.");
            }
            if (coupon.getImage().equals("")) {
                throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': image can't be empty." +
                        " \nAdding failed.");
            }
            if (coupon.getEndDate().before(currentDate)) {
                throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': The end-date must be in a future date." +
                        "\nAdding failed.");
            }
            if (coupon.getPrice() < 0) {
                throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': The price can't be below zero." +
                        " \nAdding failed.");
            }
            couponRepository.save(coupon);
        }
    }

    public void addCouponsListToCompany(int companyId, List<Coupon> coupons) throws CouponSystemException, CustomException {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND));
        for (Coupon coupon : coupons) {
            if (company.getCoupons().contains(coupon)) {
                throw new CustomException("The coupon '" + coupon.getTitle() + "' already exists at this company.");
            }
            if (coupon.getEndDate().before(currentDate)) {
                throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': The end-date must be in a future date." +
                        "\nAdding failed.");
            }
        }
        company.setCoupons(coupons);
        companyRepository.save(company);
    }

    @Override
    public void updateCoupon(Coupon coupon) throws CouponSystemException, CustomException {
        if (couponRepository.findByCompanyIdAndCouponId(coupon.getCompanyId(), coupon.getCouponId()) == null) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_CANNOT_CHANGE_IDS);
        }
        if (coupon.getCompanyId() != companyLoggedIn.getCompanyId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_INVALID_COMPANY_ID);
        }
        if (coupon.getDescription().equals("")) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_DESCRIPTION_TOO_SHORT);
        }
        if (coupon.getImage().equals("")) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_MISSING_IMAGE_LINK);
        }
        if (coupon.getEndDate().before(currentDate)) {
            throw new CustomException("Problem with coupon '" + coupon.getTitle() + "': The end-date must be in a future date." +
                    "\nAdding failed.");
        }
        if (coupon.getPrice() < 0) {
            throw new CouponSystemException(ErrMsg.UPDATE_FAILED_INVALID_PRICE);
        }
        couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CouponSystemException {
        System.out.println("a");
        if (!couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrMsg.DELETE_FAILED_COUPON_NOT_FOUND);
        }
        Optional<Coupon> couponForDelete = couponRepository.findById(couponId);
        if (companyLoggedIn.getCompanyId() != couponForDelete.get().getCompanyId()) {
            throw new CouponSystemException(ErrMsg.DELETE_FAILED_CANNOT_DELETE_OTHER_COMPANY_COUPON);
        }
        System.out.println("b");
        couponRepository.deleteByCouponId(couponId);
        System.out.println("c");
        couponRepository.deleteByCouponsId(couponId);
        System.out.println("d");
        couponRepository.deleteById(couponId);
        System.out.println("e");
    }

    @Override
    public void deleteCouponByDate(LocalDate now) {
        couponRepository.findByEndDateBefore(now).forEach(coupon -> {
            try {
                deleteCoupon(coupon.getCouponId());
            } catch (CouponSystemException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public List<Coupon> getCompanyCoupons(int companyId) {
        return couponRepository.findAllByCompanyId(companyId);
    }

    @Override
    public List<Coupon> getCompanyCouponsByMaxPrice(double maxPrice) throws CouponSystemException {
        if (maxPrice < 0) {
            throw new CouponSystemException(ErrMsg.INVALID_MAX_PRICE);
        }
        return companyLoggedIn.getCoupons().stream().filter(coupon -> coupon.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    @Override
    public List<Coupon> getCompanyCouponsByCategory(Category category) {
        return couponRepository.findAllByCompanyIdAndCategory(companyLoggedIn.getCompanyId(), category);
    }

    public Coupon getOneCoupon(int couponId) throws CouponSystemException {
        return couponRepository.findById(couponId).orElseThrow(() -> new CouponSystemException(ErrMsg.COUPON_NOT_FOUND));
    }

    @Override
    public Company getCompanyDetails() {
        return companyLoggedIn;
    }

    @Override
    public List<Coupon> getCompanyCoupons() {
        return companyLoggedIn.getCoupons();
    }

    public Company getCompanyLoggedIn() {
        return companyLoggedIn;
    }
}
