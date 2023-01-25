package ru.gb.jSilver.spring.market.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.spring.market.api.AppError;
import ru.gb.jSilver.spring.market.api.AuthResponse;
import ru.gb.jSilver.spring.market.core.dtos.StringResponse;
import ru.gb.jSilver.spring.market.core.services.UserService;
import ru.gb.jSilver.spring.market.core.utils.JwtTokenUtil;
import ru.gb.jSilver.spring.market.api.AuthRequest;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(new AppError(HttpStatus.UNAUTHORIZED.value(),"Incorrect username or password"), HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @GetMapping("/check_roles/{username}")
    public StringResponse checkRoles(@PathVariable String username) {
        UserDetails userDetails = userService.loadUserByUsername(username);
        return new StringResponse(userDetails.getAuthorities().toString());
    }
}
