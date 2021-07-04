package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.DeviceRepository;
import com.test.springBoot.application.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceInformationService deviceInformationService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private TagService tagService;

    @Autowired
    private BasketDeviceService basketDeviceService;

    @Autowired
    private SendEmailService sendEmailService;

    public Device findById(Long deviceId) {
        Optional<Device> device = deviceRepository.findById(deviceId);
        return device.orElse(new Device());
    }
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    public void saveDevice(String name, String year, Integer count, Double price, Integer brandId) {
        Brand brand = brandService.findById(brandId);
        Device device1 = new Device();
        device1.setName(name);
        device1.setBrandDevice(brand);
        device1.setPrice(price);
        device1.setCount(count);
        device1.setYear(year);
        deviceRepository.save(device1);
    }
    public List<Device> findByName(String name) {
        return deviceRepository.findByName(name);
    }

    public Boolean editDevice(Long id,String name, String year, Integer count, Double price, Integer brandId) {
        Device device = findById(id);
        List<BasketDevice> basketDevice = basketDeviceService.findByDevice(device);

        if(basketDevice.size() != 0){
            return false;
        }

        Brand brand = brandService.findById(brandId);
        device.setName(name);
        device.setBrandDevice(brand);
        device.setPrice(price);
        device.setCount(count);
        device.setYear(year);
        deviceRepository.save(device);
        return true;
    }

    public Boolean forceUpdate(Long id,String name, String year, Integer count, Double price, Integer brandId) {
        Device device = findById(id);
        List<BasketDevice> basketDevice = basketDeviceService.findByDevice(device);

        if(basketDevice.size() == 0){
            return false;
        }

        Brand brand = brandService.findById(brandId);
        device.setName(name);
        device.setBrandDevice(brand);
        device.setPrice(price);
        device.setCount(count);
        device.setYear(year);
        deviceRepository.save(device);
        List<Basket> basket = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        for(BasketDevice basketDevice1 : basketDevice){
            basket.add(basketDevice1.getBasket());
        }
        for(Basket basket1 : basket){
            userList.add(basket1.getUserBasket());
        }

        for(User user : userList){
            sendEmailService.sendMailDeviceChange(user.getId(), device.getId());
        }
        return true;
    }
    public void addDevice(Long id, Short tagId) {
        Device device = findById(id);
        Tag tag = tagService.findById(tagId);

        device.setTagDevice(Collections.singleton(tag));
        deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId) {
        Device device = findById(deviceId);
        Set<Tag> devices = device.getTagDevice();
        devices.clear();
        device.setTagDevice(devices);
        deviceRepository.save(device);
        basketDeviceService.deleteBasketDeviceForDevice(deviceId);
        deviceInformationService.deleteDeviceInformationByDeviceId(deviceId);
        deviceRepository.deleteDeviceById(deviceId);
    }
}
