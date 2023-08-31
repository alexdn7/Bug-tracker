package com.example.demo.models;

import com.example.demo.models.enums.StatusEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Ticket extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private int ticketId;

    @NotBlank(message = "You must add a title!")
    @Size(min = 3, max = 50, message = "Title must be between 3 and 50 characters long!")
    private String title;

    @NotBlank(message = "You must add a description!")
    @Size(min = 10, max = 250, message = "Description must be between 10 and 250 characters long!")
    private String description;

    @NotBlank
    private StatusEnum status;
}
