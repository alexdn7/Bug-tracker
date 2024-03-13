package com.BugTracker.Backend.service.TicketService;

import com.BugTracker.Backend.enums.Priority;
import com.BugTracker.Backend.enums.Status;
import com.BugTracker.Backend.model.Ticket;
import com.BugTracker.Backend.model.dto.TicketDto;
import com.BugTracker.Backend.model.mapper.TicketMapper;
import com.BugTracker.Backend.repository.ProjectRepository;
import com.BugTracker.Backend.repository.TicketRepository;
import com.BugTracker.Backend.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService implements ITicketService {

    private final TicketRepository ticketRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public TicketService(TicketRepository ticketRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }


    @Override
    public TicketDto addTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToEntity(ticketDto);
        ticket.setCreatedOn(LocalDateTime.now());
        ticket.setProject(
                projectRepository.findById(ticketDto.getProjectId())
                        .orElseThrow(() -> new EntityNotFoundException("Project not found"))
        );
        ticket.setAssignedTo(
                userRepository.findById(ticketDto.getAssignedTo())
                        .orElseThrow(() -> new EntityNotFoundException("UserEntity not found"))
        );
        ticket.setStatus(Status.CREATED);
        return TicketMapper.mapToDto(ticketRepository.save(ticket));
    }

    @Override
    public TicketDto getTicketById(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Entity with given ID not found!"));
        return TicketMapper.mapToDto(ticket);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(TicketMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketsByPriority(Priority priority) {
        return ticketRepository.findTicketsByPriority(priority).stream()
                .map(TicketMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TicketDto> getTicketsByProjectId(Long projectId) {
        projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project with given ID not found"));
        List<Ticket> ticketsByProjectId = ticketRepository.findTicketsByProjectId(projectId);
        return ticketsByProjectId.stream()
                .map(TicketMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto updateTicket(Long ticketId, TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Entity with given ID not found!"));
        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setPriority(ticketDto.getPriority());
        ticket.setProject(
                projectRepository.findById(ticketDto.getProjectId())
                        .orElseThrow(() -> new EntityNotFoundException("Project not found"))
        );
        ticket.setAssignedTo(
                userRepository.findById(ticketDto.getAssignedTo())
                        .orElseThrow(() -> new EntityNotFoundException("UserEntity not found"))
        );
        ticket.setStatus(ticketDto.getStatus());
        ticket.setModifiedOn(LocalDateTime.now());
        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketMapper.mapToDto(savedTicket);
    }

    @Override
    public void deleteTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new EntityNotFoundException("Entity with given ID not found!"));
        ticketRepository.delete(ticket);
    }
}
