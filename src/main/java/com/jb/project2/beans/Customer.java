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
    private int customerId;

    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 30, nullable = false)
    private String lastName;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 30, nullable = false)
    private String password;

    @Singular
//  The @Singular annotation is used in Java to indicate
//  that a field defined as a collection (such as List, Set, etc.)
// should only contain a single value instead of a list of values
//. For example, if you have a field named "coupons" of type List<Coupon>
// and you add the @Singular annotation, you would be allowed to access the
// "coupons" field like this: object.getCoupons().add(coupon), instead of
// object.getCoupons().add(Arrays.asList(coupon1, coupon2)) which adds a
// complete list of coupons.
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Coupon> coupons;
}
