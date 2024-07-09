package com.dnldubinkin.spring.rest.dao;

import com.dnldubinkin.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();
    public Employee getEmployee(int id);

    public void saveUpdateEmployee(Employee employee);
    public void deleteEmployee(int id);
}
