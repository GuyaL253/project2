package com.jb.project2.repos;

import com.jb.project2.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByEmail(String email);
    Customer findByEmailAndPassword(String email, String password);
}
