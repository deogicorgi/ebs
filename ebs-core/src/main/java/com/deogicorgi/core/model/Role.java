package com.deogicorgi.core.model;

import java.util.Set;

public interface Role {
    Set<Authority> getAuthorities();
}
