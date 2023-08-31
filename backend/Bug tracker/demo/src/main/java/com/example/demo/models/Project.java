package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    public int projectId;

    @NotBlank(message = "Project name can't be blank!")
    @Size(min = 5, max = 50, message = "Your project's name must be between 5 and 50 characters!")
    public String name;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = Team.class)
    @JoinColumn(name = "teamId", referencedColumnName = "teamId", nullable = false)
    private Team team;
}
