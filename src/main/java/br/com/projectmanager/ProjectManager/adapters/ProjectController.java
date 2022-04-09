package br.com.projectmanager.ProjectManager.adapters;

import br.com.projectmanager.ProjectManager.domain.project.Project;
import br.com.projectmanager.ProjectManager.domain.project.ProjectRepository;
import br.com.projectmanager.ProjectManager.application.project.ProjectUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectUseCase projectUseCase;

    public ProjectController(ProjectRepository repository) {
        this.projectUseCase = new ProjectUseCase(repository);
    }

    @GetMapping("/projects")
    List<Project> findAll() {
        return this.projectUseCase.findAll();
    }

    @GetMapping("/projects/{id}")
    Project findById(@PathVariable Long id) {
        return this.projectUseCase.findById(id);
    }
}
