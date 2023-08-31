package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Data
@Entity
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Integer teamId;

    @NotBlank(message = "You can't add a team without name!")
    @Size(min = 5, max = 50, message = "Your team's name must be between 5 and 50 characters!")
    private String name;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY,
               cascade = CascadeType.PERSIST, targetEntity = User.class)
    private Set<User> users;
}
