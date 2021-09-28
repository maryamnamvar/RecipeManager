package com.recipeapplication;

import com.recipeapplication.entity.Recipe;
import com.recipeapplication.entity.User;
import com.recipeapplication.entity.enums.UserRole;
import com.recipeapplication.repository.RecipeRepository;
import com.recipeapplication.repository.UserRepository;
import com.recipeapplication.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class RecipeApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecipeRepository recipeRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecipeApplication.class, args);
    }

    /**
     * Pre-load the system with employees and items.
     */
    public @PostConstruct
    void init() {
        if (recipeRepository.count() == 0) {
            recipeRepository.save(new Recipe("Pizza", "Cook, Enjoy!", 4, LocalDateTime.now(), Arrays.asList("Cheese", "Bread", "Seasoning", "Sausage")));
        }

        if (!userRepository.findByEmail("admin").isPresent()) {
            User adminUser = new User("admin", "a", true, UserRole.ADMIN);
            adminUser.setEmail("admin");
            adminUser.setPassword("$2a$10$rGjXdgOk56ULAC55NR2hDep2aDHNDDaCPrmJHgVdTcO8E2VnKnAhS"); // = 123

            userRepository.save(adminUser);
        }
        /**
         * Due to method-level protections on {@link example.company.ItemRepository}, the security context must be loaded
         * with an authentication token containing the necessary privileges.
         */
        SecurityUtils.runAs("admin", "admin", "ROLE_ADMIN");

        SecurityContextHolder.clearContext();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
        };
    }
}
