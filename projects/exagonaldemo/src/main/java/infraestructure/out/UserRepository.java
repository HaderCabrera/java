package infraestructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.entity.User;
import domain.service.UserService;
import infraestructure.config.DatabaseConfig;

public class UserRepository implements UserService {

    @Override
    public void createUser(User user) {
        String sql = "INSERT INTO user (name, email) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)){
            
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()){
                user.setId(generatedKeys.getLong(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findUserById(Long id) {

        String sql = "SELECT id, name, email FROM user WHERE id = ?";
        User user = null;
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setEmail(resultSet.getString("email"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;

    }

}
