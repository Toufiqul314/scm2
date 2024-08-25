package com.scm.scm2.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Name is required")
    @Size(min = 3,message = "Min 3 characters is required")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6,message = "Min 6 characters is required")
    private String password;
    @NotBlank(message = "About is required")
    @Size(message = "About is required")
    private String about;
    @Size(min = 8,max = 11,message = "Invalid Phone Number")
    private int phoneNumber;
}
