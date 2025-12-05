package me.whatshop.UserService;

import me.whatshop.UserService.entity.Profile;
import me.whatshop.UserService.entity.User;
import me.whatshop.UserService.entity.UserType;
import me.whatshop.UserService.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserServiceApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testSaveUserWithProfile() {
        // Create a User
        User user = new User();
        user.setUsername("+1234567890");
        user.setEmail("test@example.com");
        user.setPasswordHash("hashed");
        user.setUserType(UserType.INDIVIDUAL);
        user.setEmailVerified(false);
        user.setPhoneVerified(false);
        //user.setIsActive(true);

        // Create a Profile
        Profile profile = new Profile();
        profile.setName("Test User");
        profile.setBusinessType("retail");
        profile.setIsPremium(false);
        profile.setIsVerified(false);

        // Set bidirectional relationship
        user.setProfile(profile);
        profile.setUser(user);

        // Save the User (cascades to Profile due to CascadeType.ALL)
        User saved = userRepository.save(user);

        // Verify the save
        assertNotNull(saved.getId());
        assertNotNull(saved.getProfile().getId());
        assertEquals("+1234567890", saved.getUsername());
        assertEquals("Test User", saved.getProfile().getName());
    }
}