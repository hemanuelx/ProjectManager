package br.com.projectmanager.ProjectManager.application.project;

import br.com.projectmanager.ProjectManager.domain.project.Project;
import br.com.projectmanager.ProjectManager.domain.project.ProjectRepository;
import br.com.projectmanager.ProjectManager.domain.user.User;
import br.com.projectmanager.ProjectManager.domain.user.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProjectUseCase {
    private final ProjectRepository repository;
    private final UserRepository userRepository;

    public ProjectUseCase(ProjectRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    public Project save(String name) {
        return repository.save(new Project(name));
    }

    public Project createProject(Iterator<JsonNode> ownerUsersId, String name) {
        List<Long> ownerUsers = new ArrayList<>();
        ownerUsersId.forEachRemaining(node ->
            ownerUsers.add(node.longValue())
        );
        List<User> ownerUserList = userRepository.findAllById(ownerUsers);
        return repository.save(new Project(name, ownerUserList));
    }


}
