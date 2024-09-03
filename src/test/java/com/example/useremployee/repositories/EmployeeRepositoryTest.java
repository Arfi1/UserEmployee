package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;


        @Test
        void testAtLeastOneSmith() {
        List<Employee> eL = employeeRepository.findEmployeeByName("smith");
        assertFalse(eL.size() >1 );

    }


    @Test
    void testUserOne() {

    }

}