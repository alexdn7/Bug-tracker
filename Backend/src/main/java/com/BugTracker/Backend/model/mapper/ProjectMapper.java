package com.BugTracker.Backend.model.mapper;

import com.BugTracker.Backend.model.Project;
import com.BugTracker.Backend.model.dto.ProjectDto;

public class ProjectMapper {

    public static ProjectDto mapToDto(Project project) {
        return new ProjectDto(
                project.getProjectId(),
                project.getTitle(),
                project.getDescription()
        );
    }

    public static Project mapToEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setProjectId(projectDto.getProjectId());
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        return project;
    }
}
