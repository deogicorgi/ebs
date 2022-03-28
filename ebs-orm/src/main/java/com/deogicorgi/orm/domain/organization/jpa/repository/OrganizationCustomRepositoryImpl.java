package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class OrganizationCustomRepositoryImpl implements OrganizationCustomRepository {

    private final R2dbcEntityOperations r2dbcEntityOperations;

    public Flux<OrganizationEntity> findAllByCustom() {

//        return r2dbcEntityOperations.select(query(where("orgNo").in("1", "2", "3")), OrganizationEntity.class);
        return r2dbcEntityOperations.select(OrganizationEntity.class).all();
    }
}
