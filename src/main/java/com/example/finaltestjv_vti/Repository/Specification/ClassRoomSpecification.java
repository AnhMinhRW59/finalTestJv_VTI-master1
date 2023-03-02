package com.example.finaltestjv_vti.Repository.Specification;

import com.example.finaltestjv_vti.modal.Entity.ClassRoom;
import com.example.finaltestjv_vti.modal.Request.SearchClassRoomReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;


public class ClassRoomSpecification {

    public static Specification<ClassRoom> buildCondition(SearchClassRoomReq req){
        return Specification.where(searchByRoomName(req.getRoomName()))
                .and(searchByAddress(req.getAddress()))
                .and(searchByNote(req.getNote()))
                .and(searchBySize(req.getSize()));
    }

    private static Specification<ClassRoom> searchByRoomName(String roomName){
        if (StringUtils.isNotBlank(roomName)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("roomName"), "%" + roomName + "%");
            };
        }else {
            return null;
        }
    }

    private static Specification<ClassRoom> searchByAddress(String address){
        if (StringUtils.isNotBlank(address)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("address"), "%" + address + "%");
            };
        }else {
            return null;
        }
    }

    private static Specification<ClassRoom> searchByNote(String note){
        if (StringUtils.isNotBlank(note)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("note"), "%" + note + "%");
            };
        }else {
            return null;
        }
    }


    private static Specification<ClassRoom> searchBySize(int size){
        if (size > 0){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("size"), size);
            };
        }else {
            return null;
        }

    }


}
