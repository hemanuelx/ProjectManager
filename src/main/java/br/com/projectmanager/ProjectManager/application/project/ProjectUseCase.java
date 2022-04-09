package br.com.projectmanager.ProjectManager.application.project;

import br.com.projectmanager.ProjectManager.domain.project.Project;
import br.com.projectmanager.ProjectManager.domain.project.ProjectRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProjectUseCase {
    private final ProjectRepository repository;

    public ProjectUseCase(ProjectRepository repository) {
        this.repository = repository;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }
}
