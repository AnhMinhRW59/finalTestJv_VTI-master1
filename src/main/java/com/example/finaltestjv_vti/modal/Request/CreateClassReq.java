package com.example.finaltestjv_vti.modal.Request;


import com.example.finaltestjv_vti.modal.Entity.*;
import lombok.Data;

import java.util.Date;

@Data
public class CreateClassReq {

    private String className;

    private Date startDate;

    private Date endDate;

    private int mentorId;

    private int zoomId;

    private int classRoomId;

    private String description;

    private String schedule;

    private TeachingForm teachingForm;

    private ClassStatus classStatus;
}
