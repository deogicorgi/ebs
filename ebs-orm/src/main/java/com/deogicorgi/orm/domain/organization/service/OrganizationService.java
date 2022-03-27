package com.deogicorgi.orm.domain.organization.service;

import com.deogicorgi.core.model.OrganizationBody;
import com.deogicorgi.core.model.TeamBody;
import com.deogicorgi.core.model.base.Organization;
import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import com.deogicorgi.orm.domain.organization.jpa.repository.OrganizationRepository;
import com.deogicorgi.orm.domain.organization.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final TeamRepository teamRepository;

    public Mono<Organization> saveOrganization(Organization organization) {

        OrganizationEntity entity = new OrganizationEntity();

        BeanUtils.copyProperties(organization, entity);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        return organizationRepository.save(entity).map(organizationEntity -> {
            OrganizationBody organizationBody = new OrganizationBody();
            BeanUtils.copyProperties(organizationEntity, organizationBody);
            return organizationBody;
        });
    }

    public Mono<Organization> readOrganization(Long orgNo) {

        return organizationRepository.findById(orgNo)
                .zipWith(teamRepository.findAllByOrgNo(orgNo).collectList())
                .map(tuple -> {
                    OrganizationBody organizaion = new OrganizationBody();
                    BeanUtils.copyProperties(tuple.getT1(), organizaion);

                    organizaion.setTeams(tuple.getT2().stream().map(teamEntity -> {
                        TeamBody team = new TeamBody();
                        BeanUtils.copyProperties(teamEntity, team);
                        return team;
                    }).collect(Collectors.toSet()));

                    return organizaion;
                });
    }
}
