package com.ludijf.pongyclub.controller;

import com.ludijf.pongyclub.entity.Training;
import com.ludijf.pongyclub.service.WelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/public/welcome")
@CrossOrigin("${front.url}")
public class WelcomeController {

    WelcomeService welcomeService;

    @Autowired
    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }
    @GetMapping("/training")
    public List<Training> findTrainings() {
        return welcomeService.findTrainings();
    }

}
