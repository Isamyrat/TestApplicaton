package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.DeviceRepository;
import com.test.springBoot.application.model.Brand;
import com.test.springBoot.application.model.Device;
import com.test.springBoot.application.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private BrandService brandService;
    @Autowired
    private TagService tagService;

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

    public void editDevice(Long id,String name, String year, Integer count, Double price, Integer brandId) {
        Device device = findById(id);
        Brand brand = brandService.findById(brandId);
        device.setName(name);
        device.setBrandDevice(brand);
        device.setPrice(price);
        device.setCount(count);
        device.setYear(year);
        deviceRepository.save(device);
    }
    public void addDevice(Long id, Short tagId) {
        Device device = findById(id);
        Tag tag = tagService.findById(tagId);

        device.setTagDevice(Collections.singleton(tag));
        deviceRepository.save(device);
    }

    public void deleteDevice(Long deviceId,Short tagId) {
        Device device = findById(deviceId);
        Set<Device> tagDevice = new HashSet<>();
        Set<Tag> devices = device.getTagDevice();
        for (Tag tag: devices) {
            tagDevice.add(tag.getDeviceTag());
        }
        tagService.deleteDeviceTag(tagId,deviceId);



        devices.removeIf(s -> s.getId().equals(tagId));
        deviceRepository.deleteDeviceById(deviceId);
    }
}
