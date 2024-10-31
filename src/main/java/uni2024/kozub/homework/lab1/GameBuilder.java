package uni2024.kozub.homework.lab1;

import javax.validation.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class GameBuilder implements Builder {
    private String name;
    private String description;
    private Genre genre;
    private Platform platform;
    private Double price;
    private Double rating;
    private Integer ageRestriction;
    private LocalDate releaseDate;

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Game build() {
        Game game = new Game(name, description, genre, platform, price, rating, ageRestriction, releaseDate);

        Set<ConstraintViolation<Game>> violations = validator.validate(game);

        if (!violations.isEmpty()) {
            String errorMessage = violations.stream()
                    .map(v -> v.getPropertyPath() + " " + v.getMessage())
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Невалідні поля: " + errorMessage);
        }

        return game;
    }
}
