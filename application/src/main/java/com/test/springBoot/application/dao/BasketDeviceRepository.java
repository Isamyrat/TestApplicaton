package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.Basket;
import com.test.springBoot.application.model.BasketDevice;
import com.test.springBoot.application.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public interface BasketDeviceRepository extends JpaRepository<BasketDevice, Long> {

     BasketDevice findByBasketAndDeviceBasket(Basket basket, Device deviceBasket);

     List<BasketDevice> findByDeviceBasket(Device device);

    @Modifying
    @Transactional
    @Query(value = "delete from BASKET_DEVICE where DEVICE_ID =  :id", nativeQuery = true)
    void deleteBasketDeviceByDeviceId(Long id);

}
