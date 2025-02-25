package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeService {
    public final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) {

        this.repository = repository;
    }
    public EmployeeModel addEmployee(EmployeeModel employee) {
        log.info("Adding new employee:{}",employee);
        return repository.save(employee);
    }

    public List<EmployeeModel> getAllEmployees() {
        log.info("Fetching all Employees");
        return repository.findAll();
    }

    public Optional<EmployeeModel> getEmployeeById(Long id) {
       log.info("Fetching employee with ID: {}",id);
        return repository.findById(id);
    }
    public EmployeeModel updateEmployee(Long id, EmployeeModel updatedEmployee) {
      log.info("Fetching employee with ID: {}",id);
        return repository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            log.info("Updated employee details: {}",employee);
            return repository.save(employee);
        }).orElseThrow(() -> {
            log.error("Employee with ID {} not found",id);
            return new RuntimeException("Employee not found");
        });
    }
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}",id);
        repository.deleteById(id);
    }
}