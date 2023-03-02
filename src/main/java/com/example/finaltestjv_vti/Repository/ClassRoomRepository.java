package com.example.finaltestjv_vti.Repository;

import com.example.finaltestjv_vti.modal.Entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
    Optional<ClassRoom> getByRoomName(String roomName);
}
