package com.deogicorgi.api.domain.member.web.controller;

import com.deogicorgi.api.domain.role.web.request.RoleApiRequest;
import com.deogicorgi.api.domain.member.service.MemberApiService;
import com.deogicorgi.core.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * API Controller for Users.
 */
@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberApiService memberApiService;

    /**
     * Create user.
     */
    @PostMapping
    public Mono<ApiResponse> create(@RequestBody RoleApiRequest user) {
        return null;
    }

    /**
     * Modify user only the entered attributes.
     */
    @PatchMapping
    public Mono<ApiResponse> modify(@RequestBody RoleApiRequest user) {
        return null;
    }

    /**
     * Update user.
     * Unpopulated data is updated to empty values.
     */
    @PutMapping
    public Mono<ApiResponse> update(@RequestBody RoleApiRequest user) {
        return null;
    }

    /**
     * Read one user.
     */
    @GetMapping("/{userId}")
    public Mono<ApiResponse> read(@PathVariable Long userId) {
        return null;
    }

    /**
     * Read all users.
     */
    @GetMapping
    public Mono<ApiResponse> readAll() {
        return null;
    }

    /**
     * Delete one users.
     */
    @DeleteMapping("/{userId}")
    public Mono<ApiResponse> delete(@PathVariable Long userId) {
        return null;
    }
}
