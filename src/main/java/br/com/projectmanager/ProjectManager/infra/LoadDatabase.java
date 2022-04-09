package br.com.projectmanager.ProjectManager.infra;

import br.com.projectmanager.ProjectManager.domain.project.Project;
import br.com.projectmanager.ProjectManager.domain.project.ProjectRepository;
import br.com.projectmanager.ProjectManager.domain.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository, ProjectRepository projectRepository) {
        return args -> {
            log.info("Preloading " + repository.save(new br.com.projectmanager.ProjectManager.domain.user.User("hemanuel.xafranski", "hemanuel.xafranski@misterspex.de")));
            log.info("Preloading " + repository.save(new br.com.projectmanager.ProjectManager.domain.user.User("hemanuelx", "hemanuelx@gmail.com")));
            log.info("Preloading " + projectRepository.save(new Project("Project X")));
            log.info("Preloading " + projectRepository.save(new Project("Project 1")));
        };
    }

}
