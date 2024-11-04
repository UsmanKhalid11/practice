package com.sample.securitypractice.reposotory;

import com.sample.securitypractice.entities.JwtTokenEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JwtDetailRepo extends JpaRepository<JwtTokenEntities, Double> {

    public JwtTokenEntities findByUserNameAndExpired(String username,boolean expiry);
    public List<JwtTokenEntities> findByExpired(boolean expired);
    //above could have been done better by using native query but i dont want to as it will take extra time
}
