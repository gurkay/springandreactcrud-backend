package com.springandreactcrud.springandreactcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springandreactcrud.springandreactcrud.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Long>{

}
