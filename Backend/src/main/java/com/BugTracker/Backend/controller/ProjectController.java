package com.BugTracker.Backend.controller;

import com.BugTracker.Backend.model.dto.ProjectDto;
import com.BugTracker.Backend.service.ProjectService.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    public final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto) {
        ProjectDto savedProjectDto = projectService.addProject(projectDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProjectDto);
    }

    @GetMapping("view/{projectId}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long projectId) {
        return ResponseEntity.ok(projectService.getProjectById(projectId));
    }


    @GetMapping("view")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PutMapping("/update/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long projectId,
                                                    @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.updateProject(projectId, projectDto));
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok("Project successfully deleted");
    }
}
