package uni2024.kozub.homework.lab1;

import java.time.LocalDate;

public interface Builder {
    void setName(String name);
    void setDescription(String description);
    void setGenre(Genre genre);
    void setPlatform(Platform platform);
    void setPrice(Double price);
    void setRating(Double rating);
    void setAgeRestriction(Integer ageRestriction);
    void setReleaseDate(LocalDate releaseDate);
}
