package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = "Name should contain only alphabets and spaces")
    private String name;

    @NotNull(message = "Salary is mandatory")
    @Positive(message = "Salary must be a positive value")
    private Double salary;

    @NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female, or Other")
    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd") // Use the correct format for deserialization
    @NotNull(message = "Start date is mandatory")
    @PastOrPresent(message = "Start date must be today or in the past")
    private LocalDate startDate;

    @NotBlank(message = "Note is mandatory")
    private String note;

    @NotBlank(message = "Profile picture is mandatory")
    private String profilePic;

    @NotBlank(message = "Department is mandatory")
    private String department;
}