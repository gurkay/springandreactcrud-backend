package com.springandreactcrud.springandreactcrud.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springandreactcrud.springandreactcrud.dto.EmployeeDto;
import com.springandreactcrud.springandreactcrud.entity.Employee;
import com.springandreactcrud.springandreactcrud.exception.ResourceNotFoundException;
import com.springandreactcrud.springandreactcrud.mapper.EmployeeMapper;
import com.springandreactcrud.springandreactcrud.repository.IEmployeeRepository;
import com.springandreactcrud.springandreactcrud.service.IEmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{

    private IEmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee); 
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Employee Id : " + id + " not found"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees
                .stream()
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Employee Id : " + id + " not found"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Employee Id : " + id + " not found"));
        employeeRepository.delete(employee);
    }
}
