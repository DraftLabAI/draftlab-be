package com.example.draftlab.user;

import com.example.draftlab.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // findAll()은 JpaRepository에서 자동으로 제공됨
}