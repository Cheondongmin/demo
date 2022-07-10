package com.system.testProject.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 메인 화면 이동 컨트롤러
     * @param model
     * @return
     */
    @GetMapping("/")
    public String mainPage(Model model){
        return "home";
    }
}
