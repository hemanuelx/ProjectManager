package br.com.projectmanager.ProjectManager.adapters;

import br.com.projectmanager.ProjectManager.application.user.UserUseCase;
import br.com.projectmanager.ProjectManager.domain.user.User;
import br.com.projectmanager.ProjectManager.domain.user.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "/users/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> save(@RequestBody JsonNode jsonNode) {
        return new ResponseEntity<>(userUseCase.save(jsonNode.get("userName").asText(), jsonNode.get("email").asText()), HttpStatus.CREATED);
    }
}
