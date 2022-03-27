package com.deogicorgi.orm.domain.organization.jpa.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Table(value = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(value = "orgNo")
    private Long orgNo;

    @Transient
    private Set<Team> teams;

    @Column(value = "orgName")
    private String orgName;

    @Column(value = "orgDescription")
    private String orgDescription;

    @Column(value = "createdAt")
    private LocalDateTime createdAt;

    @Column(value = "updatedAt")
    private LocalDateTime updatedAt;
}
