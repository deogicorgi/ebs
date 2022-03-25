package com.deogicorgi.core.model.base;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Team {

    protected Long teamNo;

    protected Long orgNo;

    protected Long parentTeamNo;

    @NotEmpty
    protected String teamName;

    protected String teamDescription;

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    public Long getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(Long teamNo) {
        this.teamNo = teamNo;
    }

    public Long getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(Long orgNo) {
        this.orgNo = orgNo;
    }

    public Long getParentTeamNo() {
        return parentTeamNo;
    }

    public void setParentTeamNo(Long parentTeamNo) {
        this.parentTeamNo = parentTeamNo;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
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
        if (!(o instanceof Team)) return false;
        Team that = (Team) o;
        return teamNo.equals(that.teamNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamNo);
    }
}
