package com.BugTracker.Backend.controller;

import com.BugTracker.Backend.config.AuthenticationResponse;
import com.BugTracker.Backend.model.dto.LoginDto;
import com.BugTracker.Backend.model.dto.UserDto;
import com.BugTracker.Backend.service.AuthService.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(authenticationService.register(userDto));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDto loginDto) {
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }
}
