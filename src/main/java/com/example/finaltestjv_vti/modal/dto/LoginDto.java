package com.example.finaltestjv_vti.modal.dto;

import com.example.finaltestjv_vti.modal.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private int id;
    private String username;
    private Role role;
    private String fullName;
}
