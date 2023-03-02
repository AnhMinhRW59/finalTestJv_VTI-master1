package com.example.finaltestjv_vti.modal.Request;

import com.example.finaltestjv_vti.modal.Entity.Role;
import lombok.Data;

@Data
public class UpdateAccountReq {
    private String address;

    private String password;

    private String phoneNumber;

    private String email;

    private String facebook;

    private String information;

    private int classId;

    private Role role;
}
