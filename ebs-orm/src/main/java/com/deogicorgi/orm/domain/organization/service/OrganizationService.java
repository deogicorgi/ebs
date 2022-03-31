package com.deogicorgi.orm.domain.organization.service;

import com.deogicorgi.core.model.OrganizationDto;
import com.deogicorgi.core.model.TeamDto;
import com.deogicorgi.core.model.base.Organization;
import com.deogicorgi.orm.domain.organization.jpa.entity.OrganizationEntity;
import com.deogicorgi.orm.domain.organization.jpa.entity.TeamEntity;
import com.deogicorgi.orm.domain.organization.jpa.repository.OrganizationRepository;
import com.deogicorgi.orm.domain.organization.jpa.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
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

        return organizationRepository.save(entity)
                .map(organizationEntity -> {
                    OrganizationDto organizationDto = new OrganizationDto();
                    BeanUtils.copyProperties(organizationEntity, organizationDto);
                    return organizationDto;
                });
    }

    public Mono<Organization> readOrganization(Long orgNo) {

        return organizationRepository.findById(orgNo)
                .zipWith(teamRepository.findAllByOrgNo(orgNo).collectList())
                .map(tuple -> {
                    OrganizationDto organization = new OrganizationDto();
                    BeanUtils.copyProperties(tuple.getT1(), organization);

                    organization.setTeams(tuple.getT2().stream().map(teamEntity -> {
                        TeamDto team = new TeamDto();
                        BeanUtils.copyProperties(teamEntity, team);
                        return team;
                    }).collect(Collectors.toSet()));

                    return organization;
                });
    }

    public Flux<Organization> readAll() {
        return organizationRepository.findAll().map(organizationEntity -> {
            OrganizationDto organizationDto = new OrganizationDto();
            BeanUtils.copyProperties(organizationEntity, organizationDto);
            return organizationDto;
        });
    }

    public Flux<Organization> readAllWithTeams() {
        return organizationRepository.findAll()
                .collectList()
                .zipWith(teamRepository.findAll().collectList())
                .map(tuple -> {
                    List<OrganizationEntity> organizationEntities = tuple.getT1();
                    List<TeamEntity> teamEntities = tuple.getT2();

                    return organizationEntities.stream()
                            .map(organizationEntity -> {
                                Set<TeamDto> teams = teamEntities.stream()
                                        .filter(teamEntity -> teamEntity.getOrgNo().equals(organizationEntity.getOrgNo()))
                                        .map(teamEntity -> {
                                            TeamDto team = new TeamDto();
                                            BeanUtils.copyProperties(teamEntity, team);
                                            return team;
                                        }).collect(Collectors.toSet());

                                OrganizationDto organization = new OrganizationDto();
                                BeanUtils.copyProperties(organizationEntity, organization);
                                organization.setTeams(teams);

                                return organization;
                            }).collect(Collectors.toList());
                }).flatMapIterable(list -> list);
    }
}
