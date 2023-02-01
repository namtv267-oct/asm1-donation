package com.sonder.as1.controllers;

import com.sonder.as1.entity.Donation;
import com.sonder.as1.entity.UserDonation;
import com.sonder.as1.services.DonationService;
import com.sonder.as1.services.UserDonationService;
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
    @Autowired
    private UserDonationService userDonationService;

    @GetMapping("/donation")
    public String donationPage(
            @ModelAttribute("donation") Donation donation
            , @RequestParam(value = "page", defaultValue = "1") Integer page
            , @RequestParam(value = "size", defaultValue = "5") Integer size
            , ModelMap modelMap
            , @RequestParam(value = "filter", defaultValue = "200") Integer status
    ) {
        if(status == 200){
            modelMap.addAttribute("modelDonation", donationService.getAll(page, size));
        }else{
            modelMap.addAttribute("modelDonation",donationService.getAll(page,size,status));
        }
        return "/admin/donation";
    }

    @PostMapping("/donation/create")
    public ModelAndView createDonation(@ModelAttribute("donation") Donation donation
    ) {
        donationService.createEntity(donation);
        return new ModelAndView("redirect:/admin/donation");
    }

    @PostMapping("/donation/update/{id}")
    public String updateDonation(@PathVariable("id") Integer id, @ModelAttribute("donation") Donation donation) {
        donationService.updateEntity(donation, id);
        return "redirect:/admin/donation?success";
    }

    @PostMapping("/donation/delete/{id}")
    public String deleteDonation(@PathVariable("id") Integer id, @ModelAttribute("donation") Donation donation) {
        donationService.deleteEntity(id);
        return "redirect:/admin/donation?success";
    }

    @GetMapping("/donation/detail/{id}")
    public String detailDonation(@PathVariable("id") Integer id, ModelMap modelMap, @ModelAttribute("donation") Donation donation) {
        modelMap.addAttribute("donation", donationService.getById(id));
        modelMap.addAttribute("userDonations",userDonationService.getUserDonationByDonationId(id));
        return "/admin/detail";
    }

    @PostMapping("/donation/ended/{id}")
    public String endedDonation(@PathVariable("id") Integer id) {
        donationService.endedDonation(id);
        return "redirect:/admin/donation";
    }

    @PostMapping("/donation/starting/{id}")
    public String donatingDonation(@PathVariable("id") Integer id) {
        donationService.donating(id);
        return "redirect:/admin/donation";
    }

    @PostMapping("/donation/close/{id}")
    public String closeDonation(@PathVariable("id") Integer id) {
        donationService.closeDonation(id);
        return "redirect:/admin/donation";
    }
    @PostMapping("/donation/confirm/{id}")
    public String confirmDonation(@PathVariable("id") Integer id,@RequestParam("idUserDonation") Integer idUserDonation){
        userDonationService.setConfirm(idUserDonation);
        System.out.println(idUserDonation);
        return "redirect:/admin/donation/detail/" + id;
    }
    @PostMapping("/donation/un-confirm/{id}")
    public String unConfirmDonation(@PathVariable("id") Integer id,@RequestParam("idUserDonation") Integer idUserDonation){
        userDonationService.setUnConfirm(idUserDonation);
        return "redirect:/admin/donation/detail/" + id;
    }
}
