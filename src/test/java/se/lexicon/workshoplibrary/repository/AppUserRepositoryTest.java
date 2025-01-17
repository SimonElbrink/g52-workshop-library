package se.lexicon.workshoplibrary.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.workshoplibrary.entity.AppUser;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Test
    void testFindByUsername_found() {
        // Arrange
        AppUser testUser = new AppUser(0, "erik.larsson", "securePassword123!", LocalDate.now(), null);
        appUserRepository.save(testUser);

        // Act
        AppUser result = appUserRepository.findByUsername("erik.larsson");

        // Assert
        assertNotNull(result, "Expected a user to be found, but result was null.");
        assertEquals("erik.larsson", result.getUsername(), "Expected username to match the saved user's username.");
        assertEquals("securePassword123!", result.getPassword(), "Expected password to match the saved user's password.");
    }

    @Test
    void testFindByUsername_notFound() {
        // Act
        AppUser result = appUserRepository.findByUsername("elise.nilsson");

        // Assert
        assertNull(result, "Expected no user to be found, but a user was returned.");
    }
}