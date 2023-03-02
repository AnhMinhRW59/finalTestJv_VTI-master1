package com.example.finaltestjv_vti.modal.Request;


import com.example.finaltestjv_vti.modal.dto.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchZoomReq extends BaseReq {

    private String zoomName;

    private String link;

    private String description;

    private String note;

    private String meetingId;

}
