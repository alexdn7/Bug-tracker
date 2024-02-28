package com.BugTracker.Backend.service.ProjectService;

import com.BugTracker.Backend.model.dto.ProjectDto;

import java.util.List;

public interface IProjectService {

    ProjectDto addProject(ProjectDto projectDto);

    ProjectDto getProjectById(Long projectId);

    List<ProjectDto> getAllProjects();

    ProjectDto updateProject(Long projectId, ProjectDto projectDto);

    void deleteProject(Long projectId);
}
