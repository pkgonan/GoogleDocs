package com.kim.repository;


import com.kim.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneById(String id);
    User findByIdAndPassword(String id, String password);
}
