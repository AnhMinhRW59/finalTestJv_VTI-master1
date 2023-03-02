package com.example.finaltestjv_vti.Service;

import com.example.finaltestjv_vti.modal.Entity.Account;
import com.example.finaltestjv_vti.modal.Request.CreateAccountReq;
import com.example.finaltestjv_vti.modal.Request.SearchAccountReq;
import com.example.finaltestjv_vti.modal.Request.UpdateAccountReq;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAccountService {

    List<Account> getAll();

    Page<Account> search(SearchAccountReq req);

    Account getById(int id);

    void create(CreateAccountReq req);

    Account update(int id, UpdateAccountReq req);

    void delete(int id);
}
