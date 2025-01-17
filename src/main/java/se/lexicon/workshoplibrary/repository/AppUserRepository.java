package se.lexicon.workshoplibrary.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.workshoplibrary.entity.AppUser;

import java.time.LocalDate;
import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    /**
     * Finds an AppUser entity by its username.
     *
     * @param username the username of the user to find.
     * @return an optional containing the AppUser if found, or empty if not found.
     */
    AppUser findByUsername(String username);

    /**
     * Finds a list of AppUser entities whose registration date is between the two provided dates.
     *
     * @param startDate the start date of the range (inclusive).
     * @param endDate   the end date of the range (inclusive).
     * @return a list of AppUser entities matching the date range criteria.
     */
    List<AppUser> findByRegDateBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Finds all AppUser entities associated with a specific Details ID.
     *
     * @param detailsId the id of the associated Details entity.
     * @return a list of AppUser entities matching the criteria.
     */
    List<AppUser> findByDetails_Id(int detailsId);

    /**
     * Finds an AppUser entity by its email, ignoring case.
     *
     * @param email the email address to search for.
     * @return an optional containing the AppUser entity if found, or empty if no match is found.
     */
    AppUser findByDetails_EmailIgnoreCase(String email);

}
