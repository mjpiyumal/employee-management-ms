package com.manoj.employeeservice.repository;

import com.manoj.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {


    private List<Employee> employees
            = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(employee -> {
                    boolean matcher = employee.eId().equals(id);
                    System.out.println("Employee found " + employee);
                    return matcher;
                })
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Employee not found"));
    }


    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(Long dId) {
        return employees.stream()
                .filter(employee ->
                    employee.dId().equals(dId))
                .toList();
    }
}
