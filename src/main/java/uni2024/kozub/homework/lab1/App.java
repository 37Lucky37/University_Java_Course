package uni2024.kozub.homework.lab1;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        GameBuilder builder = new GameBuilder();
        builder.setName("CS:GO");
        builder.setDescription("None");
        builder.setGenre(Genre.ACTION);
        builder.setPlatform(Platform.PC);
        builder.setAgeRestriction(18);
        builder.setRating(9.8);
        builder.setPrice(10.5);
        builder.setReleaseDate(LocalDate.of(2010, 3, 1));
        Game game1 = builder.build();

        User user1 = new User("Kostya", "kostyakozyb@gmail.com", "123456789", "Toporivtsi");
        user1.addGameToWishList(game1);
        System.out.println(user1);
    }
}
