package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.UserRepository;
import com.test.springBoot.application.model.Enum.Roles;
import com.test.springBoot.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    BasketService basketService;
    public User findUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(new User());
    }

    public User findUserByName(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Boolean saveUser(String name, String email, String password) {

        /* Проверка если есть такая почта то не будет добавлять*/
        User userFromDB = userRepository.findByEmail(email);
        if (userFromDB != null) {
            return false;
        }
        User user = new User(name, email, password, Roles.ROLE_USER.toString(), LocalDate.now());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        sendEmailService.sendRegistrationMail(user.getId());
        basketService.saveBasket(user.getId());
        return true;
    }

    public void deleteUser(Long userId) {
        basketService.deleteBasket(userId);
        userRepository.deleteById(userId);
    }

    public void editUser(Long id, String name,String email,String password) {
        User user = findUserById(id);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);


        sendEmailService.sendChangeProfileMail(id);
    }
    public User getUser(Long id) {
        return findUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
