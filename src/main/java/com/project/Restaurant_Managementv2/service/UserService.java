package com.project.Restaurant_Managementv2.service;

import com.project.Restaurant_Managementv2.dto.ResponseDto;
import com.project.Restaurant_Managementv2.dto.user.SignInDto;
import com.project.Restaurant_Managementv2.dto.user.SignInResponseDto;
import com.project.Restaurant_Managementv2.exceptions.CustomException;
import com.project.Restaurant_Managementv2.form.UserFormForCreating;
import com.project.Restaurant_Managementv2.models.User;

import java.util.List;

public interface UserService {
//    public User createNewAccount(UserFormForCreating userNewForm);
    public User getUserByEmailOrUsername(String email, String username );

    public ResponseDto signUp(UserFormForCreating userNewForm);

    public SignInResponseDto signIn(SignInDto signInDto);

}
