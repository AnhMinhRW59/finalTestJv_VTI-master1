package com.example.finaltestjv_vti.Service;

import com.example.finaltestjv_vti.modal.Entity.Zoom;
import com.example.finaltestjv_vti.modal.Request.CreateZoomReq;
import com.example.finaltestjv_vti.modal.Request.UpdateZoomReq;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IZoomService {
    List<Zoom> getAll();

    Zoom getById(int id);

    Page<Zoom> search();

    Zoom update();

    void create(CreateZoomReq req);

    void delete(int id);

    Zoom update(int id, UpdateZoomReq req);
}
