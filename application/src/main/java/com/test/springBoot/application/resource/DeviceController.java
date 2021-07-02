package com.test.springBoot.application.resource;

import com.test.springBoot.application.model.Device;
import com.test.springBoot.application.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/rest/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public List<Device> addDevice(@RequestBody String name, String year, Integer count, Double price, Integer brandId) {
        deviceService.saveDevice(name,year,count,price,brandId);

        return deviceService.findAll();
    }

    @GetMapping
    public List<Device> getAllDevice() {
        return deviceService.findAll();
    }

    @PostMapping("/editDevice")
    public Device edit(@RequestBody Long id,String name, String year, Integer count, Double price, Integer brandId) {

        deviceService.editDevice(id, name,year,count,price,brandId);


        return deviceService.findById(id);
    }
    @PostMapping("/addTagsToDevice")
    public Device addTagsToDevice(@RequestBody Long id, Short tagId) {

        deviceService.addDevice(id, tagId);

        return deviceService.findById(id);
    }

    @PostMapping("/deleteDevice")
    public List<Device> deleteDevice(@RequestBody Long deviceId) {
        deviceService.deleteDevice(deviceId);

        return deviceService.findAll();
    }

    @GetMapping("/findByName/{name}")
    public List<Device> findByName(@PathVariable String name) {
        return deviceService.findByName(name);
    }
}
