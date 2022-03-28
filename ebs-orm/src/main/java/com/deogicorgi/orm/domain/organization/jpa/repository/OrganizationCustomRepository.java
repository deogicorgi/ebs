package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import reactor.core.publisher.Flux;

public interface OrganizationCustomRepository {
    Flux<OrganizationEntity> findAllByCustom();
}
