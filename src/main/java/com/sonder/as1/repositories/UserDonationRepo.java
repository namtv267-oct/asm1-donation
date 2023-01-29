package com.sonder.as1.repositories;

import com.sonder.as1.entity.UserDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDonationRepo extends JpaRepository<UserDonation,Integer> {
}
