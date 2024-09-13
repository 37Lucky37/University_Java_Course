package uni2024.kozub.homework.lab1;

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
    private LocalDate releaseDate;

    private Game(GameBuilder gameBuilder) {
        this.name = gameBuilder.name;
        this.description = gameBuilder.description;
        this.genre = gameBuilder.genre;
        this.platform = gameBuilder.platform;
        this.price = gameBuilder.price;
        this.rating = gameBuilder.rating;
        this.ageRestriction = gameBuilder.ageRestriction;
        this.releaseDate = gameBuilder.releaseDate;
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

    public static class GameBuilder {
        private String name;
        private String description;
        private Genre genre;
        private Platform platform;
        private Double price;
        private Double rating;
        private Integer ageRestriction;
        private LocalDate releaseDate;

        public GameBuilder(String name, Genre genre, Double price, Double rating, LocalDate releaseDate){
            this.name = name;
            this.genre = genre;
            this.price = price;
            this.rating = rating;
            this.releaseDate = releaseDate;
        }

        public GameBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public GameBuilder setPlatform(Platform platform) {
            this.platform = platform;
            return this;
        }

        public GameBuilder setAgeRestriction(Integer ageRestriction) {
            this.ageRestriction = ageRestriction;
            return this;
        }

        public Game build(){
            return new Game(this);
        }
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
               ", price=" + price +
               ", rating=" + rating +
               ", ageRestriction=" + ageRestriction +
               ", releaseDate=" + releaseDate +
               '}';
    }
}
