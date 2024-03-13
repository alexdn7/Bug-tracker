package com.BugTracker.Backend.model.dto;

import com.BugTracker.Backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long userId;
    private LocalDateTime registeredOn;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;
}
