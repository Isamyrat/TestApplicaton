package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String name);
}
