package com.jb.project2.exeptions;

public class CustomException extends Exception {

    public CustomException(String message) {
        System.out.println(message);
    }
}
