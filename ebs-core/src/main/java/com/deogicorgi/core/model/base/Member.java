package com.deogicorgi.core.model.base;

import com.deogicorgi.core.values.StatusValue;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Member {

    protected Long memberNo;
    protected Long teamNo;
    protected Long roleNo;
    protected String memberName;
    protected String memberEmail;
    protected StatusValue memberStatus = StatusValue.EXPIRED;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public Long getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(Long memberNo) {
        this.memberNo = memberNo;
    }

    public Long getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(Long teamNo) {
        this.teamNo = teamNo;
    }

    public Long getRoleNo() {
        return roleNo;
    }

    public void setRoleNo(Long roleNo) {
        this.roleNo = roleNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public StatusValue getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(StatusValue memberStatus) {
        this.memberStatus = memberStatus;
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
        if (!(o instanceof Member)) return false;
        Member that = (Member) o;
        return memberNo.equals(that.memberNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberNo);
    }
}
