package com.deogicorgi.core.model;

import com.deogicorgi.core.model.base.Organization;

import java.util.Set;

public class OrganizationBody extends Organization {
    private Set<TeamBody> teams;

    public Set<TeamBody> getTeams() {
        return teams;
    }

    public void setTeams(Set<TeamBody> teams) {
        this.teams = teams;
    }
}
