package com.basel.device_service.mapper;

import com.basel.device_service.dto.DeviceDto;
import com.basel.device_service.entity.Device;

public interface DeviceMapper {
    Device mapToDevice(DeviceDto dto);

    Device mapToExistingDevice(Device device, DeviceDto dto);

    DeviceDto mapToDeviceDto(Device device);
}