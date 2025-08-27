package com.example.employeeApp.controller;

import com.example.employeeApp.entity.Employee;
import com.example.employeeApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/EmployeeData")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getEmployees();
    }

    @PostMapping
    public void saveUpdate(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable("employeeId") Long employeeId) {
        employeeService.delete(employeeId);
    }
}
