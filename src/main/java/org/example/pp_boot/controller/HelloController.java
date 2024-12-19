package org.example.pp_boot.controller;

import org.example.pp_boot.model.User;
import org.example.pp_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUser();
        model.addAttribute("users", allUsers);
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/user/add")
    public String addNewUser(@ModelAttribute("user") User user, Model model) {

        model.addAttribute("user", user);
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user, Model model) {
        user.setId(id);
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
