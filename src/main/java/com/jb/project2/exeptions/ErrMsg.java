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
    COUPON_NOT_FOUND("There is no coupon with that ID."),
    FIRST_NAME_MINIMUM_2_NOTES_LONG("The first name must be at least 2 notes long."),
    LAST_NAME_MINIMUM_2_NOTES_LONG("The last name must be at least 2 notes long."),
    EMAIL_MINIMUM_10_NOTES_LONG("The email must be at least 10 notes long."),
    PASSWORD_MINIMUM_10_NOTES_LONG("The password must be at least 10 notes long."),
    DB_DUPLICATE_CUSTOMER_EMAIL("There's already a customer with that email in the DB. Adding failed."),
    DB_UPDATE_FAILED_CUSTOMER_NOT_FOUND("There is no customer with this ID in the DB. Updating failed."),
    DUPLICATE_COUPON_TITLE("The title of the coupon that you are trying to add already exists for this company. You cannot have two coupons with the same title."),
    ADDING_FAILED_INVALID_COMPANY_ID("A company can't add a coupon with a company ID of another company. Adding failed."),
    ADDING_FAILED_DESCRIPTION_TOO_SHORT("The description must be at least 2 notes long. Adding failed."),
    ADDING_FAILED_MISSING_IMAGE_LINK("You must enter an image link. Adding failed."),
    ADDING_FAILED_INVALID_PRICE("The price can't be below zero. Adding failed."),
    UPDATE_FAILED_CANNOT_CHANGE_IDS("You can't change the company ID and the coupon ID of the coupon. Update failed."),
    UPDATE_FAILED_INVALID_COMPANY_ID("A company can't add a coupon with a company ID of another company. Update failed."),
    UPDATE_FAILED_DESCRIPTION_TOO_SHORT("The description must be at least 2 notes long. Update failed."),
    UPDATE_FAILED_MISSING_IMAGE_LINK("You must enter an image link. Update failed."),
    UPDATE_FAILED_INVALID_PRICE("The price can't be below zero. Update failed."),
    DELETE_FAILED_COUPON_NOT_FOUND("The coupon you are trying to delete does not exist in the DB. Delete failed."),
    DELETE_FAILED_CANNOT_DELETE_OTHER_COMPANY_COUPON("You can't delete coupons of other companies. Delete failed."),
    INVALID_MAX_PRICE("The maximum price can't be below 0."),
    OUT_OF_STOCK("Sorry, there are no more coupons of that kind in our stock. No purchase was done."),
    COUPON_ALREADY_PURCHASED("This coupon was already purchased by this customer. A customer cannot have more than one of the same coupon."),
    RESTRICTED_AREA("restricted area, you are not allowed to view this content"),
    LOGIN_FAILED("Failed to log in."),
    CUSTOMER_ID_CHANGE_NOT_ALLOWED("Customer id is not changeable."),

    LOGIN_FAILED_INVALID_DETAILS("Login failed. You either typed wrong details, or this account doesn't exist."),
    SECURITY_CANNOT_CREATE_ADMIN("ha ha ha nice try"),
    ADDING_FAILED_INVALID_END_DATE("The end-date must be in a future date. Adding failed."),
    COUPON_EXPIRED("The end date of this coupon has already passed. Purchase was not done."),
    UPDATE_FAILED_INVALID_END_DATE("The end-date must be in a future date. Update failed.");


    private final String MESSAGE;

    ErrMsg(String message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}


