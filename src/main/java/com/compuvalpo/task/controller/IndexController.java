package com.compuvalpo.task.controller;

import com.compuvalpo.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("/")
@AllArgsConstructor
@CrossOrigin
public class IndexController {

    @Autowired
    private TaskService taskService;

    @GetMapping("")
    public String index(Model model){

        model.addAttribute("standardDate", new Date());
        model.addAttribute("taskList", this.taskService.findAll());

        return "index";
    }
}
