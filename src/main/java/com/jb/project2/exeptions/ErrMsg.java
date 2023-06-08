package com.jb.project2.exeptions;

import lombok.Getter;

@Getter
public enum ErrMsg {

    COMPANY_MINIMUM_2_NOTES_LONG("The name of the company must be at least 2 notes long."),
    COMPANY_PASSWORD_MINIMUM_10_NOTES_LONG("The password of the company must be at least 10 notes long."),
    COMPANY_EMAIL_MINIMUM_10_NOTES_LONG("The email of the company must be at least 10 notes long."),
    DB_DUPLICATE_COMPANY_NAME("There's already a company with that name in the DB."),
    DB_DUPLICATE_COMPANY_EMAIL("There's already a company with that email in the DB."),
    COMPANY_NAME_MINIMUM_2_NOTES_LONG("The name of the company must be at least 2 notes long."),
    UPDATE_FAILED_CANNOT_EDIT_ID_NAME("You can't edit the company's ID and name. Updating failed."),
    DELETE_FAILED_COMPANY_NOT_FOUND("The company you are trying to delete does not exist in the DB. Delete failed."),
    COMPANY_NOT_FOUND("There is no company with this ID."),
    CUSTOMER_NOT_FOUND("There is no customer with this ID."),
    FIRST_NAME_MINIMUM_2_NOTES_LONG("The first name must be at least 2 notes long."),
    LAST_NAME_MINIMUM_2_NOTES_LONG("The last name must be at least 2 notes long."),
    EMAIL_MINIMUM_10_NOTES_LONG("The email must be at least 10 notes long."),
    PASSWORD_MINIMUM_10_NOTES_LONG("The password must be at least 10 notes long."),
    DB_DUPLICATE_CUSTOMER_EMAIL("There's already a customer with that email in the DB. Adding failed."),
    DB_UPDATE_FAILED_CUSTOMER_NOT_FOUND("There is no customer with this ID in the DB. Updating failed."),












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

    COUPON_EXPIRED("\u001B[31mSorry, coupon has expired.\u001B[0m"),

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


