package com.intercore.intercore.repository;

import com.intercore.intercore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByActivationCode(String code);
}
