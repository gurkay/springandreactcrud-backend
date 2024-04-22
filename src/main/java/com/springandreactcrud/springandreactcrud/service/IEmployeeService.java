package com.springandreactcrud.springandreactcrud.service;

import java.util.List;

import com.springandreactcrud.springandreactcrud.dto.EmployeeDto;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);
    void deleteEmployee(Long id);
}
