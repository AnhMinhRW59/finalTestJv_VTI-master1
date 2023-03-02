package com.example.finaltestjv_vti.modal.Request;

import lombok.Data;

@Data
public class CreateClassroomReq {

    private String roomName;

    private String address;

    private String note;

    private int size;
}
