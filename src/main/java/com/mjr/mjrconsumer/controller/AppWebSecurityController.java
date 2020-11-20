package com.mjr.mjrconsumer.controller;

import com.mjr.mjrconsumer.model.User;
import com.mjr.mjrconsumer.service.SecurityService;
import com.mjr.mjrconsumer.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AppWebSecurityController {

    private final UserService userService;
    private final SecurityService securityService;

    public AppWebSecurityController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }


    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    private String index(){
        return "login";
    }

    @GetMapping("/index")
    private String menu(){
        return "index";
    }

    @GetMapping("/logout")
    private String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    // desde el link de Login
    @GetMapping("/registration")
    private String registration(Model model){
        model.addAttribute("user", new User());
        return "registrar";
    }

    @PostMapping("/registration")
    private String registration(User user){
        userService.save(user);
        //autologin
        securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());

        return "redirect:/index";
    }

}
