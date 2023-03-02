package com.example.finaltestjv_vti.Controller;

import com.example.finaltestjv_vti.Service.impl.AccountService;
import com.example.finaltestjv_vti.modal.Entity.Account;
import com.example.finaltestjv_vti.modal.Request.CreateAccountReq;
import com.example.finaltestjv_vti.modal.Request.SearchAccountReq;
import com.example.finaltestjv_vti.modal.Request.UpdateAccountReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/final/account")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/get-all")
    public List<Account> getAll() {
        return service.getAll();
    }

    @GetMapping("/get")
    Account getById(@RequestParam int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    void delete(int id) {
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    Account update(@RequestBody UpdateAccountReq req, @PathVariable int id) {
        return service.update(id, req);
    }

    @PostMapping("/create")
     void create(@RequestBody CreateAccountReq req){
        service.create(req);
    }

    @PostMapping("/search")
    Page<Account> search(@RequestBody SearchAccountReq req){
        return service.search(req);
    }
}
