package com.mjr.mjrconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Teacher {

    private Integer idTeacher;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String documentType;

    private String documentNumber;

    private String phoneNumber;

    private String email;

    private String password;
}
