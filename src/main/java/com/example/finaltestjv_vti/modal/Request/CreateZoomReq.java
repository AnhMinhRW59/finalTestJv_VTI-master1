package com.example.finaltestjv_vti.modal.Request;


import lombok.Data;

@Data
public class CreateZoomReq {

    private String zoomName;

    private String link;

    private String description;

    private String note;

    private String meetingId;

    private String passCode;
}
