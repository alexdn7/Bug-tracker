package com.BugTracker.Backend.service.TicketService;

import com.BugTracker.Backend.enums.Priority;
import com.BugTracker.Backend.model.dto.TicketDto;

import java.util.List;

public interface ITicketService {

    TicketDto addTicket(TicketDto ticketDto);

    TicketDto getTicketById(Long ticketId);

    List<TicketDto> getAllTickets();

    List<TicketDto> getTicketsByPriority(Priority priority);

    List<TicketDto> getTicketsByProjectId(Long projectId);

    TicketDto updateTicket(Long ticketId, TicketDto ticketDto);

    void deleteTicket(Long ticketId);
}
