package com.registromedico.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.registromedico.springboot.app.entities.User;
import com.registromedico.springboot.app.services.UserService;

@Controller
public class UserController {
	@Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationInit(Model model) {
        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, Model model) {
        user.setRole("ADMIN");
        userService.save(user);
        return "redirect:/miHistorial";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        return "login";
    }
    @RequestMapping(value = "/miHistorial/perfil")
    public String mostrarPerfil(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername (((org.springframework.security.core.userdetails.User)auth.getPrincipal()).getUsername());
        model.addAttribute("user",user);
        return "perfil";
    }



}
