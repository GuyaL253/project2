package com.jb.project2.exeptions;

public class CouponSystemException extends Exception{

        public CouponSystemException() {
        }

        public CouponSystemException(ErrMsg message) {
            super(message.getMessage());
        }
    }

