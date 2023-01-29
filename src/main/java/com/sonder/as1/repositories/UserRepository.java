package com.sonder.as1.repositories;

import com.sonder.as1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    void deleteById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "update users u set u.status = :status where u.id = :id",nativeQuery = true)
    void setState(@Param("status") Integer status, @Param("id") Integer id);
}
