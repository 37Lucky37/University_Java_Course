package uni2024.kozub.homework.lab1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void createUser(User user) {
        String query = "INSERT INTO User (name, email, password, age, address, role_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) { // Додано RETURN_GENERATED_KEYS

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getAge());
            stmt.setString(5, user.getAddress());
            stmt.setInt(6, user.getRole() != null ? user.getRole().ordinal() + 1 : 1); // Встановіть роль за замовчуванням

            stmt.executeUpdate();

            // Отримання згенерованого ID
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Метод для отримання користувача за ID

    public User getUserById(int id) {
        String query = "SELECT * FROM User WHERE id = ?";
        User user = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));

                // Отримати роль користувача
                int roleId = rs.getInt("role_id");
                user.setRole(roleId == 1 ? Role.CUSTOMER : Role.ADMIN); // Встановіть роль
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }


    // Метод для оновлення інформації про користувача
    // Метод для оновлення інформації про користувача
    public void updateUser(User user) {
        String query = "UPDATE User SET name = ?, email = ?, password = ?, age = ?, address = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getAge());
            stmt.setString(5, user.getAddress());


            stmt.setInt(6, user.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void deleteUser(int id) {
        String query = "DELETE FROM User WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для отримання всіх користувачів
    public List<User> getAllUsers() {
        String query = "SELECT * FROM User";
        List<User> users = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
