package com.maestro.app.practice.ch1.ms.employees.services;

import com.maestro.app.practice.ch1.ms.employees.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@Slf4j
class EmployeeServiceTest {
    @Autowired
    public EmployeeRepository empRepository;

    @Test
    public void checkRepository() {
    }
}