package com.deogicorgi.orm.domain.organization.service;

import com.deogicorgi.core.model.DefaultOrganization;
import com.deogicorgi.core.model.DefaultTeam;
import com.deogicorgi.orm.domain.organization.jpa.entity.Organization;
import com.deogicorgi.orm.domain.organization.jpa.repository.OrganizationRepository;
import com.deogicorgi.orm.domain.organization.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final TeamRepository teamRepository;

    public Mono<DefaultOrganization> saveOrganization(DefaultOrganization organization) {

        Organization entity = new Organization();

        BeanUtils.copyProperties(organization, entity);
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        return organizationRepository.save(entity).map(organization1 -> {
            DefaultOrganization defaultOrganization = new DefaultOrganization();
            BeanUtils.copyProperties(organization1, defaultOrganization);
            return defaultOrganization;
        });
    }

    public Mono<DefaultOrganization> find(Long orgNo) {
        return organizationRepository.findById(orgNo)
            .zipWith(teamRepository.findAllByOrgNo(orgNo).collectList())
            .map(tuple -> {

                Organization organizationEntity = tuple.getT1();
                DefaultOrganization organizaion = new DefaultOrganization();
                BeanUtils.copyProperties(organizationEntity, organizaion);

                Set<DefaultTeam> teams = tuple.getT2().stream().map(teamEntity -> {
                    DefaultTeam team = new DefaultTeam();
                    BeanUtils.copyProperties(teamEntity, team);
                    return team;
                }).collect(Collectors.toSet());

                organizaion.setTeams(teams);
                return organizaion;
            });
    }
}
