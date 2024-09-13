package uni2024.kozub.homework.lab1;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Game game1 = new Game.GameBuilder("CS", Genre.ACTION, 10.67, 9.8, LocalDate.of(2022, 8, 30)).build();
        Game game2 = new Game.GameBuilder("Craft the World", Genre.STRATEGY, 20.3, 10.0, LocalDate.of(2014, 4, 25)).build();

        User user1 = new User("Kostya", "kostyakozyb@gmail.com", "123456789", "Toporivtsi");
        user1.addGameToWishList(game1);
        user1.addGameToWishList(game2);
        System.out.println(user1);
    }
}
