package com.mjr.mjrconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClassStudents {

    private Integer idClassStudent;

    private Boolean isGroupClass;

    private String nameGroupClass;


    private List<Student> students;


}
