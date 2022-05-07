package br.com.projectmanager.ProjectManager.adapters;

import br.com.projectmanager.ProjectManager.application.user.UserUseCase;
import br.com.projectmanager.ProjectManager.domain.user.User;
import br.com.projectmanager.ProjectManager.domain.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserUseCase userUseCase;

    public UserController(UserRepository repository) {
        this.userUseCase = new UserUseCase(repository);
    }

    @GetMapping("/users")
    List<User> findAll() {
        return userUseCase.findAll();
    }

    @GetMapping("/users/{id}")
    User findById(@PathVariable Long id) {
        return userUseCase.findById(id);
    }
}
