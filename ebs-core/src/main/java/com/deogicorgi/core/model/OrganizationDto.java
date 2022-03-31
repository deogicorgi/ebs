package com.deogicorgi.core.model;

import com.deogicorgi.core.model.base.Organization;

import java.util.Set;

public class OrganizationDto extends Organization {
    private Set<TeamDto> teams;

    public Set<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamDto> teams) {
        this.teams = teams;
    }
}
