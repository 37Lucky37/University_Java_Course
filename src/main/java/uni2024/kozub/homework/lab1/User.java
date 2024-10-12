package uni2024.kozub.homework.lab1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String address;
    private Role role;
    private List<Game> wishList = new ArrayList<>();

    public User(){}

    @JsonCreator
    public User(@JsonProperty("name") String name, @JsonProperty("email") String email,
                @JsonProperty("password") String password, @JsonProperty("age") Integer age,
                @JsonProperty("address") String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.address = address;
        this.role = Role.CUSTOMER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public List<Game> getWishList() {
        return wishList;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addGameToWishList(Game game){
        wishList.add(game);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", address='" + address + '\'' +
               ", role=" + role +
               ", wishList=" + wishList +
               '}';
    }
}
