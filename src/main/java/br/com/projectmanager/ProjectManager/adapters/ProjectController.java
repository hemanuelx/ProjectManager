package br.com.projectmanager.ProjectManager.adapters;

import br.com.projectmanager.ProjectManager.domain.project.Project;
import br.com.projectmanager.ProjectManager.domain.project.ProjectRepository;
import br.com.projectmanager.ProjectManager.application.project.ProjectUseCase;
import br.com.projectmanager.ProjectManager.domain.user.User;
import br.com.projectmanager.ProjectManager.domain.user.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.internal.IteratorImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProjectController {
    private final ProjectUseCase projectUseCase;

    public ProjectController(ProjectRepository repository, UserRepository userRepository) {
        this.projectUseCase = new ProjectUseCase(repository, userRepository);
    }

    @GetMapping("/projects")
    List<Project> findAll() {
        return this.projectUseCase.findAll();
    }

    @GetMapping("/projects/{id}")
    Project findById(@PathVariable Long id) {
        return this.projectUseCase.findById(id);
    }

    @PostMapping(path = "/projects/",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> createProject(@RequestBody JsonNode jsonNode) {
        return new ResponseEntity<>(projectUseCase.createProject(
                jsonNode.get("ownerUsersId").elements(),
                jsonNode.get("name").asText()
        ), HttpStatus.CREATED);
    }
}
