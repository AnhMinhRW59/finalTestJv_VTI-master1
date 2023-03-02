package com.example.finaltestjv_vti.Service.impl;

import com.example.finaltestjv_vti.Exception.AppException;
import com.example.finaltestjv_vti.Exception.ErrorResponseBase;
import com.example.finaltestjv_vti.Repository.ClassRepository;
import com.example.finaltestjv_vti.Repository.Specification.ClassSpecification;
import com.example.finaltestjv_vti.Service.IClassService;
import com.example.finaltestjv_vti.modal.Entity.*;
import com.example.finaltestjv_vti.modal.Entity.Class;
import com.example.finaltestjv_vti.modal.Request.CreateClassReq;
import com.example.finaltestjv_vti.modal.Request.SearchClassReq;
import com.example.finaltestjv_vti.modal.Request.UpdateClassReq;
import com.example.finaltestjv_vti.modal.dto.BaseReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService implements IClassService {

    @Autowired
    ClassRepository repository;

    @Autowired
    AccountService accountService;

    @Autowired
    ZoomService zoomService;

    @Autowired
    ClassRoomService classRoomService;

    @Override
    public List<Class> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Class> search(SearchClassReq req) {
        Specification<Class> classSpecification = ClassSpecification.buildCondition(req);
        PageRequest pageRequest = BaseReq.buildPageReq(req);
        return repository.findAll(classSpecification, pageRequest);
    }

    @Override
    public Class getById(int id) {
        Optional<Class> classOptional = repository.findById(id);
        if (classOptional.isEmpty()){
            throw new AppException(ErrorResponseBase.NOT_FOUND);
        }
        return classOptional.get();
    }

    @Override
    public void create(CreateClassReq req) {
        Class classSv = new Class();
        BeanUtils.copyProperties(req, classSv);
        classSv.setClassStatus(ClassStatus.PENDING);
        Account account = accountService.getById(req.getMentorId());
        ClassRoom classRoom = classRoomService.getById(req.getClassRoomId());
        Zoom zoom = zoomService.getById(req.getZoomId());
       if (account != null && classRoom != null && zoom != null){
                classSv.setZoomId(zoom);
                classSv.setClassRoomId(classRoom);
                classSv.setMentorId(account);
           Date currentDate = new Date();
           Calendar calendar = Calendar.getInstance();
           calendar.setTime(currentDate);
           calendar.add(Calendar.MONTH, 6);
           Date endDate = calendar.getTime();
                classSv.setStartDate(currentDate);
                classSv.setEndDate(endDate);
            repository.save(classSv);
        }
    }

    @Override
    public Class update(int id, UpdateClassReq req) {
        Class classDb = getById(id);
        if (classDb != null){
            BeanUtils.copyProperties(req, classDb);
            classDb.setId(id);
            Account account = accountService.getById(req.getMentorId());
            ClassRoom classRoom = classRoomService.getById((req.getClassRoomId()));
            Zoom zoom = zoomService.getById(req.getZoomId());
            classDb.setMentorId(account);
            classDb.setClassRoomId(classRoom);
            classDb.setZoomId(zoom);
            repository.save(classDb);
        }
        return null;
    }

    @Override
    public void delete(int id) {
       repository.deleteById(id);
    }
}
