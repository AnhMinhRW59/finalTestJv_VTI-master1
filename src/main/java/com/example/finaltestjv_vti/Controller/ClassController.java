package com.example.finaltestjv_vti.Controller;

import com.example.finaltestjv_vti.Service.impl.ClassService;
import com.example.finaltestjv_vti.modal.Entity.Class;
import com.example.finaltestjv_vti.modal.Request.CreateClassReq;
import com.example.finaltestjv_vti.modal.Request.SearchClassReq;
import com.example.finaltestjv_vti.modal.Request.UpdateClassReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/final/class")
@CrossOrigin("*")
public class ClassController {


    @Autowired
    ClassService service;

    @GetMapping("/get-all")
    List<Class> getAll(){
        return service.getAll();
    }


    @GetMapping("{id}")
    Class getById(@PathVariable int id){
        return service.getById(id);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable int id){
        service.delete(id);
    }

    @PostMapping("/create")
    void create(@RequestBody CreateClassReq req){
        service.create(req);
    }

    @PutMapping("/update/{id}")
    Class update(@PathVariable int id,@RequestBody UpdateClassReq req){
       return service.update(id, req);
    }

    @PostMapping("/search")
    Page<Class> search(@RequestBody SearchClassReq req){
       return service.search(req);
    }
}
