package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Data
public class AddressDTO {
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Za-z\\s]+$",message = "Name should contain only alphabets and spaces")
    private String id;
    private String name;
    private String phoneNumber;
    private String email;

}
