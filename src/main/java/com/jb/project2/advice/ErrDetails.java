package com.jb.project2.advice;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrDetails {

    private final String title = "CouponSystemError";
    private String description;
}
