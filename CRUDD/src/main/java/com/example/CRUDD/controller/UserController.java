package com.example.CRUDD.controller;


import com.example.CRUDD.entity.Users;
import com.example.CRUDD.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("users", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Users users){
        userService.saveUser(users);
        return "redirect:/logins";
    }

    @GetMapping("/logins")
    public String showLoginForm(Model model) {
        model.addAttribute("users", new Users());
        return "logins";
    }


    @PostMapping("/logins")
    public String loginUser(@ModelAttribute Users users, Model model, HttpSession session) {
        Optional<Users> existingUser = userService.findByUsername(users.getUsername());
        if (existingUser.isPresent() && existingUser.get().getPassword().equals(users.getPassword())) {
            session.setAttribute("loggedInUser", existingUser.get());
            return "redirect:/products";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "logins";
        }
    }

    @GetMapping()
    public String welcome() {
        return "welcome";
    }

}
