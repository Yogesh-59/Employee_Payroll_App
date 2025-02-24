package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    public final EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public EmployeeModel addEmployee(EmployeeModel employee) {
        return repository.save(employee);
    }

    public List<EmployeeModel> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<EmployeeModel> getEmployeeById(Long id) {
        return repository.findById(id);
    }
    public EmployeeModel updateEmployee(Long id, EmployeeModel updatedEmployee) {
        return repository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setSalary(updatedEmployee.getSalary());
            return repository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}