package com.deogicorgi.core.model;

import com.deogicorgi.core.model.base.Organization;

import java.util.Set;

public class DefaultOrganization extends Organization {
    private Set<DefaultTeam> teams;

    public Set<DefaultTeam> getTeams() {
        return teams;
    }

    public void setTeams(Set<DefaultTeam> teams) {
        this.teams = teams;
    }
}
