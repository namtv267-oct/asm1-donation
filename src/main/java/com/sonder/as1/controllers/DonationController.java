package com.sonder.as1.controllers;

import com.sonder.as1.entity.Donation;
import com.sonder.as1.services.DonationService;
import com.sonder.as1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class DonationController {
    @Autowired
    private DonationService donationService;

    @GetMapping("/donation")
    public String donationPage(@ModelAttribute("donation") Donation donation
            , ModelMap modelMap
    ) {
        List<Donation> $D = donationService.getAll();
        modelMap.addAttribute("donations",$D);
        return "/admin/donation";
    }

    @PostMapping("/donation/create")
    public ModelAndView createDonation(@ModelAttribute("donation") Donation donation
    ) {
        donationService.createEntity(donation);
        return new ModelAndView("redirect:/admin/donation");
    }
    @PostMapping("/donation/update/{id}")
    public String updateDonation(@PathVariable("id") Integer id, @ModelAttribute("donation") Donation donation){
        donationService.updateEntity(donation, id);
        return "redirect:/admin/donation?success";
    }
    @PostMapping("/donation/delete/{id}")
    public String deleteDonation(@PathVariable("id") Integer id, @ModelAttribute("donation") Donation donation){
        donationService.deleteEntity(id);
        return "redirect:/admin/donation?success";
    }
    @GetMapping("donation/detail/{id}")
    public String detailDonation(@PathVariable("id") Integer id, ModelMap modelMap, @ModelAttribute("donation") Donation donation){
        modelMap.addAttribute("donation", donationService.getById(id));
        return "/admin/detail";
    }
}
