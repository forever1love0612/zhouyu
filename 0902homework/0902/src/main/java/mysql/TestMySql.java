package mysql;

import com.htsc.domain.User;

import java.sql.*;

public class TestMySql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1?"+
                "characterEncoding=utf-8&serverTimezone=GMT%2B8", "root", "Zy19941106~");
        String sql = "select * from user where username = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, "李四");
        ResultSet resultSet = prepareStatement.executeQuery();
        while (resultSet.next()){
//            User user = new User("zhouyu","Zy19941106~");
//            user.setId(resultSet.getInt("id"));
//            user.setUsername(resultSet.getString("username"));
            System.out.print(resultSet.getString("id") + " "+ resultSet.getString("username"));
        }
    }

}
