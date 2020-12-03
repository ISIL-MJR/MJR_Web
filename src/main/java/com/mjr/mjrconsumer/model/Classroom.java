package com.mjr.mjrconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Classroom {

    private Integer id;
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String status;
    private Long startTime;
    private Long endTime;

    private Teacher teacher;

    private Student student1;

    private Student student2;

    private Student student3;

    private Student student4;




}
