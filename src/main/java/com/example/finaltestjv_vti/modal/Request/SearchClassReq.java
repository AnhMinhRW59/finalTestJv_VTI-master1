package com.example.finaltestjv_vti.modal.Request;


import com.example.finaltestjv_vti.modal.Entity.ClassStatus;
import com.example.finaltestjv_vti.modal.Entity.TeachingForm;
import com.example.finaltestjv_vti.modal.dto.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchClassReq extends BaseReq {

    private String className;

    private Date startDate;

    private Date endDate;

    private int mentorId;

    private int zoomId;

    private int classRoomId;

    private String schedule;

    private ClassStatus classStatus;

    private TeachingForm teachingForm;
}
