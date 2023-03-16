package ru.javamentor.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javamentor.spring.model.User;
import ru.javamentor.spring.service.UserService;

@Controller
public class UserController {
    private final UserService serv;
    @Autowired
    public UserController(UserService serv) {
        this.serv = serv;
    }

    @GetMapping(value = "/")
    public String userModels(Model model) {
        model.addAttribute("users", serv.getAll());
        return "index";
    }
    @GetMapping("/new")
    public String createUserForm(User user) {
        return "user-create";
    }
    @PostMapping("user-create")
    public String createUser(User user) {
        serv.save(user);
        return "redirect:/";
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable(value="id") Long id) {
        serv.removeById(id);
        return "redirect:/";
    }
    @PostMapping("/edit/{id}")
    public String edit(Model model,@PathVariable("id")Long id) {
        model.addAttribute("person",serv.findById(id));
        return "update";
    }
    @PatchMapping("/update/{id}")
    public String updateUser(@ModelAttribute("person") User user,@PathVariable("id")Long id) {
        serv.update(user,id);
        return "redirect:/";
    }
}

