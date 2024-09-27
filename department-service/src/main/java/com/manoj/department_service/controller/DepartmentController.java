package com.manoj.department_service.controller;

import com.manoj.department_service.client.EmployeeClient;
import com.manoj.department_service.model.Department;
import com.manoj.department_service.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private EmployeeClient employeeClient;

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger LOGGER
            = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/save")
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id) {
        LOGGER.info("Find the department: id {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/all")
    public List<Department> findAll() {
        LOGGER.info("Find all the departments");
        return departmentRepository.findAll();
    }


    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Find all the departments");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department ->
                department.setEmployees(employeeClient.findByDepartmentId(department.getDId())));
        return departments;
    }

}
