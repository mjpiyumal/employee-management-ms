package com.manoj.department_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Department {

    private Long dId;
    private String dName;
    private List<Employee> employees = new ArrayList<>();

}
