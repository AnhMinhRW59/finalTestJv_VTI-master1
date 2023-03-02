package com.example.finaltestjv_vti.modal.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String userName;

    @Column(name = "date_of_birth", nullable = false)
    private Date birthDay;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "password", nullable = false, length = 150)
    private String password;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phoneNumber;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "facebook", nullable = false, unique = true, length = 250)
    private String facebook;

    @Column(name = "information", length = 255)
    private String information;

    @ManyToOne()
    @JoinColumn(name = "class_id")
    private Class classId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;


}
