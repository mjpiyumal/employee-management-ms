package com.manoj.employeeservice.controller;

import com.manoj.employeeservice.model.Employee;
import com.manoj.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/save")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeRepository.addEmployee(employee);
        return employee;
    }

    @GetMapping("/{employeeId}")
    public Employee findByEmployeeId(@PathVariable long employeeId) {
        return employeeRepository.findById(employeeId);
    }


    @GetMapping("/all")
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("department/{departmentId}")
    public List<Employee> findByDepartmentId(@PathVariable long departmentId) {
        return employeeRepository.findByDepartment(departmentId);
    }

}
