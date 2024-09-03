package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        try {
            // Check and insert user1 if it doesn't exist
            if (!userRepository.existsByEmail("smith@dsa.com")) {
                User user1 = new User();
                user1.setEmail("smith@dsa.com");
                user1.setPassword("smith");
                userRepository.save(user1);

                // Create and save the associated employee
                Employee employee1 = new Employee();
                employee1.setBorn(LocalDateTime.of(2010, 5, 10, 11, 9, 12));
                employee1.setName("Smith");
                employee1.setGender(Gender.MALE);
                employee1.setVegetarian(true);
                employee1.setUser(user1);
                employeeRepository.save(employee1);
            } else {
                System.out.println("User with email 'smith@dsa.com' already exists.");
            }

            // Check and insert user2 if it doesn't exist
            if (!userRepository.existsByEmail("Bo@example.com")) {
                User user2 = new User();
                user2.setEmail("Bo@example.com");
                user2.setPassword("password2");
                userRepository.save(user2);

                // Create and save the associated employee
                Employee employee2 = new Employee();
                employee2.setBorn(LocalDateTime.of(2011, 5, 10, 11, 9, 12));
                employee2.setName("Bo");
                employee2.setGender(Gender.MALE);
                employee2.setVegetarian(true);
                employee2.setUser(user2);
                employeeRepository.save(employee2);
            } else {
                System.out.println("User with email 'Bo@example.com' already exists.");
            }

            // Check and insert user3 if it doesn't exist
            if (!userRepository.existsByEmail("gg@example.com")) {
                User user3 = new User();
                user3.setEmail("gg@example.com");
                user3.setPassword("password2");
                userRepository.save(user3);

                // Create and save the associated employee
                Employee employee3 = new Employee();
                employee3.setBorn(LocalDateTime.of(2012, 5, 10, 11, 9, 12));
                employee3.setName("Gigi"); // Use a unique name if possible
                employee3.setGender(Gender.FEMALE);
                employee3.setVegetarian(false);
                employee3.setUser(user3);
                employeeRepository.save(employee3);
            } else {
                System.out.println("User with email 'gg@example.com' already exists.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
