package uni2024.kozub.homework.lab1;

import java.util.List;

public interface UserBuilder {
    UserBuilder setName(String name);
    UserBuilder setEmail(String email);
    UserBuilder setPassword(String password);
    UserBuilder setAge(Integer age);
    UserBuilder setAddress(String address);
    UserBuilder setRole(Role role);
    UserBuilder setWishList(List<Game> wishList);
    User build();
}
