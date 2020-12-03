package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.Classroom;
import com.mjr.mjrconsumer.model.Student;
import com.mjr.mjrconsumer.model.Teacher;
import com.mjr.mjrconsumer.service.ClassroomService;
import com.mjr.mjrconsumer.service.StudentService;
import com.mjr.mjrconsumer.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("classrooms", classroomService.findAll());
        model.addAttribute("newclassroom", new Classroom());
        return "crud-classrooms";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addClassroom(Model model){
        model.addAttribute("classroom", new Classroom());
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "add-classrooms";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newClassroom") Classroom classroom) {

        Integer idTeacher = classroom.getTeacher().getIdTeacher();
        Teacher currentTeacher = teacherService.findById(idTeacher);

        Integer idStudent1 = classroom.getStudent1().getIdStudent();
        Student currentStudent1 = studentService.findById(idStudent1);

        Integer idStudent2 = classroom.getStudent2().getIdStudent();
        Student currentStudent2 = studentService.findById(idStudent2);

        Integer idStudent3 = classroom.getStudent3().getIdStudent();
        Student currentStudent3 = studentService.findById(idStudent3);

        Integer idStudent4 = classroom.getStudent4().getIdStudent();
        Student currentStudent4 = studentService.findById(idStudent4);

        classroom.setTeacher(currentTeacher);
        classroom.setStudent1(currentStudent1);
        classroom.setStudent2(currentStudent2);
        classroom.setStudent3(currentStudent3);
        classroom.setStudent4(currentStudent4);

        classroomService.create(classroom);
        return "redirect:/classrooms";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String classroomForUpdate(Model model, @PathVariable Integer id){
        Classroom currentClassroom = classroomService.findById(id);
        model.addAttribute("classroom", currentClassroom);
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "update-classroom";
    }

    @RequestMapping(value ="/update/{id}", method = RequestMethod.POST)
    public String update(Classroom classroom, @PathVariable Integer id) {
        classroomService.update(id, classroom);
        return "redirect:/classrooms";
    }
}
