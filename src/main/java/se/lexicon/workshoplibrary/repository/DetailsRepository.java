package se.lexicon.workshoplibrary.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.workshoplibrary.entity.Details;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DetailsRepository extends CrudRepository<Details, Integer> {

    /**
     * Finds the Details entity associated with the specified email address.
     *
     * @param email the email address to search for; must not be null.
     * @return an Optional containing the Details entity if found, or an empty Optional if no entity matches the provided email.
     */
    Optional<Details> findByEmail(String email);

    /**
     * Finds a list of Details entities where the name contains the specified string.
     *
     * @param name the substring to search for within the names of Details entities.
     * @return a list of Details entities whose names contain the specified substring.
     */
    List<Details> findByNameContains(String name);

    /**
     * Finds a Details entity where the name matches the provided parameter, ignoring case sensitivity.
     *
     * @param name the name to search for, case-insensitive
     * @return an Optional containing the matching Details entity if found, or an empty Optional if no match is found
     */
    Optional<Details> findByNameEqualsIgnoreCase(String name);

//    @NativeQuery(value = "SELECT * FROM Details WHERE UPPER(name) = UPPER(?1)")
//    @Query("SELECT d FROM Details d WHERE UPPER(d.name) = UPPER(:name)") // JPQL Syntax
//    List<Details> findDetailsByNameIgnoreCase( String name);


    /**
     * Retrieves a list of Details where the birthdate is between the given startDate and endDate.
     *
     * @param startDate the start date of the range (inclusive)
     * @param endDate   the end date of the range (inclusive)
     * @return a list of Details matching the specified birthdate range
     */
    List<Details> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);


}
