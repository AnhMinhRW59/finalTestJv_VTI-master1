package com.example.finaltestjv_vti.Controller;

import com.example.finaltestjv_vti.Service.impl.ZoomService;
import com.example.finaltestjv_vti.modal.Entity.Zoom;
import com.example.finaltestjv_vti.modal.Request.CreateZoomReq;
import com.example.finaltestjv_vti.modal.Request.UpdateZoomReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/final/zoom")
@CrossOrigin("*")
public class ZoomController {

    @Autowired
    ZoomService service;

    @GetMapping("/get-all")
    List<Zoom> getAll(){
       return service.getAll();
    }

    @GetMapping("{id}")
    Zoom getById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("/create")
    void create(CreateZoomReq req){
        service.create(req);
    }

    @DeleteMapping("{id}")
    void delete(int id){
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    Zoom update(@PathVariable int id, @RequestBody UpdateZoomReq req){
        return service.update(id, req);
    }
}
