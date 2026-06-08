package com.basel.device_service.service;

import com.basel.device_service.dto.DeviceDto;

import java.util.List;

public interface DeviceService {
    DeviceDto getDeviceById(Long deviceId);

    DeviceDto createDevice(DeviceDto dto);

    DeviceDto updateDevice(Long deviceId, DeviceDto dto);

    void deleteDevice(Long deviceId);

    List<DeviceDto> getAllDevicesByUserId(Long userId);
}