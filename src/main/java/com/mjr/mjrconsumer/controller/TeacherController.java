package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.Teacher;
import com.mjr.mjrconsumer.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        model.addAttribute("newsteacher", new Teacher());
        return "crud-teachers";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTeacher(Model model){
        model.addAttribute("teacher", new Teacher());
        return "add-teacher";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newTeacher") Teacher teacher) {
        teacherService.create(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String teacherForUpdate(Model model, @PathVariable Integer id){
        Teacher currentTeacher = teacherService.findById(id);
        model.addAttribute("teacher", currentTeacher);
        return "update-teacher";
    }

    @RequestMapping(value ="/update/{id}", method = RequestMethod.POST)
    public String update(Teacher teacher, @PathVariable Integer id) {
        teacherService.update(id, teacher);
        return "redirect:/teachers";
    }
}
