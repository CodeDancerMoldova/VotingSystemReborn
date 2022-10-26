package com.example.VotingSystemReborn.controllers;



import com.example.VotingSystemReborn.payload.request.LoginRequest;
import com.example.VotingSystemReborn.payload.request.SignupRequest;
import com.example.VotingSystemReborn.payload.response.JwtResponse;
import com.example.VotingSystemReborn.payload.response.MessageResponse;
import com.example.VotingSystemReborn.security.services.LoginService;
import com.example.VotingSystemReborn.security.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;

    private final RegistrationService registrationService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = loginService.loginUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        registrationService.registerUser(signUpRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
