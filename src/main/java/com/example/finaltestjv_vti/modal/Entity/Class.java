package com.example.finaltestjv_vti.modal.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "class_name", length = 50, nullable = false, unique = true)
    private String className;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    private Account mentorId;

    @ManyToOne
    @JoinColumn(name = "zoom_id")
    private Zoom zoomId;

    @ManyToOne
    @JoinColumn(name = "class_zoom_id")
    private ClassRoom classRoomId;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "schedule", length = 255, nullable = false)
    private String schedule;

    @Column(name = "class_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassStatus classStatus;

    @Column(name = "teaching_form", nullable = false)
    @Enumerated(EnumType.STRING)
    private TeachingForm teachingForm;
}
