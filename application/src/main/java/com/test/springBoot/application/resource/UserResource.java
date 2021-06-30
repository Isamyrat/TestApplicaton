/*
package com.test.springBoot.application.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/rest/users")
@Api(value = "User Resource REST Endpoint", description = "Shows the user info")
public class UserResource {


    List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getUsers() {


        return users;
    }
    @PostMapping
    public List<User> AddUsers(@RequestBody String name, Long salary) {

        User user =  new User("Sam", 2000L);
        User user1 =   new User("Peter", 1000L);
        User user2 =   new User(name, salary);
        users.add(user);
        users.add(user1);
        users.add(user2);
        return users;
    }

    @GetMapping("/{userName}")
    public User getUser(@PathVariable("userName") final String userName)
    {
        return new User(userName, 1000L);
    }


    private class User {

        @ApiModelProperty(notes = "name of the User")
        private String userName;

        @ApiModelProperty(notes = "salary of the user")
        private Long salary;

        public User(String userName, Long salary) {
            this.userName = userName;
            this.salary = salary;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getSalary() {
            return salary;
        }

        public void setSalary(Long salary) {
            this.salary = salary;
        }
    }
}
*/
