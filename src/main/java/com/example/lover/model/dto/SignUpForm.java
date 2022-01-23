package com.example.lover.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SignUpForm {
    @NotBlank
    @Size(min = 2, max = 40)
    private String username;
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    @NotBlank
    @Size(min = 2, max = 40)
    private String password;
    private String avatar;
    private String phone;
    private Set<String> roles;
}
