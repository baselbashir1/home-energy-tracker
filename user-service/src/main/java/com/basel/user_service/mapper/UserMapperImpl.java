package com.basel.user_service.mapper;

import com.basel.user_service.dto.UserDto;
import com.basel.user_service.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserDto dto) {
        return User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .alerting(dto.isAlerting())
                .energyAlertingThreshold(dto.getEnergyAlertingThreshold())
                .build();
    }

    @Override
    public UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .address(user.getAddress())
                .alerting(user.isAlerting())
                .energyAlertingThreshold(user.getEnergyAlertingThreshold())
                .build();
    }
}
