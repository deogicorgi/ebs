package com.deogicorgi.core.model.base;

import com.deogicorgi.core.values.StatusValue;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Role {

    protected Long roleNo;
    protected String roleName;
    protected StatusValue roleStatus = StatusValue.EXPIRED;
    protected String roleDescription;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public StatusValue getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(StatusValue roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role that = (Role) o;
        return roleNo.equals(that.roleNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleNo);
    }
}
