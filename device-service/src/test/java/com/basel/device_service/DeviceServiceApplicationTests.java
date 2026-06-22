package com.basel.device_service;

import com.basel.device_service.entity.Device;
import com.basel.device_service.model.DeviceType;
import com.basel.device_service.repository.DeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DeviceServiceApplicationTests {

    public static final int NUMBER_OF_DEVICES = 200;
    public static final int USERS = 10;

    @Autowired
    private DeviceRepository deviceRepository;

    @Test
    void contextLoads() {
    }

    @Disabled
    @Test
    void createDevices() {
        for (int i = 1; i <= NUMBER_OF_DEVICES; i++) {
            Device device = new Device();
            device.setName("Device" + i);
            device.setType(DeviceType.values()[i % DeviceType.values().length]);
            device.setLocation("Location" + ((i % 3) + 1));
            device.setUserId((long) ((i % USERS) + 1));
            deviceRepository.save(device);
        }
        log.info("Device Repository has been populated");
    }
}