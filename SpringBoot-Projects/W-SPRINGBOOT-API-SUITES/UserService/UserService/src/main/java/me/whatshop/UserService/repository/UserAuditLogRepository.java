package me.whatshop.UserService.repository;

import me.whatshop.UserService.entity.UserAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserAuditLogRepository extends JpaRepository<UserAuditLog, UUID> {
    List<UserAuditLog> findByUserId(UUID userId);
    List<UserAuditLog> findByAction(String action);
}