package com.example.finaltestjv_vti.modal.Request;

import com.example.finaltestjv_vti.modal.Entity.ClassStatus;
import com.example.finaltestjv_vti.modal.Entity.TeachingForm;
import lombok.Data;

import java.util.Date;

@Data
public class UpdateClassReq {

    private Date startDate;

    private Date endDate;

    private int mentorId;

    private int zoomId;

    private int classRoomId;

    private String schedule;

    private ClassStatus classStatus;

    private TeachingForm teachingForm;
}
