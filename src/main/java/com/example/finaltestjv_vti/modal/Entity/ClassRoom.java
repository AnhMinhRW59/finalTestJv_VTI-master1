package com.example.finaltestjv_vti.modal.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "class_room")
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    private String roomName;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "size")
    private int size;
}
