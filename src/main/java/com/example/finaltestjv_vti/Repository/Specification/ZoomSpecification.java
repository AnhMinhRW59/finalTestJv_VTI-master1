package com.example.finaltestjv_vti.Repository.Specification;

import com.example.finaltestjv_vti.modal.Entity.Zoom;
import com.example.finaltestjv_vti.modal.Request.SearchZoomReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class ZoomSpecification {


    public static Specification<Zoom> buildCondition(SearchZoomReq req) {
       return Specification.where(searchByZoomName(req.getZoomName()))
                .and(searchByDescription(req.getDescription()))
                .and(searchByLink(req.getLink()))
                .and(searchByNote(req.getNote()))
                .and(searchByMeetingId(req.getMeetingId()));
    }

    private static Specification<Zoom> searchByZoomName(String zoomName){
        if (StringUtils.isNotBlank(zoomName)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("zoomName"), "%" + zoomName + "%");
            };
        }else return null;
    }

    private static Specification<Zoom> searchByLink(String link){
        if (StringUtils.isNotBlank(link)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.equal(root.get("link"), link);
            };
        }else return null;
    }

    private static Specification<Zoom> searchByDescription(String description){
        if (StringUtils.isNotBlank(description)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("description"), "%" + description +"%");
            };
        }else return null;
    }


    private static Specification<Zoom> searchByNote(String note){
        if (StringUtils.isNotBlank(note)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.like(root.get("note"), "%" + note +"%");
            };
        }else return null;
    }


    private static Specification<Zoom> searchByMeetingId(String meetingId){
        if (StringUtils.isNotBlank(meetingId)){
            return (root, query, criteriaBuilder) -> {
                return criteriaBuilder.equal(root.get("description"),meetingId );
            };
        }else return null;
    }
}
