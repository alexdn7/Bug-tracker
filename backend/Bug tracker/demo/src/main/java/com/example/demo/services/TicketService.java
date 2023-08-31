package com.example.demo.services;

import com.example.demo.models.Ticket;
import com.example.demo.models.enums.StatusEnum;
import com.example.demo.repositories.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public boolean addTicket(Ticket ticket) {
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setStatus(StatusEnum.PENDING);
        Ticket temporaryTicket = ticketRepository.save(ticket);
        return temporaryTicket.getTicketId() > 0;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(int ticketId) {
        return ticketRepository.getById(ticketId);
    }
}
