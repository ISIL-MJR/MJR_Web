package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.Student;
import com.mjr.mjrconsumer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public String findAllStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("newstudent", new Student());
        return "crud-students";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestParam Integer id, Student student) {
        studentService.update(id, student);
        return "add-student";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(@RequestParam Integer id) {
        studentService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newStudent") Student student) {
        studentService.create(student);
        return "redirect:/";
    }
}

