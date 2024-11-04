package com.sample.securitypractice.reposotory;

import com.sample.securitypractice.entities.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDetailRepo  extends JpaRepository<UserDetailEntity, Double> {

    public Optional<UserDetailEntity> findByUsername(String username);
}
