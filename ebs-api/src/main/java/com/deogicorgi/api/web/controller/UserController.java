package com.deogicorgi.api.web.controller;

import com.deogicorgi.api.web.request.UserApiRequest;
import com.deogicorgi.api.web.service.UserApiService;
import com.deogicorgi.core.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * API Controller for Users.
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApiService userApiService;

    /**
     * Create user.
     */
    @PostMapping
    public ApiResponse create(@RequestBody UserApiRequest user) {
        return null;
    }

    /**
     * Modify user only the entered attributes.
     */
    @PatchMapping
    public ApiResponse modify(@RequestBody UserApiRequest user) {
        return null;
    }

    /**
     * Update user.
     * Unpopulated data is updated to empty values.
     */
    @PutMapping
    public ApiResponse update(@RequestBody UserApiRequest user) {
        return null;
    }

    /**
     * Read one user.
     */
    @GetMapping("/{userId}")
    public ApiResponse read(@PathVariable Long userId) {
        return null;
    }

    /**
     * Read all users.
     */
    @GetMapping
    public ApiResponse readAll() {
        return null;
    }

    /**
     * Delete one users.
     */
    @DeleteMapping("/{userId}")
    public ApiResponse delete(@PathVariable Long userId) {
        return null;
    }
}
