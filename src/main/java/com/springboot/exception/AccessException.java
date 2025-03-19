package com.springboot.exception;

import org.springframework.stereotype.Controller;

@Controller
public class AccessException extends RuntimeException{
    public AccessException(){

    }
    public AccessException(String message){
        super(message);
    }
}
