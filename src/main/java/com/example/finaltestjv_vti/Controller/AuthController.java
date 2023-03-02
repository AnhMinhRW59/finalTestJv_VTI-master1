package com.example.finaltestjv_vti.Controller;

import com.example.finaltestjv_vti.Exception.AppException;
import com.example.finaltestjv_vti.Exception.ErrorResponseBase;
import com.example.finaltestjv_vti.Repository.AccountRepository;
import com.example.finaltestjv_vti.modal.Entity.Account;
import com.example.finaltestjv_vti.modal.dto.LoginDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("api/final/auth")
@CrossOrigin("*")
@Validated
public class AuthController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/login")
    public LoginDto login(Principal principal) { // đối tượng Principal có chứa thông tin username
        // Khi qua bước authen sẽ tạo ra đối tượng Principal, tại controller sẽ sử dụng lại giá trị của dữ liệu này
        String username = principal.getName();
        Optional<Account> accountOptional = accountRepository.getByUserName(username);
        if (accountOptional.isEmpty()) {
            throw new AppException(ErrorResponseBase.LOGIN_FAILS);
        }
        LoginDto loginDto = new LoginDto();
        BeanUtils.copyProperties(accountOptional.get(), loginDto);
        return loginDto;
    }
}