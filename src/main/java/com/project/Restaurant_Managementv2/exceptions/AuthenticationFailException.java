package com.project.Restaurant_Managementv2.exceptions;

public class AuthenticationFailException extends IllegalArgumentException{
    public AuthenticationFailException(String msg){
        super (msg);
    }
}
