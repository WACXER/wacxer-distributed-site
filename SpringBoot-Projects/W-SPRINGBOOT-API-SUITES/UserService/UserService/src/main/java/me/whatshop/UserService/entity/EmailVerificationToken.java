package me.whatshop.UserService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="email_verification_tokens", indexes = {
        @Index(name="idx_email_verification_tokens_user_id", columnList = "user_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailVerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name ="user_id", nullable=false)
    private UUID userId;

    @Column(name = "token", nullable=false, unique= true)
    private String token;

    @Column(name ="expires_at", nullable=false)
    private OffsetDateTime expiresAt;

    @Column(name="used", nullable=false)
    private boolean used = false;

    @CreationTimestamp
    @Column(name="created_at", nullable=false, updatable = false)
    private OffsetDateTime createdAt;
}
