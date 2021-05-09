package com.maestro.app.ms.practice.employees.services;

import com.maestro.app.ms.practice.employees.entities.Employee;
import com.maestro.app.ms.practice.employees.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository empRepository;

    public List<Employee> getList() {
        return empRepository.findAll();
    }

    public Employee get(Long id) {
        Optional<Employee>  rec = empRepository.findById(id);
        return rec.orElse(null);
    }

    public void save(Employee emp) {
        empRepository.save(emp);
    }

    public void delete(Employee emp) {
        empRepository.delete(emp);
    }

    public void  saveFile(final InputStream inputStream) throws IOException {
        final long start = System.currentTimeMillis();

        List<Employee> depts = parseCSVFile(inputStream);

        log.info("\tSaving a list of {} records", depts.size());

        empRepository.saveAll(depts);

        log.info("\tElapsed time: {}", (System.currentTimeMillis() - start));
    }

    private List<Employee> parseCSVFile(final InputStream inputStream) throws IOException {
        final List<Employee> res = new ArrayList<>();

        log.info("\tParsing CSV file");

        try (final BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                final String[] data = line.split(";");
                final Employee dpt = new Employee();
                dpt.setDeptNumber(data[0]);
                dpt.setName(data[1]);
                res.add(dpt);
            }
        }

        log.info("\tHaving {} records", res.size());

        return res;
    }
}
