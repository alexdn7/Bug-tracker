package com.BugTracker.Backend.service.ProjectService;

import com.BugTracker.Backend.model.Project;
import com.BugTracker.Backend.model.dto.ProjectDto;
import com.BugTracker.Backend.model.mapper.ProjectMapper;
import com.BugTracker.Backend.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService implements IProjectService {

    public final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectDto addProject(ProjectDto projectDto) {
        Project project = ProjectMapper.mapToEntity(projectDto);
        project.setCreatedOn(LocalDateTime.now());
        return ProjectMapper.mapToDto(projectRepository.save(project));
    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Entity with given ID not found"));
        return ProjectMapper.mapToDto(project);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Entity with given ID not found"));
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setModifiedOn(LocalDateTime.now());
        Project updatedProject = projectRepository.save(project);
        return ProjectMapper.mapToDto(updatedProject);
    }

    @Override
    public void deleteProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Entity with given ID not found"));
        projectRepository.delete(project);
    }
}
