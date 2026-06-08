package com.basel.device_service.service;

import com.basel.device_service.dto.DeviceDto;
import com.basel.device_service.entity.Device;
import com.basel.device_service.exception.DeviceNotFoundException;
import com.basel.device_service.mapper.DeviceMapper;
import com.basel.device_service.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceMapper deviceMapper;
    private final DeviceRepository deviceRepository;

    @Override
    public DeviceDto getDeviceById(Long deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException("Device not found with id " + deviceId));
        return deviceMapper.mapToDeviceDto(device);
    }

    @Override
    public DeviceDto createDevice(DeviceDto dto) {
        Device device = deviceRepository.save(deviceMapper.mapToDevice(dto));
        return deviceMapper.mapToDeviceDto(device);
    }

    @Override
    public DeviceDto updateDevice(Long deviceId, DeviceDto dto) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new DeviceNotFoundException("Device not found with id " + deviceId));

        return deviceMapper.mapToDeviceDto(deviceRepository.save(deviceMapper.mapToExistingDevice(device, dto)));
    }

    @Override
    public void deleteDevice(Long deviceId) {
        if (!deviceRepository.existsById(deviceId)) {
            throw new DeviceNotFoundException("Device not found with id " + deviceId);
        }
        deviceRepository.deleteById(deviceId);
    }

    @Override
    public List<DeviceDto> getAllDevicesByUserId(Long userId) {
        List<Device> devices = deviceRepository.findAllByUserId(userId);
        return devices.stream()
                .map(deviceMapper::mapToDeviceDto)
                .toList();
    }
}