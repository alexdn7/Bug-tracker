package com.BugTracker.Backend.model.mapper;

import com.BugTracker.Backend.model.UserEntity;
import com.BugTracker.Backend.model.dto.UserDto;

public class UserMapper {

    public static UserDto mapToDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getUserId(),
                userEntity.getRegisteredOn(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getRole(),
                userEntity.getEmail(),
                userEntity.getPassword()
        );
    }

    public static UserEntity mapToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDto.getUserId());
        userEntity.setRegisteredOn(userDto.getRegisteredOn());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setRole(userDto.getRole());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(userDto.getPassword());

        return userEntity;
    }
}
