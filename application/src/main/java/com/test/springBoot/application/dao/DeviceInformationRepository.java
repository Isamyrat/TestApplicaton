package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.DeviceInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
public interface DeviceInformationRepository extends JpaRepository<DeviceInformation, Long> {

    List<DeviceInformation> findByDescription(String description);


    @Modifying
    @Transactional
    @Query(value = "delete from DEVICE_INFORMATION where ID =  :id", nativeQuery = true)
    void deleteDeviceInformationById(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from DEVICE_INFORMATION where DEVICE_ID = :id", nativeQuery = true)
    void deleteDeviceInformationByDeviceId(Long id);
}
