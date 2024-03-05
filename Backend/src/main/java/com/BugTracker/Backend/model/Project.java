package com.BugTracker.Backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Ticket> tickets;

    @ManyToMany
    @JoinTable(
            name="project_user",
            joinColumns=@JoinColumn(name="project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserEntity> userEntities = new ArrayList<>();
}
