package com.bridgelabz.employeepayrollapp.model;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private String department;

    // Constructor to create EmployeeModel from EmployeeDTO
    public EmployeeModel(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.startDate = employeeDTO.getStartDate();
        this.note = employeeDTO.getNote();
        this.profilePic = employeeDTO.getProfilePic();
        this.department = employeeDTO.getDepartment();
    }

    // Default constructor (required by JPA)
    public EmployeeModel() {
    }
}
