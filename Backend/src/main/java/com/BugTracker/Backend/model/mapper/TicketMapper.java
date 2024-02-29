package com.BugTracker.Backend.model.mapper;

import com.BugTracker.Backend.model.Ticket;
import com.BugTracker.Backend.model.dto.TicketDto;

public class TicketMapper {

    public static TicketDto mapToDto(Ticket ticket) {
        return new TicketDto(
            ticket.getTicketId(),
            ticket.getTitle(),
            ticket.getDescription(),
            ticket.getPriority(),
            ticket.getProject().getProjectId(),
            ticket.getAssignedTo().getUserId(),
            ticket.getStatus()
        );
    }

    public static Ticket mapToEntity(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(ticketDto.getTicketId());
        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setPriority(ticketDto.getPriority());
        ticket.setStatus(ticket.getStatus());
        return ticket;
    }
}
