package com.BugTracker.Backend.model.mapper;

import com.BugTracker.Backend.model.User;
import com.BugTracker.Backend.model.dto.UserDto;

public class UserMapper {

    public static UserDto mapToDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getRegisteredOn(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getEmail(),
                user.getPasswordHash()
        );
    }

    public static User mapToEntity(UserDto userDto) {
        User user = new User();
        user.setUserId(userDto.getUserId());
        user.setRegisteredOn(userDto.getRegisteredOn());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setRole(userDto.getRole());
        user.setEmail(userDto.getEmail());
        user.setPasswordHash(userDto.getPasswordHash());

        return user;
    }
}
