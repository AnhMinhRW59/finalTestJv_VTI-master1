package com.example.finaltestjv_vti.modal.Request;

import lombok.Data;

import java.util.Date;

@Data
public class CreateAccountReq {

    private String userName;

    private Date birthDay;

    private String address;

    private String password;

    private String fullName;

    private String phoneNumber;

    private String email;

    private String facebook;

    private String information;

}
