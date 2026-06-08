package com.basel.device_service.mapper;

import com.basel.device_service.dto.DeviceDto;
import com.basel.device_service.entity.Device;
import org.springframework.stereotype.Service;

@Service
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public Device mapToDevice(DeviceDto dto) {
        return Device.builder()
                .name(dto.getName())
                .type(dto.getType())
                .location(dto.getLocation())
                .userId(dto.getUserId())
                .build();
    }

    @Override
    public Device mapToExistingDevice(Device device, DeviceDto dto) {
        device.setName(dto.getName());
        device.setType(dto.getType());
        device.setLocation(dto.getLocation());
        device.setUserId(dto.getUserId());
        return device;
    }

    @Override
    public DeviceDto mapToDeviceDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .location(device.getLocation())
                .userId(device.getUserId())
                .build();
    }
}