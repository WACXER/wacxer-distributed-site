package me.whatshop.UserService.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="password_reset_tokens", indexes = {
        @Index(name="idx_password_reset_tokens_user_id", columnList ="user_id"),
        @Index(name ="idx_password_reset_token_expires_at", columnList="expires_at")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name="user_id", nullable = false)
    private UUID userId;

    @Column(name="token", nullable=false , unique=true)
    private String token;

    @Column(name="expires_at", nullable=false)
    private OffsetDateTime expiresAt;

    @Column(name="used", nullable=false)
    private boolean used = false;

    @CreationTimestamp
    @Column(name="created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

}
