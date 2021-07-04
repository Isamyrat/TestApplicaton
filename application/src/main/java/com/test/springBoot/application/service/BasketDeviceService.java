package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.BasketDeviceRepository;
import com.test.springBoot.application.dao.BasketRepository;
import com.test.springBoot.application.model.Basket;
import com.test.springBoot.application.model.BasketDevice;
import com.test.springBoot.application.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BasketDeviceService {

    @Autowired
    private BasketDeviceRepository basketDeviceRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private SendEmailService sendEmailService;

    public List<BasketDevice> findAll() {
        return basketDeviceRepository.findAll();
    }

    public List<BasketDevice> findByDevice(Device device) {
        return basketDeviceRepository.findByDeviceBasket(device);
    }

    public Boolean saveBasketDevice(Long userId, Long deviceId) {
        Basket basket = basketRepository.findByUserId(userId);
        Device device1 = deviceService.findById(deviceId);
        BasketDevice basketDevice = basketDeviceRepository.findByBasketAndDeviceBasket(basket,device1);

        if(basketDevice != null){
            return false;
        }
        BasketDevice basketDevice1 = new BasketDevice();
        basketDevice1.setBasket(basket);
        basketDevice1.setDeviceBasket(device1);
        basketDeviceRepository.save(basketDevice1);
        return true;
    }
    public void deleteBasketDevice(Long userId,Long deviceId) {
        sendEmailService.sendMailDeviceBuy(userId,deviceId);
        basketDeviceRepository.deleteBasketDeviceByDeviceId(deviceId);
    }
    public void deleteBasketDeviceForDevice(Long deviceId) {
        basketDeviceRepository.deleteBasketDeviceByDeviceId(deviceId);
    }

}
