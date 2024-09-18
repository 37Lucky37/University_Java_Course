package uni2024.kozub.homework.lab1;

import java.io.File;
import java.io.IOException;
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

        File jsonFile = new File("users.json");
        JsonSerializer<User> serializer = new JsonSerializer<>();
        try {
            serializer.serialize(user1, jsonFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("From JSON: " + serializer.deserialize(jsonFile, User.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File xmlFile = new File("users.xml");
        XmlSerializer<User> xmlSerializer = new XmlSerializer<>();
        try {
            xmlSerializer.serialize(user1, xmlFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("From  XML:" + xmlSerializer.deserialize(xmlFile, User.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File yamlFile = new File("users.yaml");
        YamlSerializer<User> yamlSerializer = new YamlSerializer<>();
        try {
            yamlSerializer.serialize(user1, yamlFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("From YAML: " + yamlSerializer.deserialize(yamlFile, User.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
