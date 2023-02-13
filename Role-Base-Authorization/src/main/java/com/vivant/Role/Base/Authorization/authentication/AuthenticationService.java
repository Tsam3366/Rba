package com.vivant.Role.Base.Authorization.authentication;

import com.vivant.Role.Base.Authorization.configuration.JwtService;
import com.vivant.Role.Base.Authorization.dto.RegisterRequest;
import com.vivant.Role.Base.Authorization.entity.Role;
import com.vivant.Role.Base.Authorization.entity.User;
import com.vivant.Role.Base.Authorization.repository.UserRepository;
import com.vivant.Role.Base.Authorization.service.RoleService;
import com.vivant.Role.Base.Authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.builder().firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(encoder.encode(registerRequest.getPassword()))
                .mobile(registerRequest.getMobile())
                .created(new Date(System.currentTimeMillis()))
                .updated(null)
                .status(true)
                .roles(null)
                .build();
        userService.addUser(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
    @Autowired
    private RoleService roleService;

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (authenticationRequest.getEmail(),
                                authenticationRequest.getPassword())
        );
        User user = userService.findUserByMail(authenticationRequest.getEmail());
        List<Role> roles=roleService.findRoles(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
