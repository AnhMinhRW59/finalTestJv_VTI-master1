package com.example.finaltestjv_vti.Service.impl;

import com.example.finaltestjv_vti.Exception.AppException;
import com.example.finaltestjv_vti.Exception.ErrorResponseBase;
import com.example.finaltestjv_vti.Repository.AccountRepository;
import com.example.finaltestjv_vti.Repository.Specification.AccountSpecification;
import com.example.finaltestjv_vti.Service.IAccountService;
import com.example.finaltestjv_vti.modal.Entity.Account;
import com.example.finaltestjv_vti.modal.Entity.Class;
import com.example.finaltestjv_vti.modal.Entity.Role;
import com.example.finaltestjv_vti.modal.Request.CreateAccountReq;
import com.example.finaltestjv_vti.modal.Request.SearchAccountReq;
import com.example.finaltestjv_vti.modal.Request.UpdateAccountReq;
import com.example.finaltestjv_vti.modal.dto.BaseReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService, UserDetailsService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;



    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }

    @Override
    public Page<Account> search(SearchAccountReq req) {
        Specification<Account> accountSpecification = AccountSpecification.buildCondition(req);
        PageRequest pageRequest = BaseReq.buildPageReq(req);
        return repository.findAll(accountSpecification, pageRequest);
    }

    @Override
    public Account getById(int id) {
        Optional<Account> optional = repository.findById(id);
        if (optional.isEmpty()){
            return null;
        }else
        return optional.get();
    }

    @Override
    public void create(CreateAccountReq req) {
        Account account = new Account();
        String encoderPassword = encoder.encode(req.getPassword());
        BeanUtils.copyProperties(req, account);
        account.setPassword(encoderPassword);
        account.setRole(Role.STUDENT);
        Optional<Account> accountCheck = repository.getByUserName(req.getUserName());
        if (accountCheck.isPresent()){
            throw new AppException(ErrorResponseBase.USERNAME_EXISTED);
        }else {
            repository.save(account);
        }
    }




    @Override
    public Account update(int id, UpdateAccountReq req) {
        Account accountDb = getById(id);
        if (accountDb != null){
            BeanUtils.copyProperties(req,accountDb);
            accountDb.setId(id);
            repository.save(accountDb);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Account> optional = repository.getByUserName(username);
            if (optional.isPresent()){
                Account account = optional.get();
                // Lấy giá trị authorities để phân quyền
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(account.getRole());

                return new User(account.getUserName(), account.getPassword(), authorities);
            } else {
                throw new UsernameNotFoundException(username);
            }
        }
    }

