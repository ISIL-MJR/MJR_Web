package com.mjr.mjrconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ClassToTeach {

    private Integer idClass;

    private Date classDate;


    private Teacher teacher;


    private ClassStudents classStudents;

    @Override
    public String toString() {
        return "ClassToTeach{" +
                "idClass=" + idClass +
                ", classDate=" + classDate +
                ", teacher=" + teacher +
                ", classStudents=" + classStudents +
                '}';
    }
}
