package com.example.useremployee.repositories;

import com.example.useremployee.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// typen på din primary key skriver du inde i din <> og den model klasse som skal benyttes
public interface UserRepository extends JpaRepository<User, Integer> {
    default boolean existsByEmail(String mail) {
        return false;
    }
}
