package com.example.finaltestjv_vti.Repository;

import com.example.finaltestjv_vti.modal.Entity.Zoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZoomRepository extends JpaRepository<Zoom, Integer>, JpaSpecificationExecutor<Zoom> {
    Optional<Zoom> getByMeetingId(String id);
}
