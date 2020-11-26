package com.mjr.mjrconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Teacher {

    private Integer idTeacher;

    private String firstName;

    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String documentType;

    private String documentNumber;

    private String phoneNumber;

    private String email;

    private String password;

    private String status;
}
