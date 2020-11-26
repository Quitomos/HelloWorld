package Basic;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection c = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8&serverTimezone=GMT",
                "root",
                "admin"
        ); Statement s = c.createStatement()){
            String sql = "select * from hero where hp = 616";
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " "
                        + rs.getString(2) + " "
                        + rs.getFloat(3) + " "
                        + rs.getInt("damage")
                );
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
