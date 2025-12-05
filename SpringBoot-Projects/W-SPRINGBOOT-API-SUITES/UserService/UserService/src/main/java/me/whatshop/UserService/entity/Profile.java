package me.whatshop.UserService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "profiles", indexes = {
        @Index(name = "idx_profiles_user_id", columnList = "user_id"),
        @Index(name = "idx_profiles_is_verified", columnList = "is_verified"),
        @Index(name = "idx_profiles_is_premium", columnList = "is_premium"),
        @Index(name = "idx_profiles_business_type", columnList = "business_type")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column
    private String name;  // From UserRegistrationRequest.name

    @Column(name = "business_type")
    private String businessType;  // Maps to UserRegistrationRequest.business_type

    @Column(name = "profile_picture_url")
    private String profilePictureUrl;

    @Column(name = "cover_photo_url")
    private String coverPhotoUrl;

    @Column(name = "is_premium", nullable = false)
    private boolean isPremium = false;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified = false;  // General verification (beyond email/phone)

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public void setIsPremium(boolean b) {
    }

    public void setIsVerified(boolean b) {
    }
}