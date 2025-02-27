package com.bridgelabz.employeepayrollapp.model;
import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee_payroll")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "note", nullable = false)
    private String note;

    @Column(name = "profile_pic", nullable = false)
    private String profilePic;

    @Column(name = "department", nullable = false)
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
