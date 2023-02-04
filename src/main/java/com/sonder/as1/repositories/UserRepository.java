package com.sonder.as1.repositories;

import com.sonder.as1.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    void deleteById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "update users u set u.status = :status where u.id = :id",nativeQuery = true)
    void setState(@Param("status") Integer status, @Param("id") Integer id);
    @Query(value = "select * from users u where u.full_name like :data or u.phone_number like :data limit :offset,:count ",nativeQuery = true)
    List<User> findByUsernameOrPhoneNumber(@Param("data") String data,@Param("count") Integer size, @Param("offset") Integer offset);
    @Query(value = "select count(*) from users u where u.full_name like :data or u.phone_number like :data",nativeQuery = true)
    Integer findByUsernameOrPhoneNumber(@Param("data") String data);
    Optional<User> findUserByEmail(String email);
}
