package com.web.webApplication.department.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.web.webApplication.department.annotations.PasswordValidation;
import com.web.webApplication.department.annotations.PrimeNumberValidation;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import java.time.LocalDate;

@Controller
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "ERROR: must not be blank | SOLUTION: Provide valid title")
    private String title;

    @NotNull(message = "isActive cannot be null")
    @JsonProperty("isActive")
    private boolean isActive;

    @NotNull(message = "createdAt cannot be null")
    @PastOrPresent
    private LocalDate createdAt;

    @NotNull(message = "isPrimeNumber cannot be null")
    @PrimeNumberValidation
    @JsonProperty("isPrimeNumber")
    private Long isPrimeNumber;

    @NotNull(message = "Password cannot be null")
    @PasswordValidation
    private String password;
}
