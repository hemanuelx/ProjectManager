package br.com.projectmanager.ProjectManager.application.user;

import br.com.projectmanager.ProjectManager.domain.user.User;
import br.com.projectmanager.ProjectManager.domain.user.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserUseCase {
    private final UserRepository repository;

    public UserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}
