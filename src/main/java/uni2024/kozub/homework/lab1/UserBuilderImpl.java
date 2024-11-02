package uni2024.kozub.homework.lab1;

import javax.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserBuilderImpl implements UserBuilder {
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String address;
    private Role role = Role.CUSTOMER;
    private List<Game> wishList = new ArrayList<>();

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public UserBuilderImpl setId(Integer id) {
        this.id = id;
        return this;
    }

    @Override
    public UserBuilderImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserBuilderImpl setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public UserBuilderImpl setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public UserBuilderImpl setAge(Integer age) {
        this.age = age;
        return this;
    }

    @Override
    public UserBuilderImpl setAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilderImpl setRole(Role role) {
        this.role = role;
        return this;
    }

    public UserBuilderImpl setWishList(List<Game> wishList) {
        this.wishList = wishList;
        return this;
    }

    public User build() {
        User user = new User(name, email, password, age, address);
        user.setId(id);
        user.setRole(role);
        user.getWishList().addAll(wishList);

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty()) {
            String errorMessage = violations.stream()
                    .map(v -> v.getPropertyPath() + " " + v.getMessage())
                    .collect(Collectors.joining(", "));
            throw new IllegalArgumentException("Невалідні поля: " + errorMessage);
        }

        return user;
    }

}
