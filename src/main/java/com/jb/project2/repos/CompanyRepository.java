package com.jb.project2.repos;

import com.jb.project2.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findByName(String name);
    Company findByEmail(String email);
    Company findByCompanyIdAndName(int companyId, String name);
    boolean existsByEmailAndPassword(String email, String password);
    Company findFirstByEmailAndPassword(String email, String password);



}
