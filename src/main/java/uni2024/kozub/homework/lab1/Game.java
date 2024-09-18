package uni2024.kozub.homework.lab1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private String name;
    private String description;
    private Genre genre;
    private Platform platform;
    private Double price;
    private Double rating;
    private Integer ageRestriction;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    public Game(){}

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
