package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.BasketRepository;
import com.test.springBoot.application.model.Basket;
import com.test.springBoot.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BasketService {
    @Autowired
    BasketRepository basketRepository;

    @Autowired
    UserService userService;

    public Boolean saveBasket(Long id) {

        User user = userService.findUserById(id);
        Basket basket = new Basket();
        basket.setUserBasket(user);

        basketRepository.save(basket);
        return true;
    }
    public void deleteBasket(Long userId) {
        User user = userService.findUserById(userId);
        basketRepository.deleteAllByUserId(user.getId());
    }

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }
}
