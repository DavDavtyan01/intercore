package com.intercore.intercore.controller;


import com.intercore.intercore.model.User;
import com.intercore.intercore.repository.UserRepository;
import com.intercore.intercore.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class UserController {




    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/addUser")
    public String main(){
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(User user){
        userRepository.save(user);
        user.setActivationCode(UUID.randomUUID().toString());
        if (!StringUtils.isEmpty(user.getEmail())) {
            String text = String.format("Name: " + user.getName() + "\n"
                                      + "Surname: " + user.getSurname() + "\n"
                                      + "Phone number: " + user.getPhoneNumber() + "\n"
                                      + "Email: " + user.getEmail() + "\n"
                                      + "Message: " + user.getMessage() + "\n");
            emailService.sendSimpleMessage("User information", text);
        }
        return "redirect:/addUser";
    }
}
