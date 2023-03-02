package com.example.finaltestjv_vti.Repository.Specification;

import com.example.finaltestjv_vti.modal.Entity.Account;

import com.example.finaltestjv_vti.modal.Entity.Class;
import com.example.finaltestjv_vti.modal.Entity.Role;
import com.example.finaltestjv_vti.modal.Request.SearchAccountReq;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;

public class AccountSpecification {

    public static Specification<Account> buildCondition(SearchAccountReq req) {
        return Specification.where(searchByFullname(req.getFullName()))
                .and(searchByRole(req.getRole()))
                .and(searchByAddress(req.getAddress()))
                .and(searchByEmail(req.getEmail()))
                .and(searchByClassId(req.getClassId()))
                .and(searchByUserName(req.getUserName()));
    }

    private static Specification<Account> searchByFullname(String fullName) {
        if (fullName != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("fullName"), "%" + fullName + "%");
            });
        } else {
            return null;
        }
    }

    private static Specification<Account> searchByRole(Role role) {
        if (role != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.equal(root.get("role"), role);
            });
        } else {
            return null;
        }
    }

    private static Specification<Account> searchByEmail(String email){
        if (email != null){
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("email"), "%" + email + "%");
            });
        } else {
            return null;
        }
    }

    private static Specification<Account> searchByClassId(int id){
        if (id > 0) {
            // Kieemr tra dieu kien tim kiem (Su dung root -> join)
            return ((root, query, criteriaBuilder) -> {
                Join<Account, Class> joiner = root.join("classId");
                return criteriaBuilder.equal(joiner.get("id"), id);
            });
        } else {
            return null;
        }
    }

    private static Specification<Account> searchByAddress(String andress) {
        if (andress != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("address"), "%" + andress + "%");
            });
        } else {
            return null;
        }
    }

    private static Specification<Account> searchByUserName(String userName){
        if (userName != null) {
            return ((root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("userName"), "%" + userName + "%");
            });
        } else {
            return null;
        }
    }

}

