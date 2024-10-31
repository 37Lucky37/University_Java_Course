package uni2024.kozub.homework.lab1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class Game implements Comparable<Game> {
    @NotNull(message = "Назва не може бути порожньою")
    @Size(max = 100, message = "Назва повинна бути не довшою за 100 символів")
    private String name;

    @NotNull(message = "Опис не може бути порожнім")
    private String description;

    @NotNull(message = "Жанр не може бути порожнім")
    private Genre genre;

    @NotNull(message = "Платформа не може бути порожньою")
    private Platform platform;

    @NotNull(message = "Ціна не може бути порожньою")
    @DecimalMin(value = "0.0", inclusive = true, message = "Ціна має бути більше або дорівнювати 0")
    private Double price;

    @NotNull(message = "Рейтинг не може бути порожнім")
    @DecimalMin(value = "0.0", message = "Рейтинг має бути не менше 0")
    @DecimalMax(value = "5.0", message = "Рейтинг має бути не більше 5")
    private Double rating;

    @NotNull(message = "Вікове обмеження не може бути порожнім")
    @Min(value = 3, message = "Вікове обмеження має бути не менше 3")
    @Max(value = 18, message = "Вікове обмеження має бути не більше 18")
    private Integer ageRestriction;

    @NotNull(message = "Дата релізу не може бути порожньою")
    @PastOrPresent(message = "Дата релізу не може бути в майбутньому")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Game() {}

    @JsonCreator
    public Game(@JsonProperty("name") String name, @JsonProperty("description") String description,
                @JsonProperty("genre") Genre genre, @JsonProperty("platform") Platform platform,
                @JsonProperty("price") Double price, @JsonProperty("rating") Double rating,
                @JsonProperty("ageRestriction") Integer ageRestriction, @JsonProperty("releaseDate") LocalDate releaseDate) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
        this.rating = rating;
        this.ageRestriction = ageRestriction;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public int compareTo(Game other) {
        return other.getReleaseDate().compareTo(this.getReleaseDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return name.equals(game.name) && genre == game.genre && platform == game.platform && price.equals(game.price) && rating.equals(game.rating) && releaseDate.equals(game.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre, platform, price, rating, releaseDate);
    }

    @Override
    public String toString() {
        return "Game{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", genre=" + genre +
               ", platform=" + platform +
               ", price=" + price + "$" +
               ", rating=" + rating +
               ", ageRestriction=" + ageRestriction +
               ", releaseDate=" + releaseDate +
               '}';
    }
}



