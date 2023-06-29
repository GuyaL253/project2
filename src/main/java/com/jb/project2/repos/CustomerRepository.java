package com.jb.project2.repos;

import com.jb.project2.beans.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);

    Customer findByEmailAndPassword(String email, String password);

    boolean existsByEmailAndPassword(String email, String password);

    Customer findFirstByEmailAndPassword(String email, String password);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `project2`.`customers_coupons` (`customer_customer_id`, `coupons_coupon_id`) VALUES (?,?);", nativeQuery = true)
    void addPurchase(int customer_id, int coupon_id);
}
