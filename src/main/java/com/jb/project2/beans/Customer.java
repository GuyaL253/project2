package com.jb.project2.beans;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(length = 20,nullable = false)
    private String firstName;

    @Column(length = 20,nullable = false)
    private String lastName;

    @Column(length = 20,nullable = false)
    private String email;

    @Column(length = 20,nullable = false)
    private String password;

    @Singular
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Coupon> coupons;
}
