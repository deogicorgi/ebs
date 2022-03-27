package com.deogicorgi.api.domain.member.web.controller;

import com.deogicorgi.api.domain.member.service.MemberApiService;
import com.deogicorgi.api.exception.BindException;
import com.deogicorgi.core.model.MemberBody;
import com.deogicorgi.core.web.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberApiService memberApiService;

    @PostMapping
    public Mono<ApiResponse> create(
            @Valid @RequestBody MemberBody member,
            BindingResult result)
            throws BindException {

        if (result.hasErrors()) {
            throw new BindException(result);
        }

        return null;
    }

    @PatchMapping
    public Mono<ApiResponse> modify(@RequestBody MemberBody member) {
        return null;
    }

    @PutMapping
    public Mono<ApiResponse> update(@RequestBody MemberBody member) {
        return null;
    }

    @GetMapping("/{memberNo}")
    public Mono<ApiResponse> read(@PathVariable Long memberNo) {
        return null;
    }

    @GetMapping
    public Mono<ApiResponse> readAll() {
        return null;
    }

    @DeleteMapping("/{memberNo}")
    public Mono<ApiResponse> delete(@PathVariable Long memberNo) {
        return null;
    }
}
