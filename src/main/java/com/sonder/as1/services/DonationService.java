package com.sonder.as1.services;

import com.sonder.as1.dto.ModelDto;
import com.sonder.as1.entity.Donation;
import com.sonder.as1.repositories.DonationRepository;
import com.sonder.as1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public ModelDto<Donation> getAll(Integer page, Integer size) {
        Page<Donation> donationPage = donationRepository.findAll(PageRequest.of(page-1,size, Sort.by("status","endDate").descending()));
        return new ModelDto<>("Thành công", "Danh sách đợt quyên góp",donationPage.stream().toList(),page,size,donationPage.getTotalPages());
    }
    public ModelDto<Donation> getAll(Integer page,Integer size,Integer status){
        int offset = page*size;
        List<Donation> donationPage = donationRepository.findByStatus(status,offset,size);
        Integer totalPage = donationRepository.countAllByStatus(status)/size;
        return new ModelDto<>("Thành công","",donationPage,page,size,totalPage);
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
    public void newCreate(Integer id){
        donationRepository.setState(1,id);
    }
    public void donating(Integer id){
        donationRepository.setState(2,id);
    }
    public void endedDonation(Integer id){
        donationRepository.setState(0,id);
    }
    public void closeDonation(Integer id){
        donationRepository.setState(3,id);
    }
}
