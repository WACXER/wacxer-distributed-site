package me.whatshop.UserService.repository;

import me.whatshop.UserService.entity.Profile;
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
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Optional<Profile> findByUserId(UUID userId);

    @Query("SELECT p FROM Profile p WHERE p.user.userType = :userType AND p.isVerified = :isVerified")
    Page<Profile> findByUserTypeAndIsVerified(@Param("userType") UserType userType,
                                              @Param("isVerified") boolean isVerified,
                                              Pageable pageable);

    Page<Profile> findByIsPremium(boolean isPremium, Pageable pageable);
}