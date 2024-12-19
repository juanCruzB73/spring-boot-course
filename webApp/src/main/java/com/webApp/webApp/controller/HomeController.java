package com.webApp.webApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        System.out.println("in home");
        return "index";
    }
    @RequestMapping("/add")
    public String add(@RequestParam("num1") int num1, @RequestParam("num2") int num3, Model model){

        int result = num1+num3;
        model.addAttribute("result",result);
        return "result";
    }

}
