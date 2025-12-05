package me.whatshop.UserService.repository;
import me.whatshop.UserService.entity.OauthProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OauthProviderRepository extends JpaRepository<OauthProvider, UUID> {
    Optional<OauthProvider> findByProviderAndProviderUserId (String
                                                             provider, String providerUserId);
    Optional<OauthProvider> findByUserId(UUID userId);

}
