package com.sonder.as1.repositories;

import com.sonder.as1.entity.User;
import com.sonder.as1.entity.UserDonation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserDonationRepo extends JpaRepository<UserDonation,Integer> {
    @Query(value = "select * from user_donation ud where ud.donation_id = :id",nativeQuery = true)
    List<UserDonation> findUserDonationByDonationId(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "update user_donation ud set ud.status = :status where ud.id = :id",nativeQuery = true)
     void setStateStatus(@Param("status") Integer status, @Param("id") Integer id);
}
