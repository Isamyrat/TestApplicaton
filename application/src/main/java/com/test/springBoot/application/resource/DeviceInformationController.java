package com.test.springBoot.application.resource;


import com.test.springBoot.application.model.DeviceInformation;
import com.test.springBoot.application.model.Tag;
import com.test.springBoot.application.service.DeviceInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/deviceInformation")
public class DeviceInformationController {
    @Autowired
    private DeviceInformationService deviceInformationService;


    @PostMapping
    public List<DeviceInformation> addDevice(@RequestBody String name, String description, Long deviceId) {

        if(!deviceInformationService.saveDeviceInformation(name,description,deviceId)){
            System.err.println("this device not exist");
        }

        return deviceInformationService.findAll();
    }
    @GetMapping
    public List<DeviceInformation> getAllDeviceInformation() {
        return deviceInformationService.findAll();
    }

    @PostMapping("/deleteDeviceInformation")
    public List<DeviceInformation> deleteDeviceInformation(@RequestBody Long deviceInformationId) {
        deviceInformationService.deleteDeviceInformation(deviceInformationId);

        return deviceInformationService.findAll();
    }
    @PostMapping("/editDeviceInformation")
    public DeviceInformation edit(@RequestBody Long id, String name, String description) {

        deviceInformationService.editDeviceInformation(id, name,description);


        return deviceInformationService.findById(id);
    }
    @GetMapping("/findByDescription/{description}")
    public List<DeviceInformation> findByName(@PathVariable String description) {
        return deviceInformationService.findByDescription(description);
    }

}
