package com.deogicorgi.core.model.base;

import com.deogicorgi.core.values.StatusValue;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Authority {

    protected Long authorityNo;

    protected Long roleNo;

    @NotEmpty
    protected String authorityName;

    protected StatusValue authorityStatus = StatusValue.EXPIRED;

    protected String authorityDescription;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public Long getAuthorityNo() {
        return authorityNo;
    }

    public void setAuthorityNo(Long authorityNo) {
        this.authorityNo = authorityNo;
    }

    public Long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public StatusValue getAuthorityStatus() {
        return authorityStatus;
    }

    public void setAuthorityStatus(StatusValue authorityStatus) {
        this.authorityStatus = authorityStatus;
    }

    public String getAuthorityDescription() {
        return authorityDescription;
    }

    public void setAuthorityDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
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
        if (!(o instanceof Authority)) return false;
        Authority that = (Authority) o;
        return authorityNo.equals(that.authorityNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorityNo);
    }
}
