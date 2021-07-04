package com.test.springBoot.application.resource;

import com.test.springBoot.application.model.BasketDevice;

import com.test.springBoot.application.service.BasketDeviceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/basketDevice")
public class BasketDeviceController {
    @Autowired
    private BasketDeviceService basketDeviceService;

    @PostMapping
    public List<BasketDevice> addBasketDevice(@RequestBody Long userId, Long deviceId) {
        if(!basketDeviceService.saveBasketDevice(userId,deviceId)){
            System.out.println("This device is already exist");
        }

        return basketDeviceService.findAll();
    }

    @GetMapping
    public List<BasketDevice> getAllBasketDevice() {
        return basketDeviceService.findAll();
    }

    @PostMapping("/deleteBasketDevice")
    public List<BasketDevice> deleteBasketDevice(@RequestBody Long userId, Long deviceId) {
        basketDeviceService.deleteBasketDevice(userId,deviceId);

        return basketDeviceService.findAll();
    }
}
