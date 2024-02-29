package com.BugTracker.Backend.repository;

import com.BugTracker.Backend.enums.Priority;
import com.BugTracker.Backend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findTicketsByPriority(Priority priority);

    @Query("SELECT t from Ticket t join Project p on t.ticketId = p.projectId where p.projectId = ?1")
    List<Ticket> findTicketsByProjectId(Long projectId);
}
