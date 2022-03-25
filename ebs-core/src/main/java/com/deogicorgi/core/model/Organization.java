package com.deogicorgi.core.model;

import java.util.Set;

public interface Organization {
    String getName();

    Set<Team> getTeams();
}
