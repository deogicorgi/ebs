package com.deogicorgi.orm.domain.organization.web.controller;

import com.deogicorgi.core.model.OrganizationBody;
import com.deogicorgi.core.model.base.Organization;
import com.deogicorgi.orm.domain.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService organizationService;

    @PostMapping
    public Mono<Organization> create(
            @Valid @RequestBody OrganizationBody organizationBody,
            BindingResult result)
            throws BindException {

        if (result.hasErrors()) {
            throw new BindException(result);
        }
        return organizationService.saveOrganization(organizationBody);
    }

    @GetMapping("/{orgNo}")
    public Mono<Organization> read(@PathVariable Long orgNo) {
        return organizationService.readOrganization(orgNo);
    }

    @GetMapping
    public Flux<Organization> readAll() {
        return organizationService.readAllWithTeams();
    }

}
