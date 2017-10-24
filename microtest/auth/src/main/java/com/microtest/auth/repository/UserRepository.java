package com.microtest.auth.repository;

import com.microtest.auth.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
    User save(User user);
    void deleteUserByUsername(String username);
}
