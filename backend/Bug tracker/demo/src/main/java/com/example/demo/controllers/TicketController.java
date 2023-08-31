package com.example.demo.controllers;

import com.example.demo.models.Ticket;
import com.example.demo.services.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tickets")
@CrossOrigin
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public List<Ticket> getAllTickets() {
       return ticketService.getAllTickets();
    }

    @GetMapping("/viewTicket/{ticketId}")
    public Ticket getTicketById(@PathVariable int ticketId){
        return ticketService.getTicketById(ticketId);
    }
}
