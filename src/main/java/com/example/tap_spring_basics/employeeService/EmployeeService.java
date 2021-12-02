package com.example.tap_spring_basics.employeeService;


import com.example.tap_spring_basics.employeeEntity.Employee;
import com.example.tap_spring_basics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee("Joe", "Dow", LocalDate.of(1978, 12, 2)));
        employeeRepository.save(new Employee("Jane", "Dow", LocalDate.of(1979, 2, 2)));
    }

    public void add(Employee employee) {
        System.out.println(employee);
    }
}