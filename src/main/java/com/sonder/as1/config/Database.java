package com.sonder.as1.config;

import com.sonder.as1.entity.ERole;
import com.sonder.as1.entity.User;
import com.sonder.as1.repositories.UserRepository;
import com.sonder.as1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    @Autowired
    UserService userService;
    @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user = new User();
                user.setEmail("admin@email.com");
                user.setPassword("admin1234");
                user.setFullName("Tran Van Nam");
                user.setRole(ERole.ROLE_ADMIN);
                User user2 = new User();
                user2.setEmail("user@email.com");
                user2.setPassword("user1234");
                user2.setFullName("Tran Van Nu");
                user2.setRole(ERole.ROLE_USER);
                userService.createEntity(user);
                userService.createEntity(user2);
            }
        };
    }
}
