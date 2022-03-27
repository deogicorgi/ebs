package com.deogicorgi.orm.domain.organization.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Table(value = "Team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(value = "teamNo")
    private Long teamNo;

    @Column(value = "orgNo")
    private Long orgNo;

    @Column(value = "parentTeamNo")
    private Long parentTeamNo;

    @Column(value = "teamName")
    private String teamName;

    @Column(value = "teamDescription")
    private String teamDescription;

    @Column(value = "createdAt")
    private LocalDateTime createdAt;

    @Column(value = "updatedAt")
    private LocalDateTime updatedAt;
}
