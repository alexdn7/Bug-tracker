package com.BugTracker.Backend.controller;

import com.BugTracker.Backend.model.dto.TicketDto;
import com.BugTracker.Backend.service.TicketService.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/add")
    public ResponseEntity<TicketDto> addTicket(@RequestBody TicketDto ticketDto) {
        TicketDto savedTicket = ticketService.addTicket(ticketDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }

    @GetMapping("view/{ticketId}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable Long ticketId) {
        return ResponseEntity.ok(ticketService.getTicketById(ticketId));
    }

    @GetMapping("/view")
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PutMapping("update/{ticketId}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable Long ticketId,
                                                  @RequestBody TicketDto ticketDto) {
        return ResponseEntity.ok(ticketService.updateTicket(ticketId, ticketDto));
    }

    @DeleteMapping("delete/{ticketId}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long ticketId) {
        ticketService.deleteTicket(ticketId);
        return ResponseEntity.ok("Ticket deleted successfully");
    }
}
