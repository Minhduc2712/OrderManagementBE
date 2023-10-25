package com.project.Restaurant_Managementv2.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.project.Restaurant_Managementv2.dto.user.SignInDto;
import com.project.Restaurant_Managementv2.enums.Roles;
import com.project.Restaurant_Managementv2.form.UserFormForCreating;
import com.project.Restaurant_Managementv2.models.ResponseObject;
import com.project.Restaurant_Managementv2.models.Role;
import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.payload.request.LoginRequest;
import com.project.Restaurant_Managementv2.payload.response.UserInfoResponse;
import com.project.Restaurant_Managementv2.repository.RoleRepository;
import com.project.Restaurant_Managementv2.repository.UserRepository;
import com.project.Restaurant_Managementv2.security.jwt.CookieUtil;
import com.project.Restaurant_Managementv2.security.jwt.JwtUtils;
import com.project.Restaurant_Managementv2.security.services.UserDetailsImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<ResponseObject> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        String jwt = jwtUtils.generateJwtToken(authentication);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        UserInfoResponse userInfoResponse = new UserInfoResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles);

        return ResponseEntity.ok(new ResponseObject("ok","Login ok",userInfoResponse));
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseObject> registerUser(@Valid @RequestBody UserFormForCreating signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new ResponseObject("ok", "Error: Username is already taken!", ""));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new ResponseObject("ok", "Error: Email is already in use!", ""));
        }

        // Create new user's account
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getEmail());

        // Set the default role to "user"
        Role adminRole = roleRepository.findByName(Roles.admin)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        user.setRoles(roles);

        userRepository.save(user);

        return ResponseEntity.ok(new ResponseObject("ok", "User registered successfully!", user));
    }


    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new ResponseObject("error", "Invalid or expired token", ""));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseObject> getUserById(@PathVariable Short id) {
        // Thực hiện truy vấn để lấy thông tin người dùng theo id
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        // Ở đây, bạn có thể lấy thông tin người dùng và gửi nó dưới dạng ResponseObject
        return ResponseEntity.ok(new ResponseObject("ok", "User found", user));
    }

}
