package com.BugTracker.Backend.model.dto;

import com.BugTracker.Backend.enums.Priority;
import com.BugTracker.Backend.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long ticketId;
    private String title;
    private String description;
    private Priority priority;
    private Long projectId;
    private Long assignedTo;
    private Status status;
}
