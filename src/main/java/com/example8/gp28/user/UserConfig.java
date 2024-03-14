package com.example8.gp28.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
           User sagar = new User(
                    "Sagar",
                    "Gandharba",
                    "sagargandharba@gmail.com",
                    "123456"

        );

            User ifaj = new User(
                    "Ifaj",
                    "Khan",
                    "ifaj@gmail.com",
                    "123456"

            );


        };
    }
}
