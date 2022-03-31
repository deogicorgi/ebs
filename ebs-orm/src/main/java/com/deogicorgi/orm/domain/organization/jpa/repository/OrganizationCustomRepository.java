package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrganizationCustomRepository {
    Flux<OrganizationEntity> findAll();
    Mono<OrganizationEntity> insert(OrganizationEntity entity);
}
