package com.xinrui.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("msg", "后台返回值9999!");
        return "main";
    }

}
