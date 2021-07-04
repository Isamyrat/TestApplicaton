package com.test.springBoot.application.service;

import com.test.springBoot.application.dao.DeviceInformationRepository;
import com.test.springBoot.application.model.Device;
import com.test.springBoot.application.model.DeviceInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceInformationService {

    @Autowired
    private DeviceInformationRepository deviceInformationRepository;

    @Autowired
    private DeviceService deviceService;

    public DeviceInformation findById(Long deviceInformationId) {
        Optional<DeviceInformation> deviceInformation = deviceInformationRepository.findById(deviceInformationId);
        return deviceInformation.orElse(new DeviceInformation());
    }

    public List<DeviceInformation> findAll() {
        return deviceInformationRepository.findAll();
    }

    public Boolean saveDeviceInformation(String name, String description, Long deviceId) {
        Device device1 = deviceService.findById(deviceId);
        if(device1 == null){
            return false;
        }
        DeviceInformation deviceInformation = new DeviceInformation();
        deviceInformation.setName(name);
        deviceInformation.setDescription(description);
        deviceInformation.setDeviceInformation(device1);
        deviceInformationRepository.save(deviceInformation);
        return true;
    }
    public void deleteDeviceInformation(Long deviceInformationId) {
        deviceInformationRepository.deleteDeviceInformationById(deviceInformationId);
    }
    public void deleteDeviceInformationByDeviceId(Long deviceId) {
        deviceInformationRepository.deleteDeviceInformationByDeviceId(deviceId);
    }
    public void editDeviceInformation(Long id,String name, String description) {
        DeviceInformation deviceInformation = findById(id);

        deviceInformation.setName(name);
        deviceInformation.setDescription(description);

        deviceInformationRepository.save(deviceInformation);
    }
    public List<DeviceInformation> findByDescription( String description) {
        return deviceInformationRepository.findByDescription(description);
    }

}
