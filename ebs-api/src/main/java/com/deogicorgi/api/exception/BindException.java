package com.deogicorgi.api.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@RequiredArgsConstructor
public class BindException extends Exception {

    private final BindingResult result;

    public void log() {
        for (ObjectError error : this.result.getAllErrors()) {
            System.out.println(error.getDefaultMessage());
        }
    }

}
