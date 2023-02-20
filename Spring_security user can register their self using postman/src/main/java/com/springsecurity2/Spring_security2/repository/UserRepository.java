package com.springsecurity2.Spring_security2.repository;

import com.springsecurity2.Spring_security2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUserName(String username);

    boolean existsByUserName(String userName);
}
