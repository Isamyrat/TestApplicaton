package com.test.springBoot.application.dao;

import com.test.springBoot.application.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByName(String name);
    @Modifying
    @Transactional
    @Query(value = "delete from Device  d where d.id = :id", nativeQuery = true)
    void deleteDeviceById(Long id);
}
