package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class OrganizationCustomRepositoryImpl implements OrganizationCustomRepository {

    private final R2dbcEntityOperations entityTemplate;

    public Flux<OrganizationEntity> findAll() {
        return entityTemplate.select(OrganizationEntity.class).all();
    }

}
