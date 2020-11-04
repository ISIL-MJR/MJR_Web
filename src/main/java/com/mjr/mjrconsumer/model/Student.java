package com.mjr.mjrconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Student {

    private Integer idStudent;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String studentLevel;


}

