package repository.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import domain.Users;
import repository.DataSource;
import repository.interfaces.IUsersRepository;

public class JdbcBasedUsersRepository implements IUsersRepository {
    private DataSource dataSource;
    public JdbcBasedUsersRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public Users[] getAll(){
        String query = "SELECT * FROM users";
        List<Users> users = new ArrayList<Users>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int user_role_code = rs.getInt("user_role_code");
                String profile_picture = rs.getString("profile_picture");
                Users user = new Users( id, email, username, password, user_role_code, profile_picture);

                users.add(user);
            }
            return users.toArray(new Users[0]);

        }
        catch (SQLException e) {
            return new Users[0];
        }
        catch (Exception ex){
            return new Users[0];
        }
    };

    public int create(Users user){
        int status = 0;
        String query = "INSERT INTO users (email,username,password,user_role_code,profile_picture) VALUES(?,?,?,?,?)";
        try{
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserRoleCode());
            statement.setString(5, user.getProfilePicture());
            status = statement.executeUpdate();

            if (status > 0) {
                System.out.println("User added successfully");
            }
            return status;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    };

    public int update(Users user){
        String query = "UPDATE users SET email=?, username=?, password=?, user_role_code=?, profile_picture=? where id=?";
        int status = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,user.getEmail());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserRoleCode());
            statement.setString(5, user.getProfilePicture());
            statement.setInt(6, user.getId());
            System.out.println(statement);
            status = statement.executeUpdate();
            if (status > 0) {
                System.out.println("User altered successfully!");
            }
            return status;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    };

    public int delete(int id){
        String query = "DELETE FROM users where id=?";
        int status =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            status = statement.executeUpdate();
            if (status > 0) {
                System.out.println("User deleted successfully");
            }
            return status;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    };
}
