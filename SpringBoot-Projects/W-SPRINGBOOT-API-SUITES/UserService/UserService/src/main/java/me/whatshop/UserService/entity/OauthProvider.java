package me.whatshop.UserService.entity;

import com.fasterxml.jackson.databind.JsonNode;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "oauth_providers", indexes = {
        @Index(name = "idx_oauth_providers_user_id", columnList = "user_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "unique_provider_user", columnNames = {"provider", "provider_user_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "provider_user_id", nullable = false)
    private String providerUserId;

    @Type(JsonType.class)
    @Column(name = "provider_data", columnDefinition = "jsonb")
    private JsonNode providerData;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;
}