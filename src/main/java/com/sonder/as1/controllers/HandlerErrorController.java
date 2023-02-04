package com.sonder.as1.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

@Controller
public class HandlerErrorController implements ErrorController {
    @RequestMapping("/error")
    public String errorPage(ModelMap modelMap, HttpServletResponse response){
        modelMap.addAttribute("status",response.getStatus());
        return "/admin/error";
    }
}
