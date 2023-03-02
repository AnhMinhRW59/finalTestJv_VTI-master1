package com.example.finaltestjv_vti.Service.impl;

import com.example.finaltestjv_vti.Exception.AppException;
import com.example.finaltestjv_vti.Exception.ErrorResponseBase;
import com.example.finaltestjv_vti.Repository.ClassRoomRepository;
import com.example.finaltestjv_vti.Repository.Specification.ClassRoomSpecification;
import com.example.finaltestjv_vti.Service.IClassRoomService;
import com.example.finaltestjv_vti.modal.Entity.ClassRoom;
import com.example.finaltestjv_vti.modal.Request.CreateClassroomReq;
import com.example.finaltestjv_vti.modal.Request.SearchClassRoomReq;
import com.example.finaltestjv_vti.modal.Request.UpdateClassroomReq;
import com.example.finaltestjv_vti.modal.dto.BaseReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRoomService implements IClassRoomService {

    @Autowired
    ClassRoomRepository repository;

    @Override
    public List<ClassRoom> getAll() {
        return repository.findAll();
    }

    @Override
    public ClassRoom getById(int id) {
        Optional<ClassRoom> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new AppException(ErrorResponseBase.NOT_FOUND);
        } else {
           return optional.get();
        }
    }

    @Override
    public Page<ClassRoom> search(SearchClassRoomReq req) {
        Specification<ClassRoom> classRoomSpecification = ClassRoomSpecification.buildCondition(req);
        PageRequest pageRequest = BaseReq.buildPageReq(req);
        return repository.findAll(classRoomSpecification, pageRequest);
    }

    @Override
    public void create(CreateClassroomReq req) {
        ClassRoom classRoom = new ClassRoom();
        BeanUtils.copyProperties(req, classRoom);
        Optional<ClassRoom> classRoomCheck = repository.getByRoomName(req.getRoomName());
        if (classRoomCheck.isPresent()){
            throw new AppException(ErrorResponseBase.USERNAME_EXISTED);
        }
        repository.save(classRoom);
    }


    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    public ClassRoom update(int id, UpdateClassroomReq req) {
        ClassRoom roomDb = getById(id);
        if (roomDb != null){
            BeanUtils.copyProperties(id, req);
            roomDb.setId(id);
            repository.save(roomDb);
        }
        return null;
    }
}

