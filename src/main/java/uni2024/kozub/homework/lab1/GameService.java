package uni2024.kozub.homework.lab1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    public List<Game> sortGamesByPrice(User user) {
        return user.getWishList().stream()
                .sorted(Comparator.comparing(Game::getPrice))
                .collect(Collectors.toList());
    }

    public List<Game> filterGamesByAgeRestriction(User user) {
        return user.getWishList().stream()
                .filter(game -> game.getAgeRestriction() <= user.getAge())
                .collect(Collectors.toList());
    }

    public List<Game> sortGamesByReleaseDate(User user) {
        List<Game> wishList = user.getWishList();
        Collections.sort(wishList);
        return wishList;
    }


}

