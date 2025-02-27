package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeModel addEmployee(EmployeeDTO employeeDTO) {
        log.info("Adding new employee: {}", employeeDTO);
        EmployeeModel employee = new EmployeeModel(employeeDTO);
        return repository.save(employee);
    }

    public List<EmployeeModel> getAllEmployees() {
        log.info("Fetching all Employees");
        return repository.findAll();
    }

    public EmployeeModel getEmployeeById(Long id) {
        log.info("Fetching employee with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }

    public EmployeeModel updateEmployee(Long id, EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(employeeDTO.getName());
                    employee.setSalary(employeeDTO.getSalary());
                    employee.setGender(employeeDTO.getGender());
                    employee.setStartDate(employeeDTO.getStartDate());
                    employee.setNote(employeeDTO.getNote());
                    employee.setProfilePic(employeeDTO.getProfilePic());
                    employee.setDepartment(employeeDTO.getDepartment());
                    log.info("Updated employee details: {}", employee);
                    return repository.save(employee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }
    public List<EmployeeModel> getSalesDepartmentEmployees() {
        return repository.findSalesDepartmentEmployees();
    }

    public void deleteEmployee(Long id) {
        log.info("Deleting employee with ID: {}", id);
        if (!repository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with ID: " + id);
        }
        repository.deleteById(id);
    }
}