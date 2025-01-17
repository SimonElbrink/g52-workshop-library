package se.lexicon.workshoplibrary.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)


public class AppUser {

    @Setter(AccessLevel.PROTECTED)
    private int id;

    @NonNull
    private String username;
    @NonNull
    private String password;

    private LocalDate regDate;

//    @NonNull
    private Details details;


}
