package com.BugTracker.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(updatable = false)
    private Long createdBy;

    @Column(updatable = false)
    private LocalDateTime createdOn;

    @Column
    private Long modifiedBy;

    @Column
    private LocalDateTime modifiedOn;
}
