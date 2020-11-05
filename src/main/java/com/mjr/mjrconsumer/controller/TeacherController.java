package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.Teacher;
import com.mjr.mjrconsumer.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String addStudent(Model model){
        model.addAttribute("teacher", new Teacher());
        return "add-teacher";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("newTeacher") Teacher teacher) {
        teacherService.create(teacher);
        return "redirect:/teachers";
    }

    @RequestMapping(value ="/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@RequestParam Integer id) {
        teacherService.delete(id);
        return "redirect:/teachers";
    }
}
