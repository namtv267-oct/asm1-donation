package com.sonder.as1.services;

import com.sonder.as1.entity.UserDonation;
import com.sonder.as1.repositories.UserDonationRepo;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class UserDonationService implements EntityService<UserDonation>{
    private final UserDonationRepo userDonationRepo;
    private final DonationService donationService;
    private final UserService userService;
    @Autowired
    public UserDonationService(UserDonationRepo userDonationRepo, DonationService donationService, UserService userService) {
        this.userDonationRepo = userDonationRepo;
        this.donationService = donationService;
        this.userService = userService;
    }

    @Override
    public List<UserDonation> getAll() {
        return null;
    }

    @Override
    public void createEntity(UserDonation userDonation) {

    }
    public void createEntity(UserDonation userDonation, Integer userId, Integer donationId){
        userDonation.setDonation(donationService.getById(donationId));
        userDonation.setUser(userService.getById(userId));
        userDonationRepo.save(userDonation);
    }

    @Override
    public void updateEntity(UserDonation userDonation, Integer id) {

    }

    @Override
    public UserDonation getById(Integer id) {
        return null;
    }

    @Override
    public void deleteEntity(Integer id) {

    }
}
