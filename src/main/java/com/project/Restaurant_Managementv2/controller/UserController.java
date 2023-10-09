package com.project.Restaurant_Managementv2.controller;

import com.project.Restaurant_Managementv2.dto.ResponseDto;
import com.project.Restaurant_Managementv2.dto.user.SignInDto;
import com.project.Restaurant_Managementv2.dto.user.SignInResponseDto;
import com.project.Restaurant_Managementv2.exceptions.CustomException;
import com.project.Restaurant_Managementv2.form.UserFormForCreating;
import com.project.Restaurant_Managementv2.service.AuthenticationService;
import com.project.Restaurant_Managementv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody UserFormForCreating userNewForm){
        ResponseDto customerNew = userService.signUp(userNewForm);

//        CustomerDto customerNewDto = new CustomerDto();
//        customerNewDto.setId(customerNew.getData());
//        customerNewDto.setFirstName(customerNew.getFirstName());
//        customerNewDto.setLastName(customerNew.getLastName());
//        customerNewDto.setUsername(customerNew.getUsername());
//        customerNewDto.setPassword(customerNew.getPassword());
//        customerNewDto.setEmail(customerNew.getEmail());

        return customerNew;
    }

    @PostMapping("/signin")
    public SignInResponseDto Signin(@RequestBody SignInDto signInDto) throws CustomException{
        SignInResponseDto user = userService.signIn(signInDto);
        return user;
    }


//    @GetMapping("/{username}")
//    public ResponseEntity<ResponseObject> getCustomerByUsername(@PathVariable String username){
//        Customer customer = customerService.getCustomerByName(username);
//
//        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Found Customer",customer));
//    }
}
