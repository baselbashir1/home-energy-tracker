package com.basel.user_service.mapper;

import com.basel.user_service.dto.UserDto;
import com.basel.user_service.entity.User;

public interface UserMapper {
    User mapToUser(UserDto dto);

    UserDto mapToUserDto(User user);

    User mapToExistingUser(User user, UserDto dto);
}