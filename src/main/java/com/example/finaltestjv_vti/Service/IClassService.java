package com.example.finaltestjv_vti.Service;

import com.example.finaltestjv_vti.modal.Entity.Class;
import com.example.finaltestjv_vti.modal.Request.CreateClassReq;
import com.example.finaltestjv_vti.modal.Request.SearchClassReq;
import com.example.finaltestjv_vti.modal.Request.UpdateClassReq;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IClassService {
    List<Class> getAll();

    Page<Class> search(SearchClassReq req);

    Class getById(int id);

    void create(CreateClassReq req);

    Class update(int id, UpdateClassReq req);

    void delete(int id);
}
