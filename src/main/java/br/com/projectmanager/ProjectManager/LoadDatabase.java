package br.com.projectmanager.ProjectManager;

import br.com.projectmanager.ProjectManager.user.User;
import br.com.projectmanager.ProjectManager.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("hemanuel.xafranski", "hemanuel.xafranski@misterspex.de")));
            log.info("Preloading " + repository.save(new User("hemanuelx", "hemanuelx@gmail.com")));
        };
    }

}
