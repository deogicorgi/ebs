package com.deogicorgi.api.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Controller for Administrator.
 */
@RestController
public class AdminController {

    @GetMapping("/test")
    public String test() {
        return "hello!";
    }
}
