package com.dnldubinkin.spring.rest.controller;


import com.dnldubinkin.spring.rest.entity.Employee;
import com.dnldubinkin.spring.rest.exeption_handling.EmployeeIncorrectData;
import com.dnldubinkin.spring.rest.exeption_handling.NoSuchEmployeeException;
import com.dnldubinkin.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("employees/{id}")
    public Employee getEmpById(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id " + id + " not found in dataBase");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeService.saveUpdateEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveUpdateEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "Employee with id " + id + " deleted successfully";
    }
}
