package com.example.finaltestjv_vti.Service;

import com.example.finaltestjv_vti.modal.Entity.ClassRoom;
import com.example.finaltestjv_vti.modal.Request.CreateClassroomReq;
import com.example.finaltestjv_vti.modal.Request.SearchClassRoomReq;
import com.example.finaltestjv_vti.modal.Request.UpdateClassroomReq;
import org.springframework.data.domain.Page;

import java.util.List;


public interface IClassRoomService {
    List<ClassRoom> getAll();

    ClassRoom getById(int id);

    Page<ClassRoom> search(SearchClassRoomReq req);

    void create(CreateClassroomReq req);

    void delete(int id);

    ClassRoom update(int id, UpdateClassroomReq req);
}
