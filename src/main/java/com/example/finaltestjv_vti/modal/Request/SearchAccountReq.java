package com.example.finaltestjv_vti.modal.Request;

import com.example.finaltestjv_vti.modal.Entity.Class;
import com.example.finaltestjv_vti.modal.Entity.Role;
import com.example.finaltestjv_vti.modal.dto.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchAccountReq extends BaseReq {

    private String userName;

    private String address;

    private String fullName;

    private String email;

    private int classId;

    private Role role;
}
