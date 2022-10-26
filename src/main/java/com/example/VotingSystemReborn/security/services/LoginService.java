package com.example.VotingSystemReborn.security.services;


import com.example.VotingSystemReborn.payload.request.LoginRequest;
import com.example.VotingSystemReborn.payload.response.JwtResponse;
import com.example.VotingSystemReborn.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final JwtUtils jwtUtils;

    private final AuthenticationManager authenticationManager;

    public JwtResponse loginUser(LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return new JwtResponse(jwt);

    }

}
