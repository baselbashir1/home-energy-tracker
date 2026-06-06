package com.basel.user_service.service;

import com.basel.user_service.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto dto);

    UserDto getUserById(Long userId);

    void updateUser(Long userId, UserDto dto);

    void deleteUser(Long userId);
}