package com.deogicorgi.orm.domain.organization.web.controller;

import com.deogicorgi.core.model.OrganizationDto;
import com.deogicorgi.core.model.base.Organization;
import com.deogicorgi.orm.domain.organization.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Operation(summary = "test hello", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @PostMapping
    public Mono<Organization> create(@RequestBody OrganizationDto organizationDto) {
        return organizationService.saveOrganization(organizationDto);
    }

    @GetMapping("/{orgNo}")
    public Mono<Organization> read(@PathVariable Long orgNo) {
        return organizationService.readOrganization(orgNo);
    }

    @GetMapping
    public Flux<Organization> readAll() {
        return organizationService.readAllOrganizationWithTeam();
    }

}
