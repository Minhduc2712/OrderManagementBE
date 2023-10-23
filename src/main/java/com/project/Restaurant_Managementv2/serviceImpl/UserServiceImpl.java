package com.project.Restaurant_Managementv2.serviceImpl;

import com.project.Restaurant_Managementv2.dto.ResponseDto;
import com.project.Restaurant_Managementv2.dto.user.SignInDto;
import com.project.Restaurant_Managementv2.dto.user.SignInResponseDto;
import com.project.Restaurant_Managementv2.enums.Roles;
import com.project.Restaurant_Managementv2.exceptions.AuthenticationFailException;
import com.project.Restaurant_Managementv2.exceptions.CustomException;
import com.project.Restaurant_Managementv2.form.UserFormForCreating;
import com.project.Restaurant_Managementv2.models.AuthenticationToken;
import com.project.Restaurant_Managementv2.models.Role;
import com.project.Restaurant_Managementv2.models.User;
import com.project.Restaurant_Managementv2.repository.UserRepository;
import com.project.Restaurant_Managementv2.service.AuthenticationService;
import com.project.Restaurant_Managementv2.service.UserService;
import com.project.Restaurant_Managementv2.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    Logger logger = LoggerFactory.getLogger(UserService.class);

//    String hashPassword(String password) throws NoSuchAlgorithmException{
//        MessageDigest md = MessageDigest.getInstance("SHA512");
//        byte[] hashedBytes=md.digest(password.getBytes());
//        String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
//        return hashedPassword;
//    }

    @Override
    public User getUserById(short id) {
        return userRepository.getById(id);
    }
}
