package com.example8.gp28.contact;


import com.example8.gp28.user.User;
import com.example8.gp28.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ContactConfig {

    @Bean
    CommandLineRunner commandLineRunnerContact(ContactRepository repository){
        return args -> {
            Contact sagar = new Contact(
                    "Sagar Gandharba",
                    "sagargandharba@gmail.com",
                    "123123123",
                    "i Love you"

            );





        };
    }
}
