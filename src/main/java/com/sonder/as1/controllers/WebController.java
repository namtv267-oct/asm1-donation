package com.sonder.as1.controllers;

import com.sonder.as1.entity.Donation;
import com.sonder.as1.entity.UserDonation;
import com.sonder.as1.services.DonationService;
import com.sonder.as1.services.UserDonationService;
import com.sonder.as1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final DonationService donationService;
    private final UserService userService;
    private final UserDonationService userDonationService;
    @Autowired
    public WebController(DonationService donationService, UserService userService,UserDonationService userDonationService) {
        this.donationService = donationService;
        this.userService = userService;
        this.userDonationService = userDonationService;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homePage(ModelMap modelMap, @ModelAttribute("donation") Donation donation, @ModelAttribute("userDonation")UserDonation userDonation){
        modelMap.addAttribute("donations", donationService.getAll());
        modelMap.addAttribute("users",userService.getAll());
        return "/public/home";
    }
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public String detailsPage(){
        return "/public/detail";
    }
    @RequestMapping(value = "/donation",method = RequestMethod.POST)
    public String donation(@ModelAttribute("userDonation")UserDonation userDonation,@RequestParam("idUser") Integer idUser,@RequestParam("idDonation") Integer idDonation){
//        UserDonation $ = new UserDonation();
//        $.setName(userDonation.getName());
//        $.setText(userDonation.getText());
//        $.setMoney(userDonation.getMoney());
        userDonationService.createEntity(userDonation,idUser,idDonation);
        return "redirect:/";
    }
}
