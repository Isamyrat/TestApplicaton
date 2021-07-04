package com.test.springBoot.application.resource;

import com.test.springBoot.application.model.Basket;
import com.test.springBoot.application.model.User;
import com.test.springBoot.application.service.BasketService;
import com.test.springBoot.application.service.SendEmailService;
import com.test.springBoot.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private BasketService basketService;

    @PostMapping
    public List<User> addUser(@RequestBody String name, String email, String password) {
        // Проверка на существование аккаунта!!!
       if (!userService.saveUser(name,email,password)){
           System.out.println("User with this email is already exist!!!");
        }

        return userService.getAllUsers();
    }

    /* Получение всех пользователей (Admin)*/
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/getAllBaskets")
    public List<Basket> getAllBasket() {
        return basketService.getAllBaskets();
    }


    /*   --/--  Изменение данных (User)
    P.S. учел момент если пользователь поменяет почту --/-- */
    @PostMapping("/editUser")
    public User edit(@RequestBody Long id, String name, String email, String password) {

        userService.editUser(id, name, email, password);


        return userService.getUser(id);
    }

    /*   --/--  Удаление данных (User) --/-- */
    @PostMapping("/deleteUser")
    public List<User> deleteUser(@RequestBody Long userId) {
        sendEmailService.sendDeleteProfileMail(userId);
        userService.deleteUser(userId);

        return userService.getAllUsers();
    }
}
