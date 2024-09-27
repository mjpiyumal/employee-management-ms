package com.manoj.department_service.repository;

import com.manoj.department_service.model.Department;
import com.manoj.department_service.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class DepartmentRepository {


    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentRepository.class);

    private List<Department> departments
            = new ArrayList<>();


    public Department addDepartment(Department department) {
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {

         return departments.stream()
                .filter(department -> {
                    boolean matches = department.getDId().equals(id);
                    if (matches) {
                        LOGGER.info("Department found: matches {}", matches);
                        System.out.println("Department Found" + department.toString());
                    }
                    return matches;
                })
                .findFirst()
                 .orElseThrow(() -> {
                     System.out.println("No department found with ID: " + id);
                     return new NoSuchElementException("No department found with ID: " + id);
                 });
    }

    public List<Department> findAll() {
        return departments;
    }


}
