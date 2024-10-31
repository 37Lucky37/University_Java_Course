package uni2024.kozub.homework.lab1;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GameBuilder builder = new GameBuilder();
        builder.setName("CS:GO");
        builder.setDescription("None");
        builder.setGenre(Genre.ACTION);
        builder.setPlatform(Platform.PC);
        builder.setAgeRestriction(18);
        builder.setRating(4.0);
        builder.setPrice(10.5);
        builder.setReleaseDate(LocalDate.of(2010, 3, 1));

        Game game1 = null;
        try {
            game1 = builder.build();
            System.out.println("Гра створена успішно: " + game1);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилки валідації: " + e.getMessage());
        }

        User user1 = new User("Kostya", "kostyakozyb@gmail.com", "123456789", 18, "Toporivtsi");
        user1.addGameToWishList(game1);
        System.out.println(user1);

        builder.setName("A very long name exceeding the maximum limit of characters allowed in this field"); // порушує @Size
        builder.setDescription(null);
        builder.setGenre(null);
        builder.setPlatform(null);
        builder.setPrice(-10.0);
        builder.setRating(10.0);
        builder.setAgeRestriction(25);
        builder.setReleaseDate(LocalDate.now().plusDays(1));

        try {
            Game game = builder.build();
            System.out.println("Гра створена успішно: " + game);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилки валідації: " + e.getMessage());
        }


        // lab working with files

//        File jsonFile = new File("users.json");
//        JsonSerializer<User> serializer = new JsonSerializer<>();
//        try {
//            serializer.serialize(user1, jsonFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            System.out.println("From JSON: " + serializer.deserialize(jsonFile, User.class));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        File xmlFile = new File("users.xml");
//        XmlSerializer<User> xmlSerializer = new XmlSerializer<>();
//        try {
//            xmlSerializer.serialize(user1, xmlFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            System.out.println("From  XML:" + xmlSerializer.deserialize(xmlFile, User.class));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        File yamlFile = new File("users.yaml");
//        YamlSerializer<User> yamlSerializer = new YamlSerializer<>();
//        try {
//            yamlSerializer.serialize(user1, yamlFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            System.out.println("From YAML: " + yamlSerializer.deserialize(yamlFile, User.class));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // lab Collections

//        User user = new User("John Doe", "john@example.com", "password123", 17, "123 Main St");
//        Game game = new Game("Game A", "Desc A", Genre.ACTION, Platform.PC, 59.99, 8.5, 18, LocalDate.of(2021, 5, 10));
//        Game game2 = new Game("Game B", "Desc B", Genre.STRATEGY, Platform.PC, 39.99, 9.2, 12, LocalDate.of(2022, 8, 15));
//        Game game3 = new Game("Game C", "Desc C", Genre.RPG, Platform.Xbox, 29.99, 7.8, 16, LocalDate.of(2020, 3, 20));
//
//        user.addGameToWishList(game);
//        user.addGameToWishList(game2);
//        user.addGameToWishList(game3);
//
//        GameService gameService = new GameService();
//
//        System.out.println("Сортування за ціною:");
//        List<Game> sortedByPrice = gameService.sortGamesByPrice(user);
//        sortedByPrice.forEach(System.out::println);
//
//        System.out.println("\nІгри для віку користувача:");
//        List<Game> filteredByAge = gameService.filterGamesByAgeRestriction(user);
//        filteredByAge.forEach(System.out::println);
//
//        System.out.println("\nСортування за датою релізу:");
//        List<Game> sortedByReleaseDate = gameService.sortGamesByReleaseDate(user);
//        sortedByReleaseDate.forEach(System.out::println);
    }
}
