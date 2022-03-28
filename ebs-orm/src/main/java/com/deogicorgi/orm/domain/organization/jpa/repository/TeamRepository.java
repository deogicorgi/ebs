package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.TeamEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.Set;

public interface TeamRepository extends R2dbcRepository<TeamEntity, Long>, TeamCustomRepository {
    Flux<TeamEntity> findAllByOrgNo(Long orgNo);

    Flux<TeamEntity> findAllByOrgNoIn(Set<Long> orgNoSet);
}
