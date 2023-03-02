package com.example.finaltestjv_vti.Service.impl;

import com.example.finaltestjv_vti.Exception.AppException;
import com.example.finaltestjv_vti.Exception.ErrorResponseBase;
import com.example.finaltestjv_vti.Repository.ZoomRepository;
import com.example.finaltestjv_vti.Service.IZoomService;
import com.example.finaltestjv_vti.modal.Entity.Zoom;
import com.example.finaltestjv_vti.modal.Request.CreateZoomReq;
import com.example.finaltestjv_vti.modal.Request.UpdateZoomReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoomService implements IZoomService {


    @Autowired
    ZoomRepository repository;


    @Override
    public List<Zoom> getAll() {
        return repository.findAll();
    }

    @Override
    public Zoom getById(int id) {
        Optional<Zoom> optional = repository.findById(id);
        if (optional.isEmpty()){
            throw new AppException(ErrorResponseBase.NOT_FOUND);
        }
        return optional.get();
    }

    @Override
    public Page<Zoom> search() {
        return null;
    }

    @Override
    public Zoom update() {
        return null;
    }

    @Override
    public void create(CreateZoomReq req) {
        Zoom zoom = new Zoom();
        BeanUtils.copyProperties(req, zoom);
        Optional<Zoom> zoomCheck = repository.getByMeetingId(req.getMeetingId());
        if (zoomCheck.isPresent()){
            throw new AppException(ErrorResponseBase.THISID_EXISTED);
        }
        repository.save(zoom);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    public Zoom update(int id, UpdateZoomReq req) {
        Zoom zoomDb = getById(id);
        if (zoomDb != null){
            BeanUtils.copyProperties(id, req);
            zoomDb.setId(id);
            repository.save(zoomDb);
        }
        return null;
    }
}
