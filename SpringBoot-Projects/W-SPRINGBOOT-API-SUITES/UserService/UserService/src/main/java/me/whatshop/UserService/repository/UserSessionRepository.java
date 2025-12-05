package me.whatshop.UserService.repository;

import me.whatshop.UserService.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
public interface UserSessionRepository extends JpaRepository<UserSession, UUID> {
    Optional<UserSession> findBySessionToken(String sessionToken);
    List<UserSession> findByUserId(UUID userId);
    void deleteByExpiresAtBefore(OffsetDateTime now);

}
