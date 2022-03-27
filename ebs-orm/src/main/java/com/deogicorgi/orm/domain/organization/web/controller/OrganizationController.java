package com.deogicorgi.orm.domain.organization.web.controller;

import com.deogicorgi.core.model.DefaultOrganization;
import com.deogicorgi.orm.domain.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public Mono<DefaultOrganization> create(
            @Valid @RequestBody DefaultOrganization organizationBody,
            BindingResult result)
            throws BindException {

        if (result.hasErrors()) {
            throw new BindException(result);
        }

        return organizationService.saveOrganization(organizationBody);
    }

    @GetMapping("/{orgNo}")
    public Mono<DefaultOrganization> read(@PathVariable Long orgNo) {
        return organizationService.find(orgNo);
    }
}
