package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.Student;
import com.mjr.mjrconsumer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    private StudentService studentService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("newstudent", new Student());
        return "index";
    }
}
