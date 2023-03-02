package com.example.finaltestjv_vti.modal.Request;


import com.example.finaltestjv_vti.modal.dto.BaseReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchClassRoomReq extends BaseReq {

    private String roomName;

    private String address;

    private String note;

    private int size;
}
