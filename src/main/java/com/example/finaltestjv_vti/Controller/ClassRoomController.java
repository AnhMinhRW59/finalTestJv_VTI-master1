package com.example.finaltestjv_vti.Controller;

import com.example.finaltestjv_vti.Service.impl.ClassRoomService;
import com.example.finaltestjv_vti.modal.Entity.ClassRoom;
import com.example.finaltestjv_vti.modal.Request.CreateClassroomReq;
import com.example.finaltestjv_vti.modal.Request.UpdateClassroomReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/final/classroom")
@CrossOrigin("*")
public class ClassRoomController {

    @Autowired
    ClassRoomService service;

    @GetMapping("/get-all")
    List<ClassRoom> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    ClassRoom getById(@PathVariable int id){
       return service.getById(id);
    }

    @PostMapping("/create")
    void create(CreateClassroomReq req){
        service.create(req);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable int id){
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    ClassRoom delete(@PathVariable int id, @RequestBody UpdateClassroomReq req){
        return service.update(id, req);
    }
}
