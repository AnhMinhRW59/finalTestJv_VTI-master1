package com.example.finaltestjv_vti.modal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "zoom")
public class Zoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",length = 50, nullable = false, unique = true)
    private String zoomName;

    @Column(name = "link", length = 255, nullable = false,unique = true)
    private String link;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "note", length = 500)
    private String note;

    @Column(name = "meeting_id", length = 15, nullable = false, unique = true)
    private String meetingId;

    @Column(name = "pass_code", length = 15, nullable = false)
    private String passCode;

}
