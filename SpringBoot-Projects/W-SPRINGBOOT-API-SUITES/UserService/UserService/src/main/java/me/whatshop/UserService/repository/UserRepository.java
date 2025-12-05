package me.whatshop.UserService.repository;

import me.whatshop.UserService.entity.User;
import me.whatshop.UserService.entity.UserType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    // Fixed method name: findByUserTypeAndEmailVerified (was findUserTypeAndEmailVerified)
    Page<User> findByUserTypeAndEmailVerified(UserType userType, boolean emailVerified, Pageable pageable);
}