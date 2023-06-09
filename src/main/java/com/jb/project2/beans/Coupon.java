package com.jb.project2.beans;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int couponId;

    @Column(updatable = false)
    private int companyId;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;

    private int amount;

    private double price;

    private String image;

}
