package com.jb.project2.exeptions;

import lombok.Getter;

@Getter
public enum ErrMsg {

    COMPANY_MINIMUM_2_NOTES_LONG("\u001B[31mThe name of the company must be at least 2 notes long.\u001B[0m"),
    COMPANY_PASSWORD_MINIMUM_10_NOTES_LONG("\u001B[31mThe password of the company must be at least 10 notes long.\u001B[0m"),
    COMPANY_EMAIL_MINIMUM_10_NOTES_LONG("\u001B[31mThe email of the company must be at least 10 notes long.\u001B[0m"),
    DB_DUPLICATE_COMPANY_NAME("\u001B[31mThere's already a company with that name in the DB.\u001B[0m"),
    DB_DUPLICATE_COMPANY_EMAIL("\u001B[31mThere's already a company with that email in the DB.\u001B[0m"),
    COMPANY_NAME_MINIMUM_2_NOTES_LONG("\u001B[31mThe name of the company must be at least 2 notes long.\u001B[0m"),
    UPDATE_FAILED_CANNOT_EDIT_ID_NAME("\u001B[31mYou can't edit the company's ID and name. Updating failed.\u001B[0m"),
    DELETE_FAILED_COMPANY_NOT_FOUND("\u001B[31mThe company you are trying to delete does not exist in the DB. Delete failed.\u001B[0m"),
    COMPANY_NOT_FOUND("\u001B[31mThere is no company with this ID.\u001B[0m"),
    CUSTOMER_NOT_FOUND("\u001B[31mThere is no customer with this ID.\u001B[0m"),
    COUPON_NOT_FOUND("\u001B[31mThere is no coupon with that ID.\u001B[0m"),
    FIRST_NAME_MINIMUM_2_NOTES_LONG("\u001B[31mThe first name must be at least 2 notes long.\u001B[0m"),
    LAST_NAME_MINIMUM_2_NOTES_LONG("\u001B[31mThe last name must be at least 2 notes long.\u001B[0m"),
    EMAIL_MINIMUM_10_NOTES_LONG("\u001B[31mThe email must be at least 10 notes long.\u001B[0m"),
    PASSWORD_MINIMUM_10_NOTES_LONG("\u001B[31mThe password must be at least 10 notes long.\u001B[0m"),
    DB_DUPLICATE_CUSTOMER_EMAIL("\u001B[31mThere's already a customer with that email in the DB. Adding failed.\u001B[0m"),
    DB_UPDATE_FAILED_CUSTOMER_NOT_FOUND("\u001B[31mThere is no customer with this ID in the DB. Updating failed.\u001B[0m"),
    LOGIN_FAILED_INVALID_DETAILS("\u001B[31mLogin failed. You either typed wrong details, or this account doesn't exist.\u001B[0m"),
    DUPLICATE_COUPON_TITLE("\u001B[31mThe title of the coupon that you are trying to add already exists for this company. You cannot have two coupons with the same title.\u001B[0m"),
    ADDING_FAILED_INVALID_COMPANY_ID("\u001B[31mA company can't add a coupon with a company ID of another company. Adding failed.\u001B[0m"),
    ADDING_FAILED_DESCRIPTION_TOO_SHORT("\u001B[31mThe description must be at least 2 notes long. Adding failed.\u001B[0m"),
    ADDING_FAILED_MISSING_IMAGE_LINK("\u001B[31mYou must enter an image link. Adding failed.\u001B[0m"),
    ADDING_FAILED_INVALID_END_DATE("\u001B[31mThe end-date must be in a future date. Adding failed.\u001B[0m"),
    ADDING_FAILED_INVALID_PRICE("\u001B[31mThe price can't be below zero. Adding failed.\u001B[0m"),
    UPDATE_FAILED_CANNOT_CHANGE_IDS("\u001B[31mYou can't change the company ID and the coupon ID of the coupon. Update failed.\u001B[0m"),
    UPDATE_FAILED_INVALID_COMPANY_ID("\u001B[31mA company can't add a coupon with a company ID of another company. Update failed.\u001B[0m"),
    UPDATE_FAILED_DESCRIPTION_TOO_SHORT("\u001B[31mThe description must be at least 2 notes long. Update failed.\u001B[0m"),
    UPDATE_FAILED_MISSING_IMAGE_LINK("\u001B[31mYou must enter an image link. Update failed.\u001B[0m"),
    UPDATE_FAILED_INVALID_END_DATE("\u001B[31mThe end-date must be in a future date. Update failed.\u001B[0m"),
    UPDATE_FAILED_INVALID_PRICE("\u001B[31mThe price can't be below zero. Update failed.\u001B[0m"),
    DELETE_FAILED_COUPON_NOT_FOUND("\u001B[31mThe coupon you are trying to delete does not exist in the DB. Delete failed.\u001B[0m"),
    DELETE_FAILED_CANNOT_DELETE_OTHER_COMPANY_COUPON("\u001B[31mYou can't delete coupons of other companies. Delete failed.\u001B[0m"),
    INVALID_MAX_PRICE("\u001B[31mThe maximum price can't be below 0.\u001B[0m"),
    COUPON_EXPIRED("\u001B[31mThe end date of this coupon has already passed. Purchase was not done.\u001B[0m"),
    OUT_OF_STOCK("\u001B[31mSorry, there are no more coupons of that kind in our stock. No purchase was done.\u001B[0m"),
    COUPON_ALREADY_PURCHASED("\u001B[31mThis coupon was already purchased by this customer. A customer cannot have more than one of the same coupon.\u001B[0m"),








