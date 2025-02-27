package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeeModel;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/post")
    public EmployeeModel addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to add employee: {}", employeeDTO);
        return service.addEmployee(employeeDTO);
    }

    @GetMapping("/get")
    public List<EmployeeModel> getAllEmployees() {
        log.info("Received request to fetch all employees");
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeModel getEmployeeById(@PathVariable Long id) {
        log.info("Received request to fetch employee with ID: {}", id);
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeModel updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        log.info("Received request to update employee with ID: {}", id);
        return service.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        log.info("Received request to delete employee with ID: {}", id);
        service.deleteEmployee(id);
        return "Employee deleted successfully!";
    }
}