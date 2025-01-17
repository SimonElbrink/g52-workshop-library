package se.lexicon.workshoplibrary.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import se.lexicon.workshoplibrary.entity.Details;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DetailsRepositoryTest {

    @Autowired
    private DetailsRepository detailsRepository;

    @Test
    void testFindByEmail_found() {
        // Arrange
        Details details = new Details(0, "sven.svensson@example.com", "Sven Svensson", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        // Act
        Optional<Details> result = detailsRepository.findByEmail("sven.svensson@example.com");

        // Assert
        assertThat(result).isPresent();
        assertThat(result.get().getEmail()).isEqualTo("sven.svensson@example.com");
        assertThat(result.get().getName()).isEqualTo("Sven Svensson");
        assertThat(result.get().getBirthDate()).isEqualTo(LocalDate.of(1990, 1, 1));
    }

    @Test
    void testFindByEmail_notFound() {
        // Arrange
        Details details = new Details(0, "sven.svensson@example.com", "Sven Svensson", LocalDate.of(1990, 1, 1));
        detailsRepository.save(details);

        // Act
        Optional<Details> result = detailsRepository.findByEmail("nonexistent@example.com");

        // Assert
        assertThat(result).isNotPresent();
    }
}