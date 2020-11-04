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
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String findAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("newstudent", new Student());
        return "crud-students";
    }

    @GetMapping("/students/add")
    public String addStudent(Model model){
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/students/save")
    public String create(@Valid @ModelAttribute("newStudent") Student student) {
        studentService.create(student);
        return "redirect:/";
    }


    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Integer id) {
        studentService.delete(id);
        return "redirect:/";
    }

}

