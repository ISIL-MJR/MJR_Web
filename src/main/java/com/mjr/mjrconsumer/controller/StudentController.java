package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.Student;
import com.mjr.mjrconsumer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("newstudent", new Student());
        return "crud-students";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newStudent") Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String studentForUpdate(Model model, @PathVariable Integer id){
        Student currentStudent = studentService.findById(id);
        model.addAttribute("student", currentStudent);
        return "update-student";
    }

    @RequestMapping(value ="/update/{id}", method = RequestMethod.POST)
    public String update(Student student, @PathVariable Integer id) {
        studentService.update(id, student);
        return "redirect:/students";
    }
}

