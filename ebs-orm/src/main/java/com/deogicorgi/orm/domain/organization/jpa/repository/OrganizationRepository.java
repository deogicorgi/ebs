package com.deogicorgi.orm.domain.organization.jpa.repository;

import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface OrganizationRepository extends R2dbcRepository<OrganizationEntity, Long>, OrganizationCustomRepository {
}
