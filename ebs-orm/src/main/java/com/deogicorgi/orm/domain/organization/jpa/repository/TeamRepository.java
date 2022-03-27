package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.TeamEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface TeamRepository extends R2dbcRepository<TeamEntity, Long> {
    Flux<TeamEntity> findAllByOrgNo(Long orgNo);
}
