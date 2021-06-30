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

   /* Для перехода в страницу регистрации (Регистрация)*/
    /*
    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("userForm", new User());

        return "--/--";
    }*/

    @PostMapping
    public List<User> addUser(@RequestBody String name, String email, String password) {
       /*  Проверка на существование аккаунта!!!
       if (!userService.saveUser(name,email,password)){
            model.addAttribute("usernameError", "User with this email is already exist!!!");
            return "--/--";
        }*/

        userService.saveUser(name, email, password);

        return userService.getAllUsers();
    }


    /*   --/--   Для перехова в профиль (User)  --/-- */

   /* @GetMapping("/personalInformationUser")
    public String personalInformationUser(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user = userService.findUserByName(userDetails.getEmail());

        model.addAttribute("userId", userService.findUserById(user.getId()));
        return "--/--";
    }*/

    /* Получение всех пользователей (Admin)*/
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/asd")
    public List<Basket> getAllBasket() {
        return basketService.getAllBaskets();
    }


    /*   --/--   Для перехова в профиль чтобы изменить (User)  --/-- */

   /* @GetMapping("/userEdit")
    public String personalInformationUser(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user = userService.getUser(userDetails.getUsername());

        model.addAttribute("userEdit", userService.findUserById(user.getId()));

        return "--/--";
    }*/

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
