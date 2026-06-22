package com.basel.device_service.mapper;

import com.basel.device_service.dto.DeviceDto;
import com.basel.device_service.entity.Device;
import org.springframework.stereotype.Service;

@Service
public class DeviceMapperImpl implements DeviceMapper {

    @Override
    public Device mapToDevice(DeviceDto dto) {
        Device device = new Device();
        device.setName(dto.name());
        device.setType(dto.type());
        device.setLocation(dto.location());
        device.setUserId(dto.userId());
        return device;
    }

    @Override
    public Device mapToExistingDevice(Device device, DeviceDto dto) {
        device.setName(dto.name());
        device.setType(dto.type());
        device.setLocation(dto.location());
        device.setUserId(dto.userId());
        return device;
    }

    @Override
    public DeviceDto mapToDeviceDto(Device device) {
        return new DeviceDto(
                device.getId(),
                device.getName(),
                device.getType(),
                device.getLocation(),
                device.getUserId()
        );
    }
}