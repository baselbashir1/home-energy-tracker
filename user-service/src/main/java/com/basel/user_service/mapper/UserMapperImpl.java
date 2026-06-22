package com.basel.user_service.mapper;

import com.basel.user_service.dto.UserDto;
import com.basel.user_service.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    @Override
    public User mapToUser(UserDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setEmail(dto.email());
        user.setAddress(dto.address());
        user.setAlerting(dto.alerting());
        user.setEnergyAlertingThreshold(dto.energyAlertingThreshold());
        return user;
    }

    @Override
    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getAddress(),
                user.isAlerting(),
                user.getEnergyAlertingThreshold()
        );
    }

    @Override
    public User mapToExistingUser(User user, UserDto dto) {
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setEmail(dto.email());
        user.setAddress(dto.address());
        user.setAlerting(dto.alerting());
        user.setEnergyAlertingThreshold(dto.energyAlertingThreshold());
        return user;
    }
}