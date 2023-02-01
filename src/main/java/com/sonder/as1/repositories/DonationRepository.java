package com.sonder.as1.repositories;

import com.sonder.as1.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update donation d set d.status = :status where d.id = :id",nativeQuery = true)
    void setState(@Param("status") Integer status, @Param("id") Integer id);
    @Query(value = "select * from donation where status = :status limit :offset,:count",nativeQuery = true)
    List<Donation> findByStatus(@Param("status") Integer status,@Param("offset") Integer offset,@Param("count") Integer size);
    Integer countAllByStatus(Integer status);
}
