package com.furniturestoreapi.accessingDataJPA;

import com.furniturestoreapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    Boolean existsByLogin(String login);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password  WHERE u.login = :login")
    void updatePassword(@Param("password") String password, @Param("login") String login);
}