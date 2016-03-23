package com.demo;

import com.demo.entities.User;
import com.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@SpringBootApplication
@EnableJpaRepositories
public class SpringBootSpringDataDemoApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSpringDataDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Date d = new Date();
        User user = new User(1L, "a@b.com", d);
        userRepository.save(user);

        System.out.println("\nAfter save finder :: ");
        System.out.println(userRepository.findOne(1L));

        System.out.println("\nAfter save null date finder :: ");
        System.out.println(userRepository.findByIdWithNullableDeletedCheck(1L,null));

        System.out.println("\nAfter save date finder :: ");
        System.out.println(userRepository.findByIdWithNullableDeletedCheck(1L,d));
    }
}
