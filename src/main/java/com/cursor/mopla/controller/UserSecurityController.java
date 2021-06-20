package com.cursor.mopla.controller;

import com.cursor.mopla.exception.WrongCredentialException;
import com.cursor.mopla.security.JwtUtil;
import com.cursor.mopla.security.UserSecurityServiceImpl;
import com.cursor.mopla.ui.request.UserRequest;
import com.cursor.mopla.ui.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserSecurityController {

    private final UserSecurityServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public UserSecurityController(UserSecurityServiceImpl userService, AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserRequest userRequest) throws WrongCredentialException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword())
            );
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
        final var userDetails = userService.loadUserByUsername(userRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
