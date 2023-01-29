package com.sonder.as1.services;

import com.sonder.as1.entity.Donation;
import com.sonder.as1.repositories.DonationRepository;
import com.sonder.as1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DonationService implements EntityService<Donation> {
    private final DonationRepository donationRepository;
    private final UserRepository userRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository,
                           UserRepository userRepository) {
        this.donationRepository = donationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    @Override
    public void createEntity(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void updateEntity(Donation donation, Integer id) {

        Donation $ = getById(id);
    }

    @Override
    public Donation getById(Integer id) {
        Optional<Donation> $ = donationRepository.findById(id);
        $.orElseThrow(() -> new NoSuchElementException("Khong co dot quyen gop"));
        return $.get();
    }

    @Override
    public void deleteEntity(Integer id) {
        Donation $ = getById(id);
        donationRepository.deleteById($.getId());
    }
}
