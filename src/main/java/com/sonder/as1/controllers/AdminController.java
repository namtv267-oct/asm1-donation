package com.sonder.as1.controllers;

import com.sonder.as1.entity.User;
import com.sonder.as1.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
    /**
     * User control
     */
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String homePage() {
        return "/admin/home";
    }
    @GetMapping("/detail")
    public String detailPage() {
        return "/admin/detail";
    }

    @GetMapping("/account")
    public String accountPage(
            @ModelAttribute("user") User user,
            ModelMap modelMap,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "5") int size
    ) {
        modelMap.addAttribute("pageConfig", userService.getAll(page,size));
        return "/admin/account";
    }

    @PostMapping("/account/create")
    public ModelAndView createAccount(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/admin/account?error");
        }
        userService.createEntity(user);
        return new ModelAndView("redirect:/admin/account?success");
    }
    @PostMapping("/account/update/{id}")
    public ModelAndView updateAccount(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,@PathVariable("id") Integer id){
        if (bindingResult.hasErrors()) {
            return new ModelAndView("redirect:/admin/account?error");
        }
        userService.updateEntity(user,id);
        return new ModelAndView("redirect:/admin/account?success");
    }
    @PostMapping("/account/delete/{id}")
    public ModelAndView deleteAccount(@PathVariable("id") Integer id){
        userService.deleteEntity(id);
        return new ModelAndView("redirect:/admin/account?success");
    }
    @PostMapping("/account/lock/{id}")
    public String lockAccount(@PathVariable("id") Integer id){
        userService.setLock(id);
        return "redirect:/admin/account?success";
    }
    @PostMapping("/account/un-lock/{id}")
    public String unLockAccount(@PathVariable("id") Integer id){
        userService.setUnLock(id);
        return "redirect:/admin/account?success";
    }
}
