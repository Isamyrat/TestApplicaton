package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Query("select b from Basket b where b.userBasket.id = :id")
    Basket findByUserId(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from Basket  where user_id = :id", nativeQuery = true)
    void deleteAllByUserId(Long id);
}
