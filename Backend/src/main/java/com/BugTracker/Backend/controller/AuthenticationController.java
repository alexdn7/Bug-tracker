package com.BugTracker.Backend.controller;

import com.BugTracker.Backend.config.AuthenticationResponse;
import com.BugTracker.Backend.model.dto.LoginDto;
import com.BugTracker.Backend.model.dto.UserDto;
import com.BugTracker.Backend.service.AuthService.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserDto userDto
            ) {
        return ResponseEntity.ok(authenticationService.register(userDto));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginDto loginDto
            ) {
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }
}