    ADMIN_LOGIN_ERROR("\u001B[31mLogin failed, Wrong Email or password.\u001B[0m"),

    COMPANY_NAME_EXIST("\u001B[31mCannot add company with existing name.\u001B[0m"),

    COMPANY_ID_EXIST("\u001B[31mCannot add company with existing id.\u001B[0m"),

    COMPANY_EMAIL_EXIST("\u001B[31mCannot add company with existing email.\u001B[0m"),

    AUTHENTICATION_FAILED("\u001B[31mPlease try again as your email or password is incorrect.\u001B[0m"),

    CUSTOMER_EMAIL_EXIST("\u001B[31mCannot add Customer with existing email.\u001B[0m"),

    CUSTOMER_ID_EXIST("\u001B[31mCannot add Customer with existing id.\u001B[0m"),

    COMPANY_EMAIL_OR_PASSWORD("\u001B[31mInvalid email or password.\u001B[0m"),

    CUSTOMER_EMAIL_OR_PASSWORD("\u001B[31mInvalid email or password.\u001B[0m"),

    COUPON_TITLE_EXIST("\u001B[31mCannot add coupon with existing title.\u001B[0m"),

    COUPON_OUT_OF_STOCK("\u001B[31mcoupon out of stock, please try again later.\u001B[0m"),

    NOT_EXIST_COMPANY("\u001B[31mCompany doesn't exists.\u001B[0m"),

    NOT_EXIST_COUPON("\u001B[31mCoupon not found.\u001B[0m"),

    NOT_EXIST_CUSTOMER("\u001B[31mCustomer not found.\u001B[0m"),

    COMPANY_UPDATE_ID("\u001B[31mError, Company's ID cannot be updated.\u001B[0m"),

    COMPANY_UPDATE_NAME("\u001B[31mError, Company's name cannot be updated.\u001B[0m"),

    CUSTOMER_UPDATE_ID("\u001B[31mError, Customer's ID cannot be updated.\u001B[0m"),

    COUPON_UPDATE_ID("\u001B[31mError, coupon's ID cannot be updated.\u001B[0m"),

    COUPON_UPDATE_COMP_ID("\u001B[31mError, company's ID cannot be updated.\u001B[0m"),

    COUPON_PURCHASED("\u001B[31mThis coupon has already been purchased by you, cannot purchase again.\u001B[0m"),

    INVALID_CLIENT_TYPE("\u001B[31mClient type not supported.\u001B[0m"),

    LOGIN_FAILED("\u001B[31mFailed to log in.\u001B[0m"),

    INVALID_COUPON_DELETE("\u001B[31mCannot delete coupons assigned to another companies.\u001B[0m"),

    INVALID_COUPON_UPDATE("\u001B[31mCannot update offer assigned to another companies.\u001B[0m"),

    INVALID_COUPONS_TITLE_UPDATE("\u001B[31mCannot update coupon title.\u001B[0m"),

    INVALID_ADD_COUPON("\u001B[31mCannot add coupon to another company.\u001B[0m"),

    INVALID_UPDATE_COUPON("\u001B[31mCannot update coupon assigned to another company.\u001B[0m"),

    EPIC_FAIL("Epic fail try again.");


    private final String MESSAGE;

    ErrMsg(String message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}


