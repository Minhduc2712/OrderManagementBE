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


    @Override
    public User getUserByEmailOrUsername(String email, String username) {
        return userRepository.findByEmailOrUsername(email,username);
    }

    @Override
    public ResponseDto signUp(UserFormForCreating customerNewForm) throws CustomException {
        if (Helper.notNull(userRepository.findByEmailOrUsername(customerNewForm.getEmail(), customerNewForm.getUsername()))) {
            return new ResponseDto("failed","User already exits","");
        }
        String encryptedPassword = customerNewForm.getPassword();
        try {
            encryptedPassword = hashPassword(customerNewForm.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }

        User customer = new User(customerNewForm.getFirstName(),customerNewForm.getLastName(), customerNewForm.getUsername(),encryptedPassword, Roles.user, customerNewForm.getEmail());

        User createdUser;
        try{
            createdUser = userRepository.save(customer);
            final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
            authenticationService.saveComfirmationToken(authenticationToken);
            return new ResponseDto("Success","Register Successfully",createdUser);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }

    }

    @Override
    public SignInResponseDto signIn(SignInDto signInDto) {
        User user =userRepository.findByEmailOrUsername(signInDto.getEmail(),signInDto.getUsername());
        if (!Helper.notNull(user)){
            throw new AuthenticationFailException("User not present");
        }
        try{
            if(!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                throw new AuthenticationFailException("Wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new CustomException(e.getMessage());
        }

        AuthenticationToken token = authenticationService.getToken(user);

        if(!Helper.notNull(token)) {
            throw new CustomException("Token not present");
        }

        return new SignInResponseDto ("success", token.getToken(),user);
    }


    String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA512");
        byte[] hashedBytes=md.digest(password.getBytes());
        String hashedPassword = Base64.getEncoder().encodeToString(hashedBytes);
        return hashedPassword;
    }



}
