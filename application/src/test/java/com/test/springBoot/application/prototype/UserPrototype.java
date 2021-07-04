package com.test.springBoot.application.prototype;

import com.test.springBoot.application.model.User;

import java.time.LocalDate;

public class UserPrototype {
    public static User aUser() {
        User u = new User();
        u.setName("test_name");
        u.setEmail("test_login");
        u.setPassword("test_name");
        u.setCreate_at(LocalDate.now());
        u.setRole("ROLE_USER");
        return u;
    }
}
