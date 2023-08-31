package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;


@Data
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int userId;

    @NotBlank(message = "You must add a name!")
    @Length(min = 3, max = 50, message = "Your name must be between 3 and 50 characters long!")
    private String name;

    @NotBlank(message = "You must add an email!")
    @Length(min = 10, max = 100, message = "Your email must be between 10 and 100 characters long!")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id", referencedColumnName = "teamId")
    private Team team;
}
